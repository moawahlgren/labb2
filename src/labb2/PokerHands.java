package psmodel;
import cardutils.*; 
import java.util.ArrayList;

/**
 *
 * @author SaraRoempke & MoaWahlgren
 */
public class PokerHands {
    
    public static PokerCombo getPokerCombo(Pile hand) {
        //Ska undersöka om det finns par, tvåpar, triss, färg, fyrtal 
        
        ArrayList handCopy = hand.getCards(); 
        Pile pileCopy = new Pile(); 
        pileCopy.add(handCopy);
        
        
        
        for (Suit value : Suit.values()) {
            int nrOfThatSuit = pileCopy.nrOfSuit(value); 
            if(nrOfThatSuit == 5) {
                return PokerCombo.FLUSH;
            }
        }
        
        for (Rank value : Rank.values()) {
            int nrOfThisRank = pileCopy.nrOfRank(value);
            if (nrOfThisRank == 2) {
                //Om det finns två av samma:
                //Ska isf gå igenom hela pile och söka kort med samma rank som det fanns två av
                //Removear dessa kort och letar sedan efter fler par genom att använda nrOfRank
                //Hittar den då en trea, returnera triss istället, hittar den två, returnera två par
                //Annars bara returnera par
                for (int j = 0; j < pileCopy.getSize(); j++) {
                    Card c = pileCopy.get(j);
                    if (c.getRank() == value) {
                        pileCopy.remove(c); 
                    }
                }
                for (Rank value1 : Rank.values()) {
                    int nrOfThatRank = pileCopy.nrOfRank(value1);
                    if(nrOfThatRank == 2) {
                        return PokerCombo.TWO_PAIRS;
                    }
                    if(nrOfThatRank == 3) {
                        return PokerCombo.THREE_OF_A_KIND; 
                    }
                }
                return PokerCombo.PAIR; 
            }
            if(nrOfThisRank == 3) {
                return PokerCombo.THREE_OF_A_KIND;
            }
            if(nrOfThisRank == 4) {
                return PokerCombo.FOUR_OF_A_KIND;
            } 
        }
        
        return PokerCombo.NONE; 
   
    }
    
}
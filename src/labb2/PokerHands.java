package ps;
import cardutils.*; 

/**
 *
 * @author moawahlgren
 */
public class PokerHands {
    
    
    private PokerHands() {
    //Konstruktor 
}
    public PokerCombo getPokerCombo(Pile hand) {
        //Ska undersöka om det finns par, tvåpar, triss, färg, fyrtal 
        //Bläddra igenom alla rank och kolla om det finns två (par), tre(triss), fyra(fytal) av någon rank.
        //Behöver sedan kolla om det finns fler par (kort av samma rank) 
        
        
        //Behöver först kolla om färg, och isf returnera detta, annars kolla om par eller så
        for(int i=0; i < 4; i++) {
            int nrOfThatSuit = hand.nrOfSuit(Suit.values()[i]); 
            if(nrOfThatSuit == 5) {
                return PokerCombo.FLUSH;
            }
        }
        
        for(int i=0; i < 13; i++) {
            int nrOfThisRank = hand.nrOfRank(Rank.values()[i]);
            
            if(nrOfThisRank == 2) {
                //Om det finns två av samma:
                //Ska isf gå igenom hela pile och söka kort med samma rank som det fanns två av
                //Removear dessa kort och letar sedan efter fler par genom att använda nrOfRank
                //Hittar den då en trea, returnera triss istället, hittar den två, returnera två par
                //Annars bara returnera par 
                for(int j=0; j < 5; j++) {
                    Card c = hand.get(j); 
                    if(c.getRank() == Rank.values()[i]) {
                        hand.remove(c); 
                    }
                }
                for(int k=0; k < 13; i++) {
                    int nrOfThatRank = hand.nrOfRank(Rank.values()[k]); 
                    
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
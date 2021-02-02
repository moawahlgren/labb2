/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psmodel;
import cardutils.Pile;
import cardutils.Suit;
import cardutils.Rank; 
import cardutils.Card; 
import java.util.ArrayList;

/**
 *
 * @author moawahlgren
 */
public class PokerHands {
    
    public static PokerCombo getPokerCombo(Pile hand) {
        //Ska undersöka om det finns par, tvåpar, triss, färg, fyrtal 
        //Bläddra igenom alla rank och kolla om det finns två (par), tre(triss), fyra(fytal) av någon rank.
        //Behöver sedan kolla om det finns fler par (kort av samma rank) 
        //Behöver först kolla om färg, och isf returnera detta, annars kolla om par eller så
        
        ArrayList handCopy = hand.getCards(); 
        Pile pileCopy = new Pile(); 
        pileCopy.add(handCopy);
        
        
        
        for(int i=0; i < Suit.values().length ; i++) {
            int nrOfThatSuit = pileCopy.nrOfSuit(Suit.values()[i]); 
            if(nrOfThatSuit == 5) {
                return PokerCombo.FLUSH;
            }
        }
        
        for(int i=0; i < Rank.values().length; i++) {
            int nrOfThisRank = pileCopy.nrOfRank(Rank.values()[i]);
            
            if(nrOfThisRank == 2) {
                //Om det finns två av samma:
                //Ska isf gå igenom hela pile och söka kort med samma rank som det fanns två av
                //Removear dessa kort och letar sedan efter fler par genom att använda nrOfRank
                //Hittar den då en trea, returnera triss istället, hittar den två, returnera två par
                //Annars bara returnera par 
                for(int j=0; j < pileCopy.getSize() ; j++) {
                    Card c = pileCopy.get(j); 
                    if(c.getRank() == Rank.values()[i]) {
                        pileCopy.remove(c); 
                    }
                }
                for(int k=0; k < Rank.values().length; k++) {
                    int nrOfThatRank = pileCopy.nrOfRank(Rank.values()[k]); 
                    
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
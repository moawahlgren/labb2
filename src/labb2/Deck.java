/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardutils;

/**
 *
 * @author moawahlgren
 */
public class Deck {
    
    //Aggregat av cards
    
    private Card[] theDeck;
    private int nrOfCards;

    public Deck() {
    theDeck = new Card[52];

    //create the 52 individual cards  
    }    

    public int getSize(){
        return 1;
    }
    
    public Card dealCard(Card c){
        return c;
    }
    
    public void shuffleCards(){
        
    }
    
    public void fill(){
        
    }
    
    @Override
    public String toString(){
        String info;
        return info;
    }

    
}

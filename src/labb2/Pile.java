package cardutils;
import java.util.*;

/**
 *
 * @author moawahlgren
 */
public class Pile {
    private ArrayList<Card> pile;
 
    public Pile() {
        pile = new ArrayList<>(); 
        //Konstruktorffff
    }
    
    public int getSize() {
        return pile.size(); 
    }
    
     public void clear() {
        pile.clear();  
    }
   
    public void add(Card c) {
        pile.add(c); 
    }
    
    public void add(ArrayList cards){
        pile.addAll(cards);
    }

    public Card get(int position) {
        return pile.get(position);  
    }
    
    public ArrayList getCards() {
        //Ska returnera kopia av privata listan med kort
        ArrayList<Card> copy = (ArrayList<Card>) pile.clone(); 
        return copy; 
        
    }
    
    public Card remove(int position) {
        return pile.remove(position);  
    }
    
    public boolean remove(Card c) {
        return pile.remove(c); 
    }
    
    public boolean contains(Card c) {
        return pile.contains(c); 
    }
    
    public boolean remove(ArrayList cards) {
        return pile.removeAll(cards);
    }
    
    public int nrOfSuit(Suit suit) {
        //Ska returnera antalet kort som matchar denna suit 
        //Bläddra igenom arraylist och plussa på nrOfSuits för varje "match"
        //If Card.getSuit = suit blabla  för alla index i arraylist(pile)
        int nrOfSuit = 0;
        int currentSize = getSize(); 
        for(int i=0; i<currentSize; i++) {
            Card c = get(i); 
            if(c.getSuit() == suit) {
                nrOfSuit ++;   
            }
        }
        return nrOfSuit; 
    }
    
    public int nrOfRank(Rank rank) {
        //Ska returnera antalet kort som matchar denna rank
        int nrOfRank = 0;
        int currentSize = getSize(); 
        for(int i=0; i<currentSize; i++) {
            Card c = get(i); 
            if(c.getRank() == rank) {
                nrOfRank ++; 
            }
        }
        return nrOfRank;  
    }
   
    public void addSorted(Card c) {
        pile.add(c); 
        Collections.sort(pile);
        //Ska lägga till ett kort och sortera korten i 
        //Pile-objektet enligt ordning definierad av Card.compareTo
    }
    
    @Override
    public String toString() {
        String info = ""; 
        //Skriva ut info om alla kort i pile?? Finns redan string info för cards så kankse 
        // bara hänvisa till alla kort på de index som finns i pile
        int currentSize = getSize(); 
        for(int i=0; i<currentSize; i++) {
            Card c = get(i); 
            info += c.toShortString(); 
            info += '\n'; 
        }
        return info; 
    }
}

    
}

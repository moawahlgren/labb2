package cardutils;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author SaraRoempke & MoaWahlgren
 */

public final class Deck {
        private final ArrayList<Card> theCards;


        public Deck() {
            theCards = new ArrayList<>();
            fill();
            
        } 

        public int getSize(){
            return theCards.size();
        }

        public Card dealCard(){
            Card c = theCards.get(theCards.size() - 1);
            theCards.remove(c);
            return c;
        }

        public void shuffleCards(){
            Collections.shuffle(theCards);
        }

        public void fill(){
            theCards.clear();
           
            for(Suit suit : Suit.values()){
              for(Rank rank : Rank.values()){
                 theCards.add(new Card(rank, suit));
                }
            }

        }

      
        @Override
        public String toString(){
            String info = " ";
            for(int i = 0; i < theCards.size(); i++){
                Card c = theCards.get(i);
                info += c.toShortString();
                info += "  ";
                if( i % 13 == 0 && i != 0){
                    info += '\n';
                }
            }
            return info;
        }

}

package cardutils;

import java.util.ArrayList;





public final class Deck {
        private ArrayList<Card> theCards;


        public Deck() {
            theCards = new ArrayList<>();
            fill();
            
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
                if( i % 4 == 0){
                    info += '\n';
                }
            }
            return info;
        }

}

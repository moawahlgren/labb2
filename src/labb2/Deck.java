/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardutils;

import java.util.ArrayList;



public final class Deck {
        private ArrayList<Card> theCards;

        //Konstruktorn skapar listan (ArrayList) samt de 52 unika korten
        //ska använda metoden fill 
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

      
        //@Override
        public String toString(){
            //StringBuilder builder = new StringBuilder();
            String info;
            for(int i = 0; i < theCards.size(); i++){
                info += "  " + 
            }
            return info;
        }


    
}

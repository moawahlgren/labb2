package labb2;


import java.util.Scanner;
import cardutils.*; 
import java.util.*;
import psmodel.*;
/**
 *
 * @author SaraRoempke & MoaWahlgren
 */
public class PsUserInterface {
    
    private final Scanner scan; 
    private final IPsLogic logic;
    public boolean pickNewCard = true;
    
    
    public PsUserInterface() {
        scan = new Scanner(System.in); 
        logic = new PsLogic();
    }
    
    //startar spelet
    public void run() {
        reset();
        char choice;
        String answer; 
        System.out.println("Welcome! Let's play poker squares. Make a choice from the menu.");
        
        //Loopar så länge färre än 25 kort är dragna och answer inte är x 
        
        do {
            if(pickNewCard){
                System.out.println("\n Place this card in a pile: " + logic.pickNextCard());
            }
            else{
                System.out.println("\n Place the same card in a different pile: ");
            }
            
            
            printMenu(); 
            answer = scan.nextLine(); 
            answer = answer.toUpperCase(); 
            choice = answer.charAt(0); 
            
            switch(choice) {
                case 'A': makeMove(0); printPiles(); break; 
                case 'B': makeMove(1); printPiles(); break; 
                case 'C': makeMove(2); printPiles(); break; 
                case 'D': makeMove(3); printPiles(); break; 
                case 'E': makeMove(4); printPiles(); break; 
                case 'R': reset(); printPiles(); break; 
                case 'X': System.out.println("Bye, bye! Your final score is: " + logic.getPoints()); break; 
                default: System.out.println("Unknown command"); pickNewCard = false;
            } 
        } while(choice != 'X' && logic.isGameOver() == false);
    }
    
    public void reset() {
        logic.initNewGame(); 
    }
    
    public Card showCard() {
        Card c = logic.pickNextCard(); 
        return c;//returnerar kortet överst i högen 
        
    }
    
    public void printPiles() {
        List<Pile> listOfPiles = logic.getPiles();
        
        StringBuilder string = new StringBuilder();
        for(int i=0; i < listOfPiles.size(); i++){
            Pile thisPile = listOfPiles.get(i);
            if(thisPile.getSize() == 5){
                string.append("Pile ").append(i+1).append(": ").append(thisPile.toString()).append("  ").append(PokerHands.getPokerCombo(thisPile));
                string.append("\n");
            }
            else{
                string.append("Pile ").append(i+1).append(": ").append(thisPile.toString());
                string.append("\n");
            }
            
        }
        System.out.print(string);
        System.out.println("Total points so far: " + logic.getPoints());
              
    }
    
    //Kontrollerar om högen är full, ser i sånt fall till att ett nytt kort inte plockas
    public void makeMove(int index) {
        List<Pile> listOfPiles = logic.getPiles();
        Pile thisPile = listOfPiles.get(index);
        if (thisPile.getSize() < 5) {
            
            logic.addCardToPile(index); 
            pickNewCard = true;
            
        }
        
        else {
            System.out.println("Pile " + (index+1) + " is full!\n");
            pickNewCard = false;
        }
    }
    
    public void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("(A) Add card to pile 1");
        System.out.println("(B) Add card to pile 2");
        System.out.println("(C) Add card to pile 3");
        System.out.println("(D) Add card to pile 4");
        System.out.println("(E) Add card to pile 5");
        System.out.println("(R) Reset");
        System.out.println("(X) Exit"); 
        System.out.println("----------"); 
    }
}    


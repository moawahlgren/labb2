/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;
import java.util.Scanner;
import cardutils.*; 
import psmodel.*;
import java.util.*;

/**
 *
 * @author SaraRoempke & MoaWahlgren
 */

public class PsUserInterface {
    private final Scanner scan; 
    IPsLogic logic = new PsLogic(); 
    
    public PsUserInterface() {
        scan = new Scanner(System.in);

    }
    
    public void run() {
        
        logic.initNewGame();
        char choice = ' ';
        boolean isOver = false; 
        int fullPile = 0; 
        // Behövs arraylist som vi kan fylla med kopiorna via getPiles?
        String answer; 
     
        System.out.println("Welcome! Let's play poker squares. Make a choice from the menu.");

        
        do {
            isOver = logic.isGameOver();
            if(fullPile == 0) {
                System.out.println("\n Place this card in a pile: " + logic.pickNextCard()); 
            }
            
            printMenu();
             
            answer = scan.nextLine(); 
            answer = answer.toUpperCase(); 
            choice = answer.charAt(0); //first character
            
            switch(choice) {
                case 'A': fullPile = makeMove(0); printPiles(); break; 
                case 'B': fullPile = makeMove(1); printPiles(); break; //Skickar index vidare till vilken hög ska adderas i
                case 'C': fullPile = makeMove(2); printPiles(); break; 
                case 'D': fullPile = makeMove(3); printPiles(); break; 
                case 'E': fullPile = makeMove(4); printPiles(); break; 
                case 'R': reset(); break; 
                case 'X': System.out.println("Bye, bye!"); break; 
                default: System.out.println("Unknown command");
            } 
        } while(choice != 'X' && isOver == false);
        
    }
    
    public void reset() {
        logic.initNewGame(); 
    }
    
    
    public void printPiles() {
        // Printar ut namnen på piles (typ pile A) etc och innehåll
        // Kanske också visa poäng eller pokercombo för full pile? 
            List<Pile> listOfPiles = logic.getPiles();
            
            for(int i=0; i < listOfPiles.size(); i++) {
                Pile thisPile = listOfPiles.get(i);
    
                System.out.println("Pile " + (i+1) + ": " + thisPile);
                if(thisPile.getSize() == 5) {
                    System.out.println(PokerHands.getPokerCombo(thisPile));
                }
                
            }
            System.out.println("Total points so far: " + logic.getPoints());
    }
    
    public int makeMove(int index) {
        List<Pile> listOfPiles = logic.getPiles();
        Pile thisPile = listOfPiles.get(index); 
        if (thisPile.getSize() < 5) {
            
            logic.addCardToPile(index); 
            return 0; 
            
        }
        
        else {
            System.out.println("Pile " + (index+1) + " is full!\n");
            return 1; 
        }
    }
    
    public void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("A Add card to pile 1");
        System.out.println("B Add card to pile 2");
        System.out.println("C Add card to pile 3");
        System.out.println("D Add card to pile 4");
        System.out.println("E Add card to pile 5");
        System.out.println("R Reset");
        System.out.println("X Exit"); 
        System.out.println("----------"); 
    }

}

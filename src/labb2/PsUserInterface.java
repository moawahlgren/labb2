
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
 * @author moawahlgren
 */

public class PsUserInterface {
    private final Scanner scan; 
    IPsLogic logic = new PsLogic(); 
    //Först ska kortet överst i kortleken visas för spelare
    //Spelare väljer en pile att flytta kortet till
    //Alla piles printas sedan ut och spelaren får välja
    //En ny pile att flytta detta kort till
    //När en pile innehåller 5 kort, så är denna "avslutad"
    //och bredvid den printas vilken pokerhand som var bäst i denna pile
    //och poängen för denna adderas 
    //När 25 kort är utdelade alt. alla högar är fyllda så
    //adderas poängen och skrivs ut. 
    //En funktion bör vara att resetta?? 
    //Kika på PsLogic för att nyttja metoderna där
    
    public PsUserInterface() {
        scan = new Scanner(System.in);
        
    }
    
    public void run() {
        
        logic.initNewGame();
        char choice = ' ';
        boolean isOver = false; 
        // Behövs arraylist som vi kan fylla med kopiorna via getPiles?
        String answer; 
        System.out.println("Welcome! Let's play poker squares. Make a choice from the menu.");
        
        //Sätt i en loop för medan färre än 25 kort är dragna 



         do {
            System.out.println("\n Place this card in a pile: " + logic.pickNextCard()); 
            
            printMenu();
             
            answer = scan.nextLine(); 
            answer = answer.toUpperCase(); 
            choice = answer.charAt(0); //first character
            isOver = logic.isGameOver(); 
            
            switch(choice) {
                case 'A': makeMove(0); printPiles(); break; 
                case 'B': makeMove(1); printPiles(); break; //Skickar index vidare till vilken hög ska adderas i
                case 'C': makeMove(2); printPiles(); break; 
                case 'D': makeMove(3); printPiles(); break; 
                case 'E': makeMove(4); printPiles(); break; 
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
        //Printar ut namnen på piles (typ pile A) etc och innehåll
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
    
    public void makeMove(int index) {
        List<Pile> listOfPiles = logic.getPiles();
        Pile thisPile = listOfPiles.get(index); 
        if (thisPile.getSize() < 5) {
            
            logic.addCardToPile(index); 
            
        }
        
        else {
            System.out.println("Pile " + (index+1) + " is full!\n");
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
package ps;
import java.util.Scanner;
import cardutils.*; 

/**
 *
 * @author moawahlgren
 */
public class PsUserInterface {
    private Scanner scan; 
    
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
    
    //main loop
    public void run() {
        char choice = ' ';
        // Behövs arraylist som vi kan fylla med kopiorna via getPiles?
        String answer; 
        System.out.println("Welcome! Let's play poker squares. Make a choice from the menu.");
        
        //Sätt i en loop för medan färre än 25 kort är dragna 
        
        do {
            System.out.println("\n Place this card in a pile: " + showCard()); 
            
            
            printMenu(); 
            answer = scan.nextLine(); 
            answer = answer.toUpperCase(); 
            choice = answer.charAt(0); //first character
            
            switch(choice) {
                case 'A': makeMove(); break; 
                case 'B': makeMove(); break; 
                case 'C': makeMove(); break; 
                case 'D': makeMove(); break; 
                case 'E': makeMove(); break; 
                case 'R': reset(); break; 
                case 'X': System.out.println("Bye, bye!"); break; 
                default: System.out.println("Unknown command");
            } 
        } while(choice != 'X');
    }
    
    public void reset() {
        IPsLogic.initNewGame(); 
    }
    
    public Card showCard() {
        return //return kortet överst i högen 
        
    }
    
    public void printPiles() {
        //Printar ut namnen på piles (typ pile A) etc och innehåll
        // Kanske också visa poäng eller pokercombo för full pile? 
    }
    
    public void makeMove() {
        IPsLogic.pickNextCard(); 
        IPsLogic.addCardToPile(); 
        //5 piles kommer vara i en array så att vi kan skicka in index på den 
        //pile som vi vill lägga kortet i? Eftersom addCardToPile tar ett int?
    }
    
    public void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("A Add card to pile A");
        System.out.println("B Add card to pile B");
        System.out.println("C Add card to pile C");
        System.out.println("D Add card to pile D");
        System.out.println("E Add card to pile E");
        System.out.println("R Reset");
        System.out.println("X Exit"); 
        System.out.println("----------"); 
    }
    public static void main(String[] args) {
        PsUserInterface menu = new PsUserInterface(); 
        menu.run(); 
    }
}

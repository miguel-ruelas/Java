
import java.util.Scanner;

/**
 * This Test class is used to play a game of Nim. It has all the 
 * methods needed for to play a game of Nim between a human player and a
 * computer.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Test.java
 */
public class Test {
    
    /**
     * intro() is called at the beginning of the game to give the user information
     * on how the game is played.
     */
    private static void intro() 
    {
        System.out.println("Nim is an ancient game with several variations!  "
                + "Here’s one: \n\nTwo players take turns removing marbles "
                + "from a pile. On each turn, \na player must remove at "
                + "least one but no more than half of the remaining marbles."
                + "\nThe player who is forced to remove the last marble "
                + "loses!!!");
        
    }
    /**
     * getName() asks the user for their name and returns it as a string.
     * @return  the users name.
     */
    private static String getName() 
    {
        Scanner scanner = new Scanner(System.in);      // scanner object to read KB
        System.out.println("Please enter your name:");
            String name = scanner.nextLine();          //get the users name from KB
        return name;                                  //return the users name as a string.
        
    }
    
    

    /**
     * main() creates two Player objects, and a Nim object. It then sends the 
     * players to the Nim object and begins the game by calling the Nim.play()
     * method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nim game;                             //holds a Nim object
        Boolean playAgain = false;            //used to see if user wants to play again.
        
        intro();                              //show user how to play the game
        
        do                                    //Loop to continue playing
        {
        int startSelection = selectStart();               //User selects to be first or second
        Player pcInstance =selectOpponent();              //User selects smart or stupid mode.
        HumanPlayer humInstance = new HumanPlayer(getName());   //Get user name and create user Player object
        if (startSelection == 1)                               //if user selected to go first put player object first
        {
            game = new Nim(humInstance, pcInstance);
        }
        else                                                  //if user selected to go second put player object second
        {
            game = new Nim(pcInstance, humInstance);
        }
        
        game.play();                                        //Play the game until over.
        playAgain = another();                              //ask user if they want to play again
        }while (playAgain);                                 //check users selection

    }
    /**
     * selectOpponent() is used to select smart or stupid mode of the game.
     * @return 
     */
    private static Player selectOpponent() 
    {
        int option;
        Player opponnent = null;
        Scanner scanner = new Scanner(System.in);// scanner object to read KB
        do 
        {
            System.out.println("\n1 for Smart mode"
                + "\n2 for Stupid mode"
                + "\nPlease enter a choice:");
            
            while (!scanner.hasNextInt()) 
            {
            System.out.println("\n\nThat's not a valid option!(not an int)\n\n"
                    + "\n1 for Smart mode"
                    + "\n2 for Stupid mode"
                    + "\nPlease enter a choice:");
            scanner.next(); 
            }
            
            option = scanner.nextInt();
            
            if (!(option==1 || option ==2))
            System.out.println("\n\nThat's not a valid option!(not 1/2)\n\n");
           
        }while (!(option==1 || option ==2));
      
        switch (option)
        { 
            case 1:
                opponnent = new SmartComputerPlayer("Smart Computer");
                break;
            case 2:
                opponnent = new StupidComputerPlayer("Stupid Computer");
                break;
        }
        return opponnent;
        
    }
    
    /**
     * selectStart() is used to select if user wants to go first or second.
     * @return 
     */
    private static int selectStart() 
    {
        int option;
        
        Scanner scanner = new Scanner(System.in);// scanner object to read KB
        do 
        {
            System.out.println("\n1 to go first"
                + "\n2 to go second"
                + "\nPlease enter a choice:");
            
            while (!scanner.hasNextInt()) 
            {
            System.out.println("\n\nThat's not a valid option!(not an int)\n\n"
                    + "\n1 to go first"
                    + "\n2 to go second"
                    + "\nPlease enter a choice:");
            scanner.next(); 
            }
            
            option = scanner.nextInt();
            
            if (!(option==1 || option ==2))
            System.out.println("\n\nThat's not a valid option!(not 1/2)\n\n");
           
        }while (!(option==1 || option ==2));
      
        
        return option;
        
    }
    
    /**
     * another() is used to ask the player if they want to play again.
     * @return 
     */
    private static Boolean another() {
        int option;
        Boolean keepPlaying = false;
        Scanner scanner = new Scanner(System.in);// scanner object to read KB
        do 
        {
            System.out.println("\n1 to play again"
                + "\n2 to exit"
                + "\nPlease enter a choice:");
            
            while (!scanner.hasNextInt()) 
            {
            System.out.println("\n\nThat's not a valid option!(not an int)\n\n"
                    + "\n1 to play again"
                    + "\n2 to exite"
                    + "\nPlease enter a choice:");
            scanner.next(); 
            }
            
            option = scanner.nextInt();
            
            if (!(option==1 || option ==2))
            System.out.println("\n\nThat's not a valid option!(not 1/2)\n\n");
           
        }while (!(option==1 || option ==2));
      
        switch (option)
        { 
            case 1:
                keepPlaying = true;
                break;
            case 2:
                keepPlaying = false;
                break;
        }
        return keepPlaying;
        
    }
    
}

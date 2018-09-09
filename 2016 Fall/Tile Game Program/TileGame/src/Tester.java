
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Tester is a program that simulates a game using the TileGame and NumberTile
 * classes.
 * @author Miguel A. Ruelas
 */
public class Tester {

    /**
     * The main class creates a TileGame object and 3 NumberTile ArrayLists.
     * 1 ArrayList for the game board and 2 for the players. It then uses the 
     * methods of the TileGame class to play the game.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean playAgain = false; //flag for loop to check if play again
        
        do
        {
            playAgain = false;// will terminate at end of loop
        
        //DEBUG\\ System.out.println ("** Creating Tilegame **");

        TileGame test = new TileGame(); // Create the game object
        
        //DEBUG\\System.out.println ("** Creating Player1's Hand **");
        
        //get an arraylist for player1
        ArrayList<NumberTile> player1 = test.getHand(); 
        
        //DEBUG\\System.out.println ("** Creating Player2's Hand **");
        
        //get an arraylist for player1
        ArrayList<NumberTile> player2 = test.getHand();
        
        //display player1's hand
        System.out.println ("***** Player 1's Initial Hand *****");
        System.out.println(player1.toString());
        
        //display player2's hand
        System.out.println ("\n***** Player 2's Initial Hand *****");
        System.out.println(player2.toString());
        
        //DEBUG\\System.out.println ("***** Creating Board *****");
        
        //Create a NumberTile ArrayList for the board 
        ArrayList <NumberTile> gameBoard = test.getBoard();
        gameBoard.add(new NumberTile()); //add a tile to the board
        
        //DEBUG\\System.out.println("Printing Board");
        //DEBUG\\System.out.println(gameBoard.toString());
        
        boolean gameOver= false; //flag to check if game is over.
        
        while (!gameOver) // check to see if game is over
        {
            
        //DEBUG\\    System.out.println ("***** Player 1's  move *****");
        
        
            test.makeMove(player1); //game is running player1 makes a move
            
        //DEBUG\\    System.out.println("player 1 has " + player1.size());
        //DEBUG\\    System.out.println(player1.toString());
        
            if (player1.size()==0) //check to see if player1 has any tiles
                gameOver=true;     //no tiles set gameover flag
            
        //DEBUG\\    System.out.println ("***** Player 2's  move *****");
        
            test.makeMove(player2); //player 2 makes a move
            
        //DEBUG\\   System.out.println("player 2 has " + player2.size());
        //DEBUG\\    System.out.println(player2.toString());
        
            if (player2.size()==0) //check to see if player2 has any tiles
                gameOver=true;     //no tiles set gameover flag
        } //loop continues until game over 
        
        //print board ArrayList to console 
        System.out.println("\n***** The Final Board *****");
        System.out.println(gameBoard.toString());
        
        //print player1's hand to console
        System.out.println ("\n***** Player 1's Final Hand *****");
        System.out.println(player1.toString());
        
        //print player2's hand to console
        System.out.println ("\n***** Player 2's Final Hand *****");
        System.out.println(player2.toString());
        
        
        if (player1.size()== player2.size())
             System.out.println ("\n***** This game is a tie *****");
        else if (player1.size()== 0)
            System.out.println ("\n***** The winner is Player 1 *****");
        else
            System.out.println ("\n***** The winner is Player 2 *****");
        
        System.out.println ("Play again? press \"y\" to continue");
        
        Scanner scanner = new Scanner(System.in);// scanner object to read KB
        String line = scanner.nextLine(); //string will hold input from user
        if (line.equals("y"))  //check to see if user
           playAgain= true; //runs another iteration of loop
            
        }while(playAgain==true);// checks to see if user selected "y"
                
    }
    
}

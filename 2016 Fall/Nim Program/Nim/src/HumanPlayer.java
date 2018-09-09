
import java.util.Scanner;

/**
 * The HumanPlayer class is used to play a game of Nim. It has all the 
 * methods needed for a human player to take part in a game of Nim.
 * The HumanPlayer's move() method asks the player how many marbles to remove 
 * from the pile. A player is only allowed to remove 1 to half the size of the 
 * pile. 
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = HumanPlayer.java
 */

public class HumanPlayer implements Player {
    private String name;                  //Holds the name of a player
    private int marbles;                  //Holds the number of marbles removed by the player
    
    /**
    * HumanPlayer() method is a constructor that receives a String and 
    * then calls the setName() method.
    * @param Name is a String that corresponds to the name of the player.
    */
    HumanPlayer(String Name) {
        
        setName(Name);    //Call the setName() method to set the name of the player.
    }

    
    
    /**
     * move() method overrides the Player interface method. It is used to
     * conducts a move in a game. It receives an integer that is the size of
     * the pile of marbles and then returns an integer that corresponds to
     * the amount of marbles to remove from the pile. The human player is 
     * allowed to remove 1 to half the current amount in the pile.
     * 
     * @param pileSize is the amount of marbles in the pile.
     * @return an integer with the number of marbles to remove from the pile.
     */
    @Override
    public int move(int pileSize)
    {
        
        Scanner scanner = new Scanner(System.in);    //scanner object to read KB
        int qty = 0;                                 //will hold input from user
        //get input from user.
        do                                         
        {
         System.out.println("Enter a number from " + 1 + " to " +
                 (pileSize/2));                          //display size options to remove
        
            while (!scanner.hasNextInt()) {              //check to make sure user typed an int
            System.out.println("That's not a number!");  //give error if its not an int
            scanner.next();                              //capture next input and test
            }
            qty = scanner.nextInt();                     //assign the int to qty
            
        }while (qty<=0 || qty > (pileSize/2));           //check to make sure amount to remove is valid
        marbles+= qty;                                   //add ammount to remove to players marbles
        return qty;                                      //return the amount to remove from the pile
    }
    
    /**
     * SetName() method gets the players name from constructor and sets it to
     * the name variable.
     */
    private void setName(String playerName)
    {
        name= playerName;            //initialize the name variable with the name received.
        
    }
    
    /**
     * getName() method is an accessor method that returns the players name.
     * @return 
     */
    @Override
    public String getName()
    {
      return name;  //return the players name.
    }
    
    /**
     * getMarbles() method is an accessor method that returns the amount of 
     * marbles removed from the pile by the player.
     * @return amount of marbles removed by the player.
     */
    @Override
    public int getMarbles()
    {
        return marbles;          //return the amount of marbles removed by the player.
    }
}

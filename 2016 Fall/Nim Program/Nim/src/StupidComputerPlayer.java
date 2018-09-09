
import java.util.Random;

/**
 * The StupidComputerPlayer class is used to play a game of Nim. It has all the 
 * methods needed for a player to take part in a game of Nim.
 * The StupidComputerPlayer removes a random number of marbles between 1 and 
 * n/2 each turn. It must receive a String with the name of the player.  
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = StupidComputerPlayer.java
 */
public class StupidComputerPlayer implements Player {
    private String name;                     //Holds the name of a player
    private int marbles;                     //Holds the number of marbles removed by the player

    /**
    * StupidComputerPlayer() method is a constructor that receives a String and 
    * then calls the setName() method.
    * @param Name is a String that corresponds to the name of the player.
    */
    StupidComputerPlayer(String Name) 
    {
        setName(Name);            //Call the setName() method to set the name of the player.             
    }    
    
    /**
     * move() method overrides the Player interface method. It is used to
     * conducts a move in a game. It receives an integer that is the size of
     * the pile of marbles and then returns an integer that corresponds to
     * the amount of marbles to remove from the pile. It selects the amount 
     * randomly from 1 to half of the current amount in the pile.
     * 
     * @param pileSize is the amount of marbles in the pile.
     * @return an integer with the number of marbles to remove from the pile.
     */
    @Override   
    public int move(int pileSize)
    {
        
        if (pileSize <= 3)         // Random Generator does not work well when its less than 3
        {
            marbles+= 1;           //if less than three add 1 to marbles removed and
            return 1;              //return 1 marble to be removed
        }
    
        int half=(pileSize/2);             //Divide the amount of marbles by 2
        Random generator = new Random() ;  //create random int generator
        int remove = generator.nextInt(half-1)+1 ; //get a random int from 1 to half the size.
 
        marbles+= remove;                  //add the amount removed to the total.
        return remove;                     //return the amount to be removed.
    }
    
    /**
     * SetName() method gets the players name from constructor and sets it to
     * the name variable.
     */
    private void setName(String playerName)
    {
       
        name= playerName;             //initialize the name variable with the name received.
        
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
        
        return marbles;        //return the amount of marbles removed by the player.
    }
    
}

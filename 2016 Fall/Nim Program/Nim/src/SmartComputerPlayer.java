
import java.util.Random;

/**
 * The SmartComputerPlayer class is used to play a game of Nim. It has all the 
 * methods needed for a player to take part in a game of Nim.
 * The SmartComputerPlayer removes removes exactly enough marbles to make the 
 * remaining pile a power of two minus one (1, 3, 7, 15, 31, or 63).
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = SmartComputerPlayer.java
 */
public class SmartComputerPlayer implements Player {
    private String name;                  //Holds the name of a player
    private int marbles;                  //Holds the number of marbles removed by the player
    
    /**
    * SmartComputerPlayer() method is a constructor that receives a String and 
    * then calls the setName() method.
    * @param Name is a String that corresponds to the name of the player.
    */
    SmartComputerPlayer(String Name) {
    
        setName(Name);             //Call the setName() method to set the name of the player.         
    }

    
    
    /**
     * move() method overrides the Player interface method. It is used to
     * conducts a move in a game. It receives an integer that is the size of
     * the pile of marbles and then returns an integer that corresponds to
     * the amount of marbles to remove from the pile. It selects the amount 
     * so that the remaining pile size is a power of two minus one (1, 3, 7, 15,
     * 31, or 63).
     * 
     * @param pileSize is the amount of marbles in the pile.
     * @return an integer with the number of marbles to remove from the pile.
     */
    @Override
    public int move(int pileSize)
    {
   
        int half = pileSize/2;         //Divide the amount of marbles by 2
        int remove;                    //will hold the amount to be removed
            
        if (pileSize> 63 && ((pileSize-63)<=half))    //check to see if pile size is over 63
        {
            remove = pileSize-63;                     //the amount needed to make the pile 63
            marbles+= remove;                         //add the amount to be removed to the marbles counter
            return remove;                            //return the amount needed to make the pile 63
        }
        else if (pileSize>31 && ((pileSize-31)<=half)) //check to see if pile size is over 31
        {
            remove = pileSize-31;                      //the amount needed to make the pile 31
            marbles+= remove;                          //add the amount to be removed to the marbles counter
            return remove;                             //return the amount needed to make the pile 31
        }
        else if (pileSize>15 && ((pileSize-15)<=half)) //check to see if pile size is over 15
        {
            remove = pileSize-15;                       //the amount needed to make the pile 15
            marbles+= remove;                          //add the amount to be removed to the marbles counter
            return remove;                              //return the amount needed to make the pile 15
        }
        else if (pileSize>7 && ((pileSize-7)<=half))  //check to see if pile size is over 7
        {
            remove = pileSize-7;                      //the amount needed to make the pile 7
            marbles+= remove;                         //add the amount to be removed to the marbles counter
            return remove;                            //return the amount needed to make the pile 7
        }
        else if (pileSize>3 && ((pileSize-3)<=half))   //check to see if pile size is over 3
        {
            remove = pileSize-3;                        //the amount needed to make the pile 3
            marbles+= remove;                           //add the amount to be removed to the marbles counter
            return remove;                              //return the amount needed to make the pile 3
        }
        else if (pileSize>1 && ((pileSize-1)<=half))    //check to see if pile size is over 1
        {
            remove = pileSize-1;                        //the amount needed to make the pile 1
            marbles+= remove;                           //add the amount to be removed to the marbles counter
            return remove;                              //return the amount needed to make the pile 1
        }
        else if (pileSize == 3)                         //above code does not work if pile size is 3
        {                                               //if pile is 3, remove 1 from pile
            marbles+= 1;                                //add 1 to marbles counter 
            return 1;                                   //return 1 to be removed from pile
        }
        else                                            //The above code does not work if computer is not first
        {                                               //Generate a random number to be removed from pile
            Random generator = new Random() ;           //create random int generator
            remove = generator.nextInt(half-1)+1 ;      //get a random int from 1 to half the size of the pile
            marbles+= remove;                           //add the number to be removed to the marbles counter
            return remove;                              //return the random number
        }   
    }
    
    /**
     * SetName() method gets the players name from constructor and sets it to
     * the name variable.
     */
    private void setName(String playerName)
    {
    
        name= playerName;
        
    }
    
    /**
     * getName() method is an accessor method that returns the players name.
     * @return 
     */
    @Override
    public String getName()
    {
    //Debug\\     System.out.println ("** Entering SmartComputerPlayer getName() **");
      return name;  
    }
    
    /**
     * getMarbles() method is an accessor method that returns the amount of 
     * marbles removed from the pile by the player.
     * @return amount of marbles removed by the player.
     */
    @Override
    public int getMarbles()
    {
    //Debug\\     System.out.println ("** Entering SmartComputerPlayer getMarbles() **");
        return marbles;
    }
}

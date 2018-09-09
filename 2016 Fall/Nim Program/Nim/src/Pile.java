import java.util.Random;

/**
 * The Pile Class is used to create and maintain a pile of marbles for a game
 * of Nim. It has an two integer variables, one holds the initial size of the 
 * pile and the other holds the current size of the pile. It has methods to
 * return the current size and to remove marbles from the pile.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename= Pile.Java
 */

public class Pile {
    int size;                            //holds the initial size of the pile.
    int currentSize;                     //holds the current size of the pile.
    
    /**
     * Pile() method overrides the default constructor. It creates a random
     * seed generator that is used to initiate the size variable with a random
     * integer between 10 and 100. The currentSize variable then recieves a copy
     * of the integer in size and all operations are made the the currentSize 
     * variable.
     */
    public Pile()
    {        
        Random generator = new Random() ;  //create random int generator
        int size = generator.nextInt(90)+10 ; //get a random int from 10 to 100
        currentSize = size;                   //Copy size to currentSize
    
    }
    
    /**
     * removeMarbles() is a mutator method that is used to remove marbles from
     * the pile by decreasing the currentSize variable.
     * @param qty is an integer variable used to decrease currentSize by that amount.
     */
    public void removeMarbles(int qty)
    {
        currentSize -= qty;             //decrease currentSize by the amount received in qty.
    }
    
    /**
     * getSize() method is an accessor method that returns currentSize as an 
     * integer.
     * 
     * @return an integer that corresponds to the current size of the pile of
     * marbles.  
     */
    public int getSize()
    {
    
        return currentSize; //return the curentSize.
        
    }
    
}


/**
 *NumberTile class is an ArrayList of Integer objects. Its constructor creates
 * 4 random Integer objects and inserts them into an ArrayList. Its methods
 * conduct operation on the Integer objects inside the ArrayList.
 * <P>
 * @author     Miguel A. Ruelas
 * Filename    NumberTile.java
 */
import java.util.ArrayList ;
import java.util.Random ;

public class NumberTile 
{
    private ArrayList<Integer> tile ; //can hold a reference to an ArrayList
    
    /** NumberTile constructor creates an Integer ArrayList and adds
     * 4 random integers in the range of 1 to 9 to the ArrayList.
     * 
     */
    public NumberTile() 
    {
    
    //DEBUG\\ System.out.println ("** Entering NumberTile() **");
        
        tile = new ArrayList<Integer>(); //Creates an ArrayList of Integers
                
        for ( int i = 0 ; i < 4 ; i++ ) //loop to add 4 random ints
        {
        Random generator = new Random() ;  //create random int generator
        int num = generator.nextInt(9)+1 ; //get a random int from 1 to 9
        tile.add (num);                    //add the int to the ArrayList
        }
        
    //DEBUG\\ System.out.print (toString());               
    //DEBUG\\ System.out.println ("** Exit NumberTile() **"); 
        
    }
    
    
    /**
     * rotate method removes the last object in the ArrayList and puts it in
     * the first location. This moves all objects back 1 position, effectively
     * rotating the tile 90 degrees.
     */    
    public void rotate() 
    {
    
    //DEBUG\\ System.out.println ("** Entering rotate() **");
        
        int tempHold = tile.get(3); //temp location for last tile
        tile.remove(3);             //remove the last tile
        tile.add(0, tempHold);      //insert the temp tile at the begning
     
    //DEBUG\\ System.out.println ("** Exit rotate() **"); 
        
    }
    
    /**
     * getLeft is an Accessor method that returns the value in the left position
     * of the tile (index 0).
     * @return index 0, value at left location of tile.
     */
    public int getLeft() 
    {
        return tile.get(0) ; //return value at left location of tile.
    }
    
    /**
     * getRight is an Accessor method that returns the value in the right
     * position of the tile (index 2).
     * @return index 2, value at right location of tile.
     */
    public int getRight() 
    {
        return tile.get(2) ;
    }

    /**
     * toString overrides the ArrayList method and returns a formated string
     * that can be sent to console. This displays an individual tile in console.
     * returns the tile as a string in the form :
     *     4
     *  5     7
     *     1
     * @return returns a formated string object that can be used to display a 
     *         tile
     */
    @Override
    public String toString() 
    {
        //create a formatted string
        String out = "\n    " + tile.get(1) + "\n " + tile.get(0) + "     " +
                     tile.get(2) + "\n" + "    " + tile.get(3) +"\n" ; 
        
        return out; // return the formatted string
    }
    
} // end of NumberTile class

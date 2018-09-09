
/**
 * The KnightsTour class is used to hold and make operations on Knight and
 * ChessBoard objects. It creates an array for the Knight and another
 * for the ChessBoard objects. It has variables to hold information relating
 * to the tour conducted by the Knights.
 *<p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = TileGame.Java
 *
*/
package the.knights.tour;

/**
 * KnightsTour is a public class that has all the methods needed to operate on
 * the objects of a Tour. To use KnightsTour, the external class/program will
 * need code to create and hold a KnightsTour object (to initiate the class), 
 * and call the makeTour() method with the number of tours to run.
 * 
 * <P>
 */
public class KnightsTour {
    private int longTour = 0;             //the number of moves of the longest tour
    private int longKnight;                 //element of longest knight
    private int [] numTour = new int [65];  //how many tours of each length were done
    private boolean debug = false;          //Flag to enable debug featurs
    ChessBoard [] boards ;                  //Array to hold board objects
        Knight [] knights ;                 //Array to hold Knight objects
    
    /**
     * KnightsTour is an overloaded constructor receives an integer to enable 
     * the debug features.
     * @param option if 1 is received the debug features are enabled.
     */
    public KnightsTour(int option)
    {
        if (option ==1)
            debug = true; //enable debug
    }
    /**
     * KnightsTour is the empty parameter constructor.
     */
    public KnightsTour()
    {
        
    }
    /**
     * makeTour() method receives an integer that is used to initialize the
     * board and knights arrays. It then attempts to make a move with each night
     * until no move moves are available.
     * @param number an integer that corresponds to the number of tours to run.
     */
    public void makeTour(int number)
    {
         if (debug==true)
        {
            System.out.println("***Entering makeTour()");
        }
        
        
        
        
        boards = new ChessBoard [number];
        knights = new Knight [number];
        for (int count = 0; count < number; count++)
        {
            

            Knight tempKnight = new Knight();                //create Knight objects
            knights[count] = tempKnight;
            int tempMoves;
            ChessBoard tempBoard = new ChessBoard(tempKnight); //create ChessBoard
            boards[count]= tempBoard;
            while (tempKnight.move(tempBoard))                 //have the Knight move until there are no more legal moves
            {
                if (debug==true)
                 {
                     System.out.println("***Entering getLongestRecord() +"
                             + "moved.");
                     String test = tempBoard.toString();
                
                }
                
                
            }
            tempMoves =tempBoard.getTotalMoves();                  //get the number of moves for this board
            numTour[tempMoves]++;                                  // increment the counter of moves of each tour length
            if (tempMoves>longTour)                                //find the longest tour
            {
                longTour=tempMoves;                                 //set the longest tour
                longKnight= count;                                  //set the longest tour
            }
            if (debug==true)
                 {
                     System.out.println("***Entering getLongestRecord() "
                             + "Knight #" + count + " " +
                    tempBoard.getTotalMoves());  
                     String test = tempBoard.toString();
                     System.out.println(test);
                }
                               
        }
        
    }
    
/**
 * getLongest() returns the number of moves of the longest tour.
 * @return  an integer showing the number of moves in the longest tour.
 */
    public int getLongest()
    {
        if (debug==true)
        {
            System.out.println("***Entering getLongest()");
        }
        return longTour;  // return integer
    
    }
    /**
     * getLongestRecord() returns a formated string with the information
     * of the longest run.
     * @return a formatted string with the board and number of moves of the 
     *         longest run.
     */
    public String getLongestRecord()
    {
        
        if (debug==true)
        {
            System.out.println("***Entering getLongestRecord()");
        }
       
       // if (longTour==64)
        //{
        //    String record = ("Tour number: " + longKnight + "\n" +
        //        "Number of Moves: " + longTour + " (a complete tour)\n"+
        //        "====================================="+ "\n" +
         //       boards[longKnight].toString());
       // }
        
        String record = ("Tour Number: " + longKnight + "\n" +
                boards[longKnight].toString());                //Create the string
        
        return record;   //return the string
    }
    /**
     * getNumTour() returns the count of each tour length as a formatted string.
     * @return  a formatted string
     */
    public String getNumTour()
    {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < numTour.length; index++)    //create the string
        {
            if (index<10)
            {
            result.append("Tours with  ");
            result.append(index + " move(s): " + numTour[index] + "\n");
            }
            else
            {
            result.append("Tours with ");    
            result.append(index + " move(s): " + numTour[index] + "\n");
            }
        }
        return result.toString(); //Return the string.
        
    }
    
}


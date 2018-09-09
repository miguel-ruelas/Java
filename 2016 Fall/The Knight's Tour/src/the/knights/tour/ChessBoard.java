/**
 * The ChessBoard class is a 8X8 2 dimensional Array that can hold an integer.
 * The integer reflects the number of the move an object has taken to reach 
 * the location on the board.Its methods conduct operation on the integer 
 * elements inside the Array.
 * <p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = ChessBoard.Java
 */
package the.knights.tour;

import java.util.Arrays;


public class ChessBoard {
    public final int [][] board = new int[8][8] ;  //2D array to hold moves on board.
    private boolean debug = false;                 //Flag for debug feature
    private int numMoves = 0;                      //Holds the total number of moves done.
    
/**
 * ChessBoard constructor accepts a Knight object and and integer. The Knight
 * object is used to call an overloaded constructor and the integer is used
 * to toggle on the debug feature of the program.
 * <P>
     * @param knight used to get the initial location of the knight.
     * @param option when the integer 1 is received it will turn on the 
     *               debug feature.
 */
    public ChessBoard(Knight knight, int option)
    {
        this(knight);         //Call overloaded constructor to get initial location.
     if (option ==1)          //Turn on Debug feature
         debug= true;  
        
    }
    /**
    * ChessBoard constructor accepts a Knight object. The Knight
    * is used to get its initial location on the board. This constructor
    * places a 1 on the initial location and increments numMoves.
    * <P>
    * @param knight used to get the initial location of the knight.
    *  
    */
    public ChessBoard(Knight knight)
    {
       int initRow = knight.getRow();   //Get the Knights Row
       int initCol = knight.getCol();   //Get the Knights Column
       board[initRow][initCol] = 1;     //Place the Knight on the board
       numMoves++;                      //increment moves
    
    }
        /**
     * The legalMove() method accepts two integer parameters. It then checks to
     * to see if the pair coincide with a location on the board. If the spot is 
     * on the board it then will check if it has been visited by a Knight
     * object. 
     * @param row receives an integer that corresponds to row on the board
     * @param col receives an integer that corresponds to the column on the
     *            board.
     * @return    returns true if the move is allowed.
     */
    public boolean legalMove(int row, int col)
    {
        //Check debug flag
        if (debug==true)
        {
            System.out.println("***Entering ChessBoard LegalMove()"
                    + " received " + row + " " + col);
            
        }
        
        if (row <0 || col <0)           //test if row and col are not within bounds
        {
            if (debug==true)
            {
            System.out.println("***ChessBoard LegalMove() False");
            }
            return false;                //return false if row or col is negative
        }
        else if (row>7|| col>7)         //test if row and col are not within bounds
        {
            if (debug==true)
            {
                System.out.println("***ChessBoard LegalMove() False");
            }
            return false;             // return false if row or col are above 7
        }
        else
        {
            if (debug==true)
            {
                System.out.println("***ChessBoard LegalMove() Checking Visit");
                System.out.println("***ChessBoard LegalMove()"
                        + (board[row][col]== 0));
            }
        return board[row][col]== 0;     //test if has not been visited if 0 then it has not been visited.
        }
               
    }
    /**
     * The placeNum() method accepts two integer variables that coincide with a
     * location on the board. This method should only be called after confirming 
     * the move is a legal move. It then will place a number (numMoves) on a given row 
     * and column.
     * 
     * @param row Row of where the object has moved to.
     * @param col Col of where the object has moved to.
     */
    public void placeNum(int row, int col)
    {
         if (debug==true)
        {
            System.out.println("***Entering placeNum()");
        }
        board [row] [col] = ++numMoves;        // Place numMoves on the location
        if (debug==true)
        {
            System.out.println("placeNum() numMoves now " + numMoves);
        }
    }
    /**
     * getTotalMoves() method returns the total number of moves made on the 
     * board.
     * 
     * @return an integer that is the total number of moves made on the board.
     */
    public int getTotalMoves()
    {
        return numMoves;
    }
    
    /**
     * The toString() method is overridden and can return a representation of the 
     * board as multi-line string.
     * 
     * @return a formated string of the number of moves, whether it was a 
     *         perfect or complete tour and all the board locations and their
     *         status. A number on the board is the move number, an * means
     *         the knight object did not visit this location.
     */
    @Override
    public String toString()
    {
        if (debug==true)
        {
            System.out.println("***Entering ChessBoard toString()");
        }
        
        StringBuilder result = new StringBuilder();       //will be used to build the string object to return.
        String newLine = "\n";                            //used to append a newline to the string object.
        
        result.append("Number of Moves: " + numMoves);    //Add the moves to the string.
        if (board[0][1]==64 || board[1][0]==64)           //Check to see if it was a perfect tour.
            result.append("(a perfect tour)"); 
        else if (numMoves==64)                            //Check to see if it was a complete tour.
            result.append("(a complete tour)");
            
        result.append("\n"+                               // add a break
                "====================================="+ "\n");
        
        //Add the board information
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (debug==true)
                {
                    System.out.println("***board[" + row +"]["+col+"]=" +
                        board[row][col]);
                }
                if (board[row][col] == 0) 
                {
                    result.append(" *   ");
                } 
                else if (board[row][col] > 9) 
                {
                    result.append( board[row][col] +"   " );
                }
                else
                 result.append(" "+ board[row][col] +"   " );
                }
            
            result.append(newLine);  //Add a line.
            result.append(newLine);  //Add a line.

        }
       
       
       return result.toString();  // Return the formatted string.
    }

    
    
    
}

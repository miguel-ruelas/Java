/**
 * The Knight class holds two integer variables for its current location and
 * two arrays showing its possible moves. It has methods to retrieve this
 * information and to randomly move the Knight to another position on the board.
* <p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = ChessBoard.Java
 */
package the.knights.tour;
import java.util.Random ;


public class Knight {
    int currentRow;             //Knows current position
    int currentCol;            //Knows current position
    int [] rowMoves = {-1,-2,-2,-1,1,2,2,1}; //Knows Eight move types
    int [] colMoves = {2,1,-1,-2,-2,-1,1,2}; ////Knows Eight move types
    boolean debug = false;
    
 /**
  * The overloaded Knight constructor sets the initial location to row 0 and col 0.
  */
    public Knight()
    {
        currentRow=0;    //Set row location to 0
        currentCol=0;    //Set col location to 0
             
    }
    /**
     * The overloaded Knight constructor accepts an integer to enable the debug
     * features of the program. It then calls the empty constructor to set the
     * location to row 0 and column 0.
     * @param option 
     */
    public Knight(int option)
    {
        this();
        if (option ==1)
            debug = true;          //enable debug
    }
    /**
     * The overloaded Knight constructor accepts an initial location different
     * than row 0, col 0;
     * 
     * @param row row to place knight
     * @param col column to place the knight
     */
    public Knight(int row, int col)
    {

        currentRow = row;
        currentCol = col;
    }
    /**
     * The overloaded Knight constructor accpets three integers, the first two 
     * are the initial location and the third is an option to turn on the 
     * debug features of the program.
     * 
     * @param row set initial row location.
     * @param col set initial column location.
     * @param option if 1 is received it will turn on the debug feature.
     */
        public Knight(int row,int col, int option)
        {
       this(row,col);       //Call the overleoaded constructor to set desired location
       if (option ==1)
            debug = true;   // turn on debug feature
       
        }
    
    /**
     * getRow() method returns the current row as an integer.
     * 
     * @return an integer that corresponds to the row location of the Knight.
     */
    public int getRow()
    {
         if (debug==true)
        {
            System.out.println("***Entering getPos()");
        }
        int position = currentRow; //get the current Row
        
        return position;        //return the row.
    }
     /**
     * getCol() method returns the current column as an integer.
     * 
     * @return an integer that corresponds to the column location of the Knight. 
     */
    public int getCol()
    {
         if (debug==true)
        {
            System.out.println("***Entering getPos()");
        }
        int position = currentCol; //get the column location
        
        return position;           //retun the column location
    }
    /**
     * legalMove() method receives two integers that correspond to a location
     * on the board. It then checks whether a move is legal. 
     * 
     * @param row receives an integer that corresponds to a row location on the board
     * @param col receives an integer that corresponds to a column location on the board
     * @return  returns true if the Knight can move to this location, false if it cannot.
     */
    public boolean legalMove(int row, int col)
    {
        if (debug==true)
        {
            System.out.println("***Entering legalMove() received row " + row
                    + " Col " + col);
        }
        
        if (row <0 || col <0)           //test if row and col are not within bounds
        {
            if (debug==true)
        {
            System.out.println("***legalMove() False");
        }
            return false;                //return false if row or col negative
        }
        
        else if (row>7|| col>7)         //test if row and col are not within bounds
        {
            if (debug==true)             
        {
            System.out.println("***legalMove() False");
        }    return false;             //return false if row or col is above 7
        }
        
            if (debug==true)
        {
            System.out.println("***legalMove() true");
        }
        return true;     //return true as desired location is inside the board
    }
    /**
     * Move() method receives a ChessBoard object and then checks to see
     * what moves are available. It then selects one at random and moves the
     * knight to the new location on the board.
     * @param board receives a board object to move the knight on.
     */
    public boolean move(ChessBoard board)
    {
       if (debug==true)
        {
            System.out.println("***Entering Knight move()");
        }
     int moves[];              //An array to hold whether each one of the knight moves
     moves = new int [9];      //is available 
     int randMove;             // variable used to select one of the known knight moves
     availableMoves(moves,board);  //sends the moves array and board to available moves
                                   //availableMoves populates the moves array. Element 0 
                                   //of the moves array holds an integer that corresponds
                                   //to the number of available moves found.
     if (moves[0] == 0)            //If moves[0] is 0 then there are no moves that can be made.
         return false;             //return false and end the tour.
     else 
         randMove = randomMove(moves);   //there are moves so select a random one.
     if (debug==true)
        {
            System.out.println("***Knight move() cur pos= " + currentRow
            + " " + currentCol);
            System.out.println("***Knight move() moving " + (randMove-1) + " " +
                    rowMoves[randMove-1] + " " + colMoves[randMove-1]);
        }
     currentRow = currentRow + rowMoves[randMove-1] ; //subtract 1 from randMove as the first element moves array is not used.
     currentCol = currentCol + colMoves[randMove-1] ; //this moves the knight to its new location
     board.placeNum(currentRow, currentCol);          //Update the numbers on the board
     if (debug==true)
        {
            System.out.println("***Knight move() new pos= " + currentRow
            + " " + currentCol);
        }

        return true;                                   //true is returned when a move is made
    }
    /**
     * availableMoves() method receives a board and an array. It uses the board
     * to see what moves are available from the known moves of the Knight.
     * It updates the array with the moves that it finds. Element 0 of the array
     * shows the total number of possible moves found.
     * 
     * @param moves an array to hold the total number of moves and the available 
     *              known moves of the Knight.
     * @param board checks the board using the Knights location to see what
     *              moves are legal.
     * @return      a populated array, element 0 is the total amount of moves.
     *              the other elements correspond to the known moves of the Knight.
     */
    private int [] availableMoves(int[] moves, ChessBoard board)
    {
        if (debug==true)
        {
            System.out.println("***Entering Knight availableMoves() current "
                    + "pos: " +currentRow + " "+ currentCol);
        }
        
        for (int moveNum = 0 ; moveNum < 8 ; moveNum++)
        {
            int testRow = currentRow + rowMoves[moveNum] ; //use known moves to update test location
            int testCol = currentCol + colMoves[moveNum] ;
            if (legalMove(testRow, testCol) &&           
                    board.legalMove(testRow, testCol))     //Check to see if test move is legal
            {
                moves[moveNum+1]= 1;                       //update element corresponding to known move
                moves[0]++;                                //update element 0 when move is found
            }
        }
        if (debug==true)
        {
            System.out.println("***Knight availableMoves() found "
                    + moves[0] + " ");
        }
        return moves;                                      //return array 
                
    }
    /**
     * randomMove() method selects a move from the moves array randomly.
     * @param moves receives the moves array and selects a random move
     * @return      return the random move as an int. It corresponds to the element
     *              location of known moves in the moves array.
     */
    private int randomMove(int [] moves)
    {
        if (debug==true)
        {
            System.out.println("***Entering Knight randomMove()");
        }
        Random generator = new Random() ;             //create random int generator
        int num = generator.nextInt(moves[0])+1 ;     //get a random int from 1 to number of available moves
   
        int counter = 0;                              //counter to count up to the random move 
        int move = 0 ;                                //move holds the element of the random move
        if (debug==true)
        {
            System.out.println("***randomMove() num = " + num);
        }
        for (int index = 1 ; index < 9; index++ )       //go through moves array to find the random move
        {
            if (moves[index] >0)                   
                counter++;
            if (num == counter)                         //Check to see if num(random move) is equal to counter
            {
                move = index;                           //if counter is equal to random move then set move to the element
                if (debug==true)                        //of the array.
                {
                    System.out.println("***randomMove() index = " + index
                            +" counter = " + counter + " move = "+ move);
                }
                return move;                           //return the randomly selected element that corresponds to the known moves
            }
        }
        return move;     
    }
    /**
     * toString() is an overridden method that returns a formatted string
     * of the row and column.
     * @return a string with the format "row column"
     */
        @Override
    public String toString()
    {
        if (debug==true)
        {
            System.out.println("***Entering Knight stringOut()");
        }
        StringBuilder result = new StringBuilder();
        result.append(getRow());
        result.append(" ");
        result.append(getCol());
        return result.toString();
        
       
       
 
    }
   
    
}


/**
 * The TileGame class is used to hold and make operations on NumberTile objects. 
 * The objects are separated into distinct ArrayLists, for the board and for
 * each player. Tester.java is in the Test Packages folder and is the default
 * external program for testing.
 *<p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = TileGame.Java
 */
import java.util.ArrayList ;

/**
 * TileGame is a public class that has all the methods needed to operate on
 * the objects of the game. To use TileGame, the external class/program will
 * need code to create and hold a TileGame object (to initiate the class), a 
 * NumberTile ArrayList (to hold the game board of tiles) and one NumberTile 
 * Arraylist per player.
 * <P>
 */
public class TileGame 
{
    private final ArrayList<NumberTile> board ; // Holds Arraylist for board
    
    /**
     * TileGame() constructor creates an arraylist and assigns it to the board
     * variable.
     */
    public TileGame() 
    {
        /* "//DEBUG\\" messages used to narrow down issues. CTRL-H and replace
        to show/hide.*/
        
        //DEBUG\\System.out.println ("** Entered TileGame() **");
    
        board = new ArrayList<>(); //creates empty ArrayList of NumberTile      
    }
      
    /**
     * GetBoard is an acessor method that returns a pointer to the game board.
     *@return the game board ArrayList  
     */
    public ArrayList<NumberTile> getBoard() 
    {
        //DEBUG\\System.out.println ("**Entered getBoard() **");
        
        return board ;
    }
    
    /**
     *GetHand is an accessor method that is used like a construct for the 
     * creation of a single NumberTile ArrayList with 5 random tiles for a 
     * player. A pointer is then returned to the external program. 
     * @return Pointer to NumberTile ArrayList to reference a single payer
     */
    public ArrayList<NumberTile> getHand() 
    {
        //DEBUG\\System.out.println ("** Entered getHand() **");
        
        ArrayList<NumberTile> hand = new ArrayList<>() ; //Creates arraylist
        
        for (int i = 0 ; i < 5; i++ )  //Adds 5 NumberTile objects to List
        {
            
        //DEBUG\\System.out.println ("** Adding tile " + i +" to getHand() **");
           
        hand.add(new NumberTile());//Adds a single NumberTile object
        
        }
        
        //DEBUG\\System.out.println ("** Exiting getHand() **");
        
        return hand;
    }
    
    /**
     * getIndexForFit checks a tile to see if it fits on the board.
     * If the current tile fits in the board (without rotating) then
     * return the index i of a tile in the board so that the current tile 
     * fits before ti for i = 0..k-1, or return k if the current tile fits
     * after the last tile.   If the tile does not fit, return -1
     * <P>
     * @param currentTile the tile sent from canInsert to be checked
     * @return index of element in tile where it can be placed or -1 
     */
    public int getIndexForFit(NumberTile currentTile) 
    {
        NumberTile testTile; //temp location for first/last tile on gameboard   
        int lastTile = (board.size())-1; // last element on gameboard
        
        //DEBUG\\System.out.println ("** Entered getIndexForFit() **");
        
        testTile= board.get(0);  // gets first NumberTile object from the board
        int curTileLeft = currentTile.getLeft(); //value in left if player tile
        int curTileRight = currentTile.getRight(); //value in right
        
        //DEBUG\\System.out.println ("** checking currentTile against left **");
        
        if (curTileRight == testTile.getLeft()) //check player against board
            return 0;     //if true, player tile fits before first tile
        else                //change testTile to last tile on board
            testTile=board.get(lastTile); 
        
        //DEBUG\\System.out.println ("** checking currentTile against right  **");
    
        if (curTileLeft == testTile.getRight())//check player against board
            if (board.size()==1) //if there is only 1 tile on board return 1
                return 1;
            else // if there are many tiles return the index for the last tile
            return lastTile;
    //if tile does not fit on left or right of board and board has more than
    //1 tile, check to see if it fits inbetween any of the tiles.
        else if (board.size() > 1) 
        {
            
            //DEBUG\\System.out.println ("** Board has more than 1 Tile  **");
            
            for (int i = 0; i < (board.size()-1); i++ )//look through board
            {
                
            //DEBUG\\System.out.println ("** Checking if tile fit between " +
            //DEBUG\\        i +" and " + (i+1) + " **");
            
                NumberTile leftElement = board.get(i); //holds left tile
                NumberTile rightElement = board.get((i+1)); //holds right tile
                boolean left = false; //flag to switch if tile matches left
                boolean right = false;//flag to switch if tile matches right
                
             //DEBUG\\System.out.println ("** Test " + curTileLeft + " " +
             //DEBUG\\leftElement.getRight() + " **");
             
                if (curTileLeft == leftElement.getRight())//Checks match on left 
                {
                    left = true;
                    
            //DEBUG\\    System.out.println ("** Matches left  **");
            
                }
                else continue; // if no match skip to next iteration of loop
                
            //DEBUG\\System.out.println ("** Test " + curTileRight + " " +
            //DEBUG\\   rightElement.getLeft() + " **");
            
                if (curTileRight == rightElement.getLeft())//Check match right
                {
                    
            //DEBUG\\    System.out.println ("** Matches right  **");
            
                    right = true; //if true then both sides match
                    
            //DEBUG\\    System.out.println ("** Tile fits between " +
            //DEBUG\\        i +" and " + (i+1) + " **");
            
                    return i+1; // return index of location to insert
                }
                
                
                
            }
            
        }

    	return -1 ; // tile did not fit anywhere
    }
    /**
     * canInsertTile receives and sends a player tile from makeMove to 
     * getIndexForFit to see if it fits on the board. It will either receive -1
     * or an index location of were the tile is to be placed on the board. If 
     * the it receives -1 it rotates the player tile and sends it to 
     * getIndexForFit again. It will do this 3 times to check all the possible
     * positions. The index location returned from getIndexForFit is only used
     * to return true in this method.
     * @param currentTile player tile received from makeMove .
     * @return if the tile fits it returns true otherwise returns false.
     */
    public boolean canInsertTile(NumberTile currentTile) 
    {
        
    //DEBUG\\    System.out.println ("** Entered canInsertTile() **");
        
        final int ROTATION = 3 ; //the maximum rotations allowed to a tile.
        int index = 0 ; // holds index received from getIndexForFit
        for (int i = 0; i < ROTATION ; i ++ ) //loop to rotate tile
        {
    
    //DEBUG\\    System.out.println ("** Tested " + i + " **");   
    
            index = getIndexForFit(currentTile); //check tile
            
    //DEBUG\\     System.out.println ("** Returned index " + index + " **");
    
            if (index== -1) //tile did not fit so rotate it
            {
                
    //DEBUG\\     System.out.println ("** Tile did not fit, rotating! **");
    
               currentTile.rotate(); //rotates player tile
            }               
            else //recieved index where tile fits, tell makeMove that it fits. 
            {
                
    //DEBUG\\    System.out.println ("** Tile fit, after " + (i+1) + 
    //DEBUG\\          " rotations! **");
    
                return true;
            }
    //DEBUG\\    System.out.println ("** Tile did not fit after " + (i+1) + 
    //DEBUG\\                   " rotation! **");
        }
        
      return false ; //Tile did not fit on board tell makeMove
    }
    
    /**
     * makeMove receives a NumberTile ArrayList that holds player tiles. 
     * It then sends each tile to canInsert until one fits. If none fits, it 
     * adds a tile to the players ArrayList and checks just that tile. It will 
     * continue adding a new tile until a tile fits on the board. The move will
     * end and the external program should move to the next player.
     * <P>
     * @param hand received from program, holds NumberTile ArrayList of player 
     *             tiles.
     */
    public void makeMove(ArrayList<NumberTile> hand) 
    {
        
    //DEBUG\\   System.out.println ("** Entered makeMove() **");
        
        boolean fits = false; //Flag to show if tile fits
        Integer fitLoc; // index of where the tile fits on board
        
        for (int i = 0; i < hand.size(); i++)//loop to check tiles
        {
            
    //DEBUG\\        System.out.println ("** Checking Tile " + i + " **");
            
            fits = canInsertTile(hand.get(i)); //check curent tile            
            if (fits == true) //if it fits get the location
            {
                
    //DEBUG\\  System.out.println ("** Tile " + i + " Fits! **");
    

                fitLoc = getIndexForFit(hand.get(i)); //get location
                NumberTile tempTile= hand.get(i); //copy tile to temp location
                hand.remove(i); //remove tile from player ArrayList
                if (fitLoc == 0) //if the location is 0 then add to begining
                {
                    board.add(fitLoc, tempTile); //add to begining of board
                }
                else if ( fitLoc ==(board.size()-1))//if fitLoc is last 
                    board.add(tempTile); //add to end of board
                else                     
                board.add(fitLoc, tempTile);// add to specific location
                return;
            }
            
//DEBUG\\   System.out.println ("** Tile " + i + " does not fit! **");

        }
        while (fits ==false) //None of the tiles fit, add a tile and check it
        {
            
//DEBUG\\   System.out.println ("** Adding tile a new tile **");

            hand.add(new NumberTile()); //add new tile to end of player list
            int lastElement = (hand.size())-1; //index of last added tile 
            fits = canInsertTile(hand.get(lastElement));//check last tile
            if (fits==true) //if it fits add it to board
            {
                fitLoc = getIndexForFit(hand.get(lastElement)); //get index 
                NumberTile tempTile= hand.get(lastElement);// copy player tile
                hand.remove(lastElement);// remove player tile
                if (fitLoc == (board.size()-1)) //if fits at end of board
                        board.add(tempTile);   //add to end
                else                                
                board.add(fitLoc, tempTile); //add to index
            }    
        }               
    }

    /**
    * toString returns a formated string that can be sent to console.
    * @return the board as a multi-line String
    */
    @Override
    public String toString() 
    {
        return board.toString() ;  // ArrayList as a String
    }
} // end of TileGame class 


/**
 * The Nim class contains all the methods necessary to play a game of Nim.
 * It has a play() method  that conducts the game (as shown in class). 
 * The play() method calls the move() method of a Player object polymorphically. 
 * The Nim class depends only on the Player interface and Pile class.
 * To use it, it must receives two player objects upon initialization, its 
 * constructor then creates a Pile object. The play() method can then be called
 * to initiate the game.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename= Nim.Java
 */
public class Nim {
    private Player player1;                 //holds a Player object.           
    private Player player2;                 //holds a Player object.
    private Pile pile;                      //holds a Pile object
    
    /**
     * The Nim() method is a constructor that receives two Player objects. It 
     * first checks to ensure the objects received are Player objects and then 
     * assigns them ti the player1 and player2 variables. The constructor then
     * creates a new Pile object and assigns it to pile.
     * 
     * @param pl1 is a Player variable that will go first in the game.
     * @param pl2 is a Player variable that will go second in the game.
     */
    public Nim (Player pl1, Player pl2)
    {
        if(!(pl1 instanceof Player))        //test to make sure object is a Player object
        {
            System.out.println("ERROR!!! Received invalid object @ pl1");
            System.exit(1);
        }
        if(!(pl2 instanceof Player)) 
        {
            System.out.println("ERROR!!! Received invalid object @ pl2");
            System.exit(1);
        }
        player1= pl1;                       //Assigns the Player object received to player1
        player2=pl2;                        //Assigns the Player object received to player1
        pile = new Pile();                  //Creates a Pile object
        
    }
    
    /**
     * The play() method conducts a game of Nim. It uses the Player objects and
     * Pile object to polymorphically access them and conduct the procedures
     * needed to play.
     */
    public void play()
    {
        System.out.println ("\n");
        System.out.println ("Player 1 : " +
                            player1.getName());         //Display the first player
        System.out.println ("Player 2 : " +
                            player2.getName());         //Display the second player
        System.out.println ("\n");                      //Insert a space in console
        System.out.println ("There are: " + pile.getSize() + 
                    " marbles in the pile.");           //Display the number of marbles
 
        //Each player takes a turn until there is 1 marble left.
        do
        {
            
            int remove;                              //holds the amount to be removed from the pile.
            remove = player1.move(pile.getSize());   //player1 makes a move
         
            System.out.println ("Player : " +
                            player1.getName()+ " removed " + remove ); // Display the amount of marbles player1 removed.
            
            pile.removeMarbles(remove);                                //Remove the marbles from the pile.
            
            System.out.println ("\n\nThere are: " + pile.getSize() + 
                    " marbles in the pile.");                          //Display the new amount of marbles in the pile.
            if (pile.getSize()>1)                        //Check to see if there is only 1 marble remaining.
            {                                            //There is more than 1 marble now player2 takes a turn.
            remove =player2.move(pile.getSize());        //Player2 takes a turn
            
            System.out.println ("Player : " +
                            player2.getName()+ " removed " + remove ); // Display the amount of marbles player2 removed.
            
            pile.removeMarbles(remove);                   //Remove the marbles from the pile.
            
            System.out.println ("\n\nThere are: " + pile.getSize() + 
                    " marbles in the pile.");                  //Display the new amount of marbles in the pile.
            
                if (pile.getSize()== 1)                   //Check to see if there is only 1 marble remaining.
                    System.out.println (player1.getName() +" has to take the"
                            + " last marble. " + player2.getName()+ " wins!!!"); //1 marble remains player 2 wins as player 1
            }                                                                    //will have to take the last marble
            else System.out.println (player2.getName() +" has to take the" 
                    + " last marble. " + player1.getName()
                    + " wins!!!");                        //else takes in effect after player1 turn.If there was 1 marble
                                                          //left after player1 turn then player 1 wins.         
        }
        while (pile.getSize()>1);                         //Continue the turns till there is only 1 marble left.
        
        //display the marbles removed by each player:        
        System.out.println (player1.getName() + " removed " + player1.getMarbles() +
                " marbles. \n" + player2.getName() + " removed " + 
                player2.getMarbles() + " marbles. \n ");
    }
    
}

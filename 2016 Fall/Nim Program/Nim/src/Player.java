/**
 * The Player interface class is used to play a game of Nim. It has all the 
 * methods needed for a player to take part in a game of Nim.
 * The Player interface has methods to removes marbles, return the players name
 * and return the amount of marbles a player has removed.  
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Player.java
 */
public interface Player {
    
    /**
     * move() method conducts a move in a game.
     * @param pileSize
     * @return 
     */
    public int move(int pileSize);
    
    /**
     * getName() method returns the players name.
     * @return 
     */
    public String getName();
    
    /**
     * getMarbles() method returns the players marble count.
     * @return 
     */
    public int getMarbles();
}

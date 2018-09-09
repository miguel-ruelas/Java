/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 * Source
 * @author adminx
 */
public class Boat {
    String name;
    double score;

    Boat(String nm, double scr) {
        this.name = nm;
        this.score = scr;
        
        
    }
    
    public double getScore()
    {
        return score;
    }
    
    @Override
    public String toString()
    {
        String str = name +"="+ String.format( "%.2f", score );
        return  str;
        
    }
    
    
}

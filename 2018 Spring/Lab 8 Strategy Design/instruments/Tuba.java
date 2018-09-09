/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruments;

/**
 *
 * @author adminx
 */
public class Tuba extends Instrument {
    public Tuba()
    {
        playBehav = new BrassBehavior();
    }
    @Override
    public void display() {
        System.out.println("I am a tuba");
    }
    
}

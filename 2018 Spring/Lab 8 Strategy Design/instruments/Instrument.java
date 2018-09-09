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
public abstract class Instrument {
    
    PlayBehavior playBehav;
    
    public abstract  void display();
  
    public void performPlay()
    {
        playBehav.Play();
    }
    
    public void setPlayBehavior(PlayBehavior newBehav)
    {
        this.playBehav = newBehav;  
        
    }
    
    
    
}

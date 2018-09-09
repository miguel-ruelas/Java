/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruments;
import java.util.ArrayList;

/**
 *
 * @author adminx
 */
public class MusicInstrumentSimulator  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Instrument> ensemble = new ArrayList<Instrument>();	
		ensemble.add( new Violin() );
		ensemble.add( new Tuba() );
		ensemble.add( new Clarinet() );
		ensemble.add( new Harp() );
		ensemble.add( new DoubleBass() );

		for( Instrument I : ensemble)
		{
			I.display();
			I.performPlay();
			System.out.println();
		}

		Instrument bass = new DoubleBass();
		bass.performPlay();
		bass.setPlayBehavior( new PluckWithFingers() );
		bass.performPlay();
    }
    
}

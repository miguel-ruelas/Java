/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;
import java.util.*;

/**
 *
 * @author adminx
 */
public class SailboatRacesSimulator {
         RaceData raceData;
	List<Boat> boatList = new ArrayList<>();
	Random rand = new Random();
        void start() {
		boatList.add(new Boat("Moby", 82.5) );
		boatList.add(new Boat("Enterprise",54.1) );
		boatList.add(new Boat("Ticonderoga",494.0) );
		boatList.add(new Boat("Kialoa",202.0) );
		raceData = new RaceData(boatList);
		LatestScoresDisplay scoresDisplay = new LatestScoresDisplay(raceData);
		raceData.raceResultsChanged(boatList);
		updateRaceResults();
		updateRaceResults();
		updateRaceResults();
		updateRaceResults();		
	}
    void updateRaceResults() {
		for( Boat inv :  boatList) {
			double factor = rand.nextDouble() * 10 - 5.0;
			inv.score *= factor;
		}
		
		raceData.raceResultsChanged(boatList);
	}
		
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SailboatRacesSimulator().start();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;
import java.util.List;

/**
 *Observer
 * @author adminx
 */
class LatestScoresDisplay implements Observer{
    RaceData subject;
    List<Boat> list;

    LatestScoresDisplay(RaceData raceData) {
        this.subject = raceData;
        raceData.registerObserver(this);
        
    }

    @Override
    public void update(List<Boat> lst) {
        this.list = lst;
        display();
    }

    private void display() {
        System.out.println("--- Race Results ----" );
        for(int i =0; i<list.size();i++)
        {
            Boat temp = list.get(i);
            System.out.print(temp.toString()+ ", ");
        }
        System.out.println("" );
    }

    @Override
    public void setSubject(RaceData sub) {
        this.subject = sub;
    }
    
}

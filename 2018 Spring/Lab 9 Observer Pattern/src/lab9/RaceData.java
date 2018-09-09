/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.util.ArrayList;
import java.util.*;

/**
 * Subject
 * @author adminx
 */
public class RaceData implements Subject {
    private List<Observer> observers;
    private List<Boat> list;


    RaceData(List<Boat> boatList) {
        this.list=boatList;
        this.observers=  new ArrayList<>();
    }

    void raceResultsChanged(List<Boat> boatList) {
        this.list=boatList;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        observers.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0)
        {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i=0; i < observers.size();i++)
        {
            Observer observer = (Observer)observers.get(i);
            observer.update(list);
        }
    }


    
}

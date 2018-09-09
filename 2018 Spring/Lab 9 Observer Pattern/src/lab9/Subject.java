/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author adminx
 */
public interface Subject {
    public void registerObserver(Observer obj);
    public void removeObserver(Observer obj);
    public void notifyObservers();
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;
import java.util.List;

/**
 *
 * @author adminx
 */
public interface Observer {
    public void update(List<Boat> list);
    public void setSubject(RaceData sub);
    
}

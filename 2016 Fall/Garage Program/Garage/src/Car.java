
/**
 *Car class is an objects with two variables that hold information about a vehicle
 * and how many times it has been moved. Its constructor creates
 * receives a license plate and initializes the license plate and moved 
 * variables. 
 * <P>
 * @author     Miguel A. Ruelas
 * Filename    Car.java
 */


public class Car 
{
    private final String license ;   //holds the license plate
    private int moved;               //holds the number of moves
    /**Car() Receives license plate and construct car with no moves
     * 
     * @param plate A string holding the license plate of a vehicle
     */
            
    public Car(String plate) 
    {
        //System.out.println ("** Entered Car() **");
        license = plate; // assigns the license plate received 
        moved = 0;       // initializes moved variable
    }
    /**
     * Moved() is a mutator method that increments the moved variable whenever 
     * the car is moved out of garage.
     * 
     */
    public void Moved ()
    {
        //System.out.println ("** Entered Moved() **");
        moved++;     //increment moved when the car is moved out of the garage
    }
    /**
     * Plate() is an accessor method that returns the license plate of the
     * vehicle.
     * @return will return the license plate in a string format.
     */
    public String Plate()
    {
         //System.out.println ("** Entered Plate() **");
        return license; //return the license plate as a string
        
    }


    /**
     * toString overrides the Array method and returns a formated string
     * that can be sent to console. This displays an individual car in console.
     * returns the car as a string in the form : License moves
     * @return returns a formated string object that can be used to display a 
     *         car
     */
    @Override
    public String toString() 
    {
        //create a formatted string
        String out = license + " " + moved ; 
       
        return out; // return the formatted string
    }
    
} // end of Car class

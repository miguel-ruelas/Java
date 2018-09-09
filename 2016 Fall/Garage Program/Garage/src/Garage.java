
import java.util.Arrays;


/**
 *The Garage class holds an array of Car objects. It has methods to conduct
 * operations on the car objects
 *<p>
 * @author    Miguel A. Ruelas Jacobo
 * Filename = Garage.Java
 */


/**
 * Garage is a public class that has all the methods needed to operate on
 * Car objects. To use Garage, the external class/program will
 * need code to create and hold a Garage object (to initiate the class), a 
 * NumberTile ArrayList (to hold the game board of tiles) and one NumberTile 
 * Arraylist per player
 <P>
 * 
 */
public class Garage 
{
    private final Car[] garage ; // Holds Arraylist for board
    private final int spaces;
    private int occupied;
    
    
    /**
     * Garage() constructor creates an array to hold car objects
     * variable. Receives the size from external program
     * @param size how many spaces does the garage have
     */
    public Garage(int size) 
    {
    
        garage = new Car[size] ; //creates empty ArrayList of Car  
        spaces = size;           //holds total size of garage
    }

 
    
    /**
     *  Arrive () is a mutator method that receives the license plate of a 
     * vehicle and checks to see if the garage is full. If there is room the
     * method calls other processes to add the car in the last spot open
     * @param license receives the license plate of a vehicle
     * @return is a string with output stating the status of the operation
     */
    public String Arrive(String license)
    {
        //System.out.println ("** Entered Arrive() **");
        
        String status = "";               //used to hold a string to be sent back to main program
        boolean notFull = IsThereRoom(); //check to make sure there is room
        
        //System.out.println ("** isThereRoom returned " + notFull + " **");
        
        if (notFull == true )           //there is room car is put in last space
            status = ParkTheCar(license); //receives a string to be sent to main program
                
        if (notFull == false)            //there is no room car is rejected
            status = "Car with license : " + license + " denied entry."
                    + " The garage is full!";     
                   
        return status;                //string sent to main program 
    }
    /**
     * Depart() checks if the car is in the garage, if it is  it calls other 
     * methods to remove the car. It then returns a status of the operation as
     * a string
     * @param license receives a license plate to look for
     * @return a string with status of operation
     */
    public String Depart(String license)
    {
        //System.out.println ("** Entered Depart() **");
        String status;                     //to hold a string to be returned
        int location = FindTheCar(license);//find car location 
        if (location!=-1)                  //the car was found
        {
                RemoveCar(location);       //remove car
                status = "Car with License: " + license + " was found in " +
                        "space "+ (location+1) + " and has departed.\n"
                        + "There is " + occupied  + 
                        " vehicles in the garage.";   //update status with result
        }
        else status = "That vehicle is not here!"; // car was not found
                
        
                return status;                //return the string with result
    }
    /**
     * IsThereRoom() checks to see if the garage is full
     * @return returns true if there is room and false if it is full.
     */
    private Boolean IsThereRoom()
    {
       // System.out.println ("** Entered IsThereRoom() **");
       // System.out.println ("** IsThereRoom() " + occupied +
       //          "< " + spaces + " **");
        return occupied < spaces; //if occupied < spaces is 0 return true
               
    }
    /**
     * ParkTheCar() receives a license plate and creates a car object, then it inserts 
     * it in the last location and returns a string with the status on where it was parked.
     * 
     * @param license is a string containing the license of a vehicle arriving at the garage
     * @return a string showing where the car was parked and total number of cars in garage.
     */
    private String ParkTheCar(String license)
    {
        //System.out.println ("** Entered ParkTheCar() **");
        String parkedLocation;                     //string to be return to show status
        
            garage [occupied] = new Car(license);    //put car in last place
        occupied++;                                  //increment occupied
       // System.out.println ("**ParkTheCar() occupied= " + occupied + " **");
        parkedLocation = "Car with License: " + license + " was parked in " +
                        "space "+ occupied + ". \nThere is " + occupied  + 
                        " vehicles in the garage.";         //string to be returned
       // System.out.println ("**ParkTheCar() " + parkedLocation + " **");
        
        return parkedLocation ;// return where the car was parked and total number of cars in garage
        
    }
    
    /**
     * FindTheCar() receives a license plate and traverses the garage array to find
     * its location. If it is found it returns the location as an int. If it is not
     * found it returns -1.
     * @return location of car in array or -1 if not found
     */
    private int FindTheCar(String license)
    {
        //System.out.println ("** Entered FindTheCar() **");
        String parkedCarLicense = "";              //holds the license of the car in the garage
        //traverse array and return space number
         for (int i = 0; i < 10; i++)
        {
           
            parkedCarLicense= garage[i].Plate();           //check to see if the license plate matches the parked vehicle
            //System.out.println ("** FindTheCar() looking for " + license +
            //        " comparing to " + parkedCarLicense);
            if (parkedCarLicense.equals(license))          //if it does return the location 
            {
               // System.out.println ("** FindTheCar() found in location " + i + 
               //     " **");
                return i;                                    //return location
            }
        }
          //System.out.println ("** FindTheCar() did not find the car**");
                return -1;                                   //license was not found 
    }
    /**
     * MoveCarsOut() receives the location of the vehicle and increments the moved
     * variable of all car objects that are in a lower spot of the array
     * @param carLoc spot in the array of the vehicle to be moved out.
     */
    private void MoveCarsOut(int carLoc)
    {
        //System.out.println ("** Entered MoveCarsOut() **");
      
        if (carLoc !=0)                        //if 0 then it is in the front and no cars need to be moved
            for (int i = 0 ; i  < carLoc; i++) // for every car in front garage[carLoc].Moved();
        {
            garage[i].Moved();                 //adds 1 to each cars moved variable
         //   System.out.println ("** MoveCarsOut() space "+ i + " moved **");
               
        }
       
    }
    
    /**
     * RemoveCar() moves all the vehicles up a spot when a car in front of them 
     * departs.
     * @param spaceNumber the location of the car that departed. 
     */
    private void RemoveCar(int spaceNumber)
    {
       // System.out.println ("** Entered RemoveCar() **");
        MoveCarsOut(spaceNumber); //increment all cars in front
        MoveCarsUp(spaceNumber); // move cars behind up to clear empty space
        
    }
    /**
     * MoveCarsUp moves all the vehicles in the back up
     * @param spaceNumber 
     */
    private void MoveCarsUp (int spaceNumber)
    {
        //System.out.println ("** Entered MoveCarsUp() **");

         for (int i= spaceNumber; i < occupied-1;i++) 
        { garage[i] = garage[i+1];                    //remove car and move cars behind it up.
        
        }//move every car behind the one moved out up one space
         occupied--;                                  //a car was remove, occupied spots is decreased by 1
       //   System.out.println ("** MoveCarsUp() spaceNumer " + spaceNumber +
       //         " occupied " + occupied + " **");
        
    }        

    /**
    * toString returns a formated string that can be sent to console.
    * @return the board as a multi-line String
    */
    @Override
    public String toString() 
    {
        return Arrays.toString(garage) ;  // ArrayList as a String
    }
} // end of Garage class 

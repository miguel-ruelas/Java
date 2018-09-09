
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Tester is a program that simulates a game using the Garage and Car
 classes.
 * @author Miguel A. Ruelas
 */
public class Tester {

    /**
     * The main class creates a Garage object, a scanner object and a 
     * printwriter object. The Garage object operates on car objects that are
     * read from the garage.txt file. All operations are wrtten back to the
     * output.txt file and sent to console
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        

        Garage test = new Garage(10);                              // Create the game object
        Scanner inputFile = new Scanner(new File("garage.txt")) ;  //Create a scanner object to read from file
        try (PrintWriter outFile = new PrintWriter(new File("output.txt"))) {   //create printwriter object to write to file
            while (inputFile.hasNext())                             //read the file
            {
         String carLicense = inputFile.next() ;                     //get license from file
      	 String action = inputFile.next() ;                         //get action from file
         String output = "";                                        //output will hold status messages received from Garage class
      	
        //System.out.println ("** reading  **" + carLicense);
        
        //System.out.println ("** reading  **" + action);
        outFile.println(carLicense + " " + action );                 //record items read from input file to output file
         
        //execute actions
      	 if (action.equals("ARRIVE"))                 
              output  = test.Arrive(carLicense);       //receives output from garage and holds it
         else
             output = test.Depart(carLicense);          //receives output from garage and holds it
         

                //write result to output
                String garage = test.toString();
                //Post result to output
                System.out.println (output);
                outFile.println(output );
                outFile.println(garage);
                
            }
        }

        
        
    }
    
}


/**
 * Tester is a program that simulates KnightsTour, Knight and ChessBoard
 classes.
 * @author Miguel A. Ruelas
 */
package the.knights.tour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author adminx
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       
        KnightsTour test = new KnightsTour();
        test.makeTour(100);
        
       
        try (PrintWriter outFile = new PrintWriter(new File("output.txt"))) {
            String output = ""; 
            System.out.println(test.getLongestRecord());
            output = test.getLongestRecord();
            outFile.println(output );
            
            System.out.println(test.getNumTour());
            output = test.getNumTour();
            outFile.println(output );
            
            
            
                  
            
        }
    }
    
}

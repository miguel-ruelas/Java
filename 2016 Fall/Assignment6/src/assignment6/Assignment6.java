/**
 * Assignment6 is a test class used to simulate the creation and operations done
 * by a GenLinkList object. It reads operations from a file and displays status 
 * and outcome on console.
 * 
 * @author    Miguel A. Ruelas Jacobo
 * Filename = Assignment6.Java
 **/
package assignment6;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 *
 * @author adminx
 */
public class Assignment6 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        // TODO code application logic here
        GenLinkList aList = new GenLinkList() ;             //create a generic linked list

        Scanner inputFile = new Scanner(new File("list-ops.txt")) ;  //Create a scanner object to read from file
        try (PrintWriter outFile = new PrintWriter(new File("notused.txt"))) {   //create printwriter object to 
                                                                            //write to file. not used in this assignment
            while (inputFile.hasNext())                             //read the file
            {
                String action = inputFile.next() ;                         //get action from file
                switch (action)                                            //use switch to execute action
                {
                    case "ADD":                                           //ADD operation read from file
                        
                        int element = inputFile.nextInt();                 //get the parameters from the file
                        int addItem = inputFile.nextInt();                 //get second parameter
                        aList.add(element, addItem);                       //execute add with parameters
                        System.out.println("Operation ADD item : " + addItem   //display action
                                + " in element: " + element);
                        break;
                    case "APPEND":                                       //Append operation read from file
                        int appendItem = inputFile.nextInt();            //get parameters from file
                        aList.append(appendItem);                        //execute append
                        System.out.println("Operation APPEND item : " +   //display action
                                appendItem + " at end of list.");
                        break;
                    case "CLEAR":                                           //Clear operation read from file                    
                        aList.clear();                                      //Execute clear
                        System.out.println("Operation CLEAR completed");    //Display action
                        break;
                    case "DELETE":                                          //delete operation read from file
                        int deleteItem = inputFile.nextInt();               //get parameter from file
                        aList.delete(deleteItem);                           //execute delete
                        System.out.println("Operation DELETE item : "       //display action
                                + " in element: " + deleteItem);
                        break;
                    case "REVERSE":                                         //Reverse operation read from file
                        aList.reverse();                                    //execute reverse
                        System.out.println("Operation REVERSE completed ");  //Display action
                        break;
                    case "SWAP":                                             //Swap operation read from file
                        int swapItem1 = inputFile.nextInt();                 //get parameter from file
                        
                        int swapItem2 = inputFile.nextInt();                 //get second parameter from file
                        aList.swap(swapItem1,swapItem2);                     //Execute swap
                        System.out.println("Operation SWAP element : " +      //Display action
                                swapItem1+ " with element: " + swapItem2);
                        break;
                }
 
            System.out.println("Printing the list:\n" + aList);            //Display list after operation completed
            }
        }
    }
}
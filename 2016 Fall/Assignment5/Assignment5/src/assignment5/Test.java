/**
 * Test class is used to test inheritence and polymorphism by creating shape
 * objects and conducting operations between them.
 * @author Miguel A. Ruelas Jacobo
 * Filename = Test.java
 */
package assignment5;
import java.util.Arrays;

/**
 * The Test class creates 4 Shape objects and places them in an array. It then 
 * uses a loop to traverse the array and display the Shape objects information.
 * It will then sort the array by volume in ascending order, and, using another 
 * loop, will display the Type of Shape it is and its volume. Using the comparator
 * interface, it then sorts the array in descending order by distance and displays
 * the Type of Shape and its distance in console.
 */
public class Test {

    /**
     * main() conducts the operations of the Test class.
     * @param args 
     */
    public static void main(String[] args) {
        Shape [] shapes = new Shape[4];      //Create an array of Shape objects
        shapes[0] = new Sphere(2,-8,5,13);             //Create and add a Sphere
        shapes[1] = new Parallelepiped(7,2,9,37,12,9); //Create and add a Parallelepiped
        shapes[2] = new Cylinder(3,-4,5,11,13);        //Create and add a Cylinder
        shapes[3] = new Cone(-5,2,-1,10,14);           //Create and add a Cone
        ShapeComparator comp = new ShapeComparator();  //Create a ShapeComparator interface object.
        
        //Traverse the array and print the Class, input data, surface area and volume.
        for (int i = 0; i < shapes.length; i++)
        {
            System.out.print(shapes[i]);            //Prints the shape and inpud data
            System.out.print(", surface area ");    // print the surface area on the same line
            System.out.print(String.format("%.2f",  //format the surface area to 2 decimal points
                    shapes[i].getSurfaceArea()));
            System.out.print(", volume ");          //print the volume on the same line
            System.out.print(String.format("%.2f",  //format the volume to 2 decimal points
                    shapes[i].getVolume()));
            System.out.print("\n");                 // go to the next line.
            
        }
        Arrays.sort(shapes);                        //sort array in ascending order by volume
        System.out.print("\n");                     // add a new line to increase readability.
        
        //Traverse the array and print the Class and volume.
        for (int i = 0; i < shapes.length; i++)
        {
            System.out.print(shapes[i].getClass().getSimpleName()); //Get and print the class
            System.out.print(" volume: ");                          // add the volume to the same line
            System.out.print(String.format("%.2f",         //format the volume to 2 decimal points
                    shapes[i].getVolume()));
            System.out.print("\n");                        // go to the next line.
            
        }
        
        Arrays.sort(shapes, comp);                        //sort array in descending order by distance
        System.out.print("\n");                           // add a new line for readability.
        
        //Traverse the array and print the Class and distance.
        for (int i = 0; i < shapes.length; i++)
        {
            System.out.print(shapes[i].getClass().getSimpleName());  //Get and print the class
            System.out.print(" distance: ");                         // add the distance to the same line
            System.out.print(String.format("%.2f",        //format the distance to 2 decimal points
                    shapes[i].getDistance()));
            System.out.print("\n");                      // go to the next line.
            
        }
        
    }
    
}

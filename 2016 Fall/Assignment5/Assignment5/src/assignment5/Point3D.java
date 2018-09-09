/**
 * The Point3D class that can be used to hold information about a point in a 
 * 3 Dimensional space.
 * @author Miguel A. Ruelas Jacobo
 * Filename = Point3D.java
 */
package assignment5;

/**
 * Point3D is a public class that has 3 integer variables that correspond to a
 * point in a 3 dimensional space. It also has accessor methods for returning
 * the points to another program.
 * 
 */
public class Point3D {
    private int x;  //holds the first number for a point in a 3D space (x,y,z).
    private int y;  //holds the second number for a point in a 3D space (x,y,z).
    private int z;  //holds the third number for a point in a 3D space (x,y,z).
    /**
     * Point3D() is a constructor method that receives 3 integers that
     * correspond to a single point in a 3 dimensional space. It then uses 
     * the 3 integers to initiate the private variables in the class.
     * 
     * @param a used to initiate a variable x
     * @param b used to initiate variable y
     * @param c used to initiate variable z
     */
    public Point3D(int a, int b, int c)
    {
        x = a; //initiates the first number for a point in a 3D space (x,y,z).
        y = b; //initiates the second number for a point in a 3D space (x,y,z).
        z = c; //initiates the third number for a point in a 3D space (x,y,z).
    }
    /**
     * getX() is an accessor method that returns the value of the integer
     * variable x.
     * 
     * @return returns the value in variable x.
     */
    public int getX()
    {
        return x; //returns the first number for a point in a 3D space (x,y,z).
    }
    /**
     * getY() is an accessor method that returns the value of the integer
     * variable y.
     * 
     * @return return the value in variable y. 
     */
    public int getY()
    {
        return y; // returns the second number for a point in a 3D space (x,y,z).
    }
    /**
     * getZ90 is an accessor method that returns the value of the integer 
     * variable z.
     * 
     * @return return the value in variable z.
     */
    public int getZ()
    {
        return z; // returns the third number for a point in a 3D space (x,y,z).
    }
    /**
     * toString() is an accessor method that returns the values of x, y and z
     * as a formatted string.
     * 
     * @return a formatted string "x,y,z"
     */
    @Override
    public String toString()
    {
        String coordinates = x + "," + y + "," + z; //create a formatted string with the values of a point in 3D space.
        return coordinates; //return a formatted string with the values of a point in 3D space.
    }
    
}

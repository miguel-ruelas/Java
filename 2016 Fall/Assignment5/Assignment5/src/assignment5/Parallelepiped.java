/**
 * The Parallelepiped class extends the Shape class and can be used to hold 
 * and compute information about 3 Dimensional Parallelepiped.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Parallelepiped.java
 */
package assignment5;

/**
 * Parallelepiped class extends Shape.java which has a Point3D variable that 
 * correspond to the center point in a 3 dimensional shape. It also has accessor 
 * methods for returning the distance from origin (0,0,0) to the center, the 
 * surface area and the volume. The getVolume() and getSurfaceArea() methods 
 * are overridden to return the volume and surface area of a Parallelepiped.
 * 
 */
public class Parallelepiped extends Shape{
    int length; //used to hold the length
    int width;  //used to hold the width
    int height; //used to hold the height
    
    /**
     * Parallelepiped() is a constructor method that receives 6 integers that
     * correspond to the center point, the length, width and height of a 
     * parallelepiped. It then uses the first 3 integers to pass to the Shape
     * super class which uses them to create a Point3D object.
     * 
     * @param a used to create a Point3D 
     * @param b used to create a Point3D
     * @param c used to create a Point3D 
     * @param l used to initiate a private variable corresponds to the length.
     * @param w used to initiate a private variable corresponds to the width.
     * @param h used to initiate a private variable corresponds to the height.
     */
    public Parallelepiped (int a, int b, int c, int l, int w, int h)
    {
        super(a,b,c); //call super class to create and initiate Point3D object
        length = l;   //initiate length variable         
        width = w;    //initiate width variable         
        height = h;   //initiate height variable         
    }

    /**
     * getSurfaceArea() is an overriden accessor method that is used to compute 
     * and then return the surface area of a parallelepiped as a double.
     * 
     * @return return the surface area of a parallelepiped as a double.
     */
    @Override
    public double getSurfaceArea()
    {
        //Compute the area
        double totalSurfaceArea = 2 * ((length * width) + (width * height) +
                (height * length));
        return totalSurfaceArea; //return the area
        
    }
    
     /**
     * getVolume() is an overriden accessor  method that is used to compute and 
     * then return the volume of a parallelepiped as a double.
     * 
     * @return return the volume of a parallelepiped as a double.
     */
    @Override
    public double getVolume()
    {
        //Compute the volume
        double volume = (double)length * width * height;
        return volume; //return the volume
        
    }
    
    /**
     * toString() method requests information from the super class Shape.java 
     * and then returns a formatted string consisting of the center point and 
     * length, width, and height of a parallelepiped.
     * 
     * @return returns a formatted string.
     */
    @Override
    public String toString()
    {
        //Create a formatted string
        String paraInfo = "Parallelepiped:    Center at (" + super.toString() 
                + "), length " + length + ", width " + width + ", height " 
                + height;
        return paraInfo; // return the formatted string.
        
    }     
            
            
    
}

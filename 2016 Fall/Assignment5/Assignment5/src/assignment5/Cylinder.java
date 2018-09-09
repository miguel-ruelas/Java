/**
 * The Cylinder class extends the Shape class and can be used to hold 
 * and compute information about 3 Dimensional Cylinder.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Cylinder.java
 */
package assignment5;

/**
 * Cylinder class extends Shape.java which has a Point3D variable that 
 * correspond to the center point in a 3 dimensional shape. It also has accessor 
 * methods for returning the distance from origin (0,0,0) to the center, the 
 * surface area and the volume. The getVolume() and getSurfaceArea() methods 
 * are overridden to return the volume and surface area of a cylinder.
 * 
 */
public class Cylinder extends Shape {
    
    int radius; //holds the radius
    int height; //holds the height
    
    /**
     * Cylinder() is a constructor method that receives 5 integers that
     * correspond to the center point in a cylinder, the radius and height. It 
     * then uses the first 3 integers to pass to the Shape super class which 
     * uses them to create a Point3D object.
     * 
     * @param a used to create a Point3D 
     * @param b used to create a Point3D
     * @param c used to create a Point3D
     * @param rad used to initiate a private variable corresponds to the radius.
     * @param h used to initiate a private variable corresponds to the height.
     */
    public Cylinder (int a, int b, int c, int rad, int h)
    {
        super(a,b,c); //call super class to create and initiate Point3D object
        radius = rad; //initiate radius variable      
        height = h;   //initiate height variable 
 
    }

    /**
     * getSurfaceArea() is an overriden accessor method that is used to compute 
     * and then return the surface area of a cylinder as a double.
     * 
     * @return return the surface area of a cylinder as a double.
     */
    @Override
    public double getSurfaceArea()
    {
        //Compute the area
        double surfaceArea = (double)(2 * Math.PI * radius * height) +
                (2 * Math.PI * Math.pow((double)radius, 2));
                
        return surfaceArea; //return the area
        
    }
    
    /**
     * getVolume() is an overriden accessor  method that is used to compute and 
     * then return the volume of a cylinder as a double.
     * 
     * @return return the volume of a cylinder as a double.
     */
    @Override
    public double getVolume()
    {
        //Compute the volume
        double volume = Math.PI * Math.pow((double)radius, 2) * 
                ((double)height);
        return volume; //return the volume
        
    }
    
    /**
     * toString() method requests information from the super class Shape.java 
     * and then returns a formatted string consisting of the center point,
     * radius and height of a cylinder.
     * 
     * @return returns a formatted string.
     */
    @Override
    public String toString()
    {
        //Create a formatted string
        String cylinderInfo = "Cylinder:          Center at (" 
                + super.toString() + "), radius " + radius + ", height " 
                + height;
        return cylinderInfo; // return the formatted string.
        
    }     
            
            
    
}

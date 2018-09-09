/**
 * The Sphere class extends the Shape class and can be used to hold and compute
 * information about 3 Dimensional Sphere.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Sphere.java
 */
package assignment5;

/**
 * Sphere class extends Shape.java which has a Point3D variable that correspond 
 * to the center point in a 3 dimensional shape. It also has accessor methods for 
 * returning the distance from origin (0,0,0) to the center, the surface area,
 * and the volume. The getVolume() and getSurfaceArea() methods are overridden
 * to return the volume and surface area of a sphere.
 * 
 */
public class Sphere extends Shape {
    
    int radius;  // used to hold the radius
    
    /**
     * Sphere() is a constructor method that receives 4 integers that
     * correspond to the center point and the radius of a sphere. It then uses 
     * the 3 integers to pass to the Shape super class which uses them to create
     * a Point3D object.
     * 
     * @param a used to create a Point3D 
     * @param b used to create a Point3D
     * @param c used to create a Point3D 
     * @param rad used to initiate a private variable corresponds to the radius.
     */
    public Sphere(int a, int b, int c, int rad)
    {
        super(a,b,c);  //call super class to create and initiate Point3D object
        radius = rad;  //initiate radius variable         
        
    }
    
    /**
     * getSurfaceArea() is an overriden accessor method that is used to compute 
     * and then return the surface area of a sphere as a double.
     * 
     * @return return the surface area of a sphere as a double.
     */
    @Override
    public double getSurfaceArea()
    {
        //Compute the area of the sphere.
        double area = 4.0 * Math.PI * Math.pow((double)radius, 3);
        return area; //return the area of the sphere.
        
    }
    
    /**
     * getVolume() is an overriden accessor  method that is used to compute and 
     * then return the volume of a sphere as a double.
     * 
     * @return return the volume of a sphere as a double.
     */
    @Override
    public double getVolume()
    {
        //Compute the volume of a sphere
        double volume = (4.0 / 3) * Math.PI * Math.pow((double)radius, 3);
        return volume; //return the volume.
        
    }
    
    /**
     * toString() method requests information from the super class Shape.java 
     * and then returns a formatted string consisting of the center point and 
     * radius of a sphere.
     * 
     * @return returns a formatted string.
     */
    @Override
    public String toString()
    {
        //Create a formatted string
        String sphereInfo = "Sphere:            Center at (" + super.toString() 
                + "), radius of " + radius ;
        return sphereInfo; // return the formatted string.
        
    }        

}

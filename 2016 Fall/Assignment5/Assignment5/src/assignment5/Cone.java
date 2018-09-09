/**
 * The Cone class extends the Shape class and can be used to hold 
 * and compute information about 3 Dimensional Cone.
 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Cone.java
 */
package assignment5;

/**
 * Cone class extends Shape.java which has a Point3D variable that 
 * correspond to the center point in a 3 dimensional shape. It also has accessor 
 * methods for returning the distance from origin (0,0,0) to the center, the 
 * surface area and the volume. The getVolume() and getSurfaceArea() methods 
 * are overridden to return the volume and surface area of a cone.
 * 
 */
public class Cone extends Shape {
    
    int radius; //holds the radius
    int height; //holds the height
    
    /**
     * Cone() is a constructor method that receives 5 integers that
     * correspond to the center point in a cone, the radius and height. It then 
     * uses the first 3 integers to pass to the Shape super class which uses 
     * them to create a Point3D object.
     * 
     * @param a used to create a Point3D 
     * @param b used to create a Point3D
     * @param c used to create a Point3D
     * @param rad used to initiate a private variable corresponds to the radius.
     * @param h used to initiate a private variable corresponds to the height.
     */
    public Cone (int a, int b, int c, int rad, int h)
    {
        super(a,b,c); //call super class to create and initiate Point3D object
        radius = rad; //initiate radius variable    
        height = h;   //initiate height variable    
              

    }

    /**
     * getSurfaceArea() is an overriden accessor method that is used to compute 
     * and then return the surface area of a cone as a double.
     * 
     * @return return the surface area of a cone as a double.
     */
    @Override
    public double getSurfaceArea()
    {
        //Compute the area
        double surfaceArea = Math.PI * radius * (radius + 
                (Math.sqrt(Math.pow((double)radius, 2)) * 
                (Math.pow((double)height, 2))));  
        return surfaceArea; //return the area
        
    }
    
    /**
     * getVolume() is an overriden accessor  method that is used to compute and 
     * then return the volume of a cone as a double.
     * 
     * @return return the volume of a cone as a double.
     */
    @Override
    public double getVolume()
    {
        //Compute the volume
        double volume = Math.PI * Math.pow((double)radius, 2) * 
                ((double)height/3);
        return volume;//return the volume
        
    }
    
    /**
     * toString() method requests information from the super class Shape.java 
     * and then returns a formatted string consisting of the center point,
     * radius and height of a cone.
     * 
     * @return returns a formatted string.
     */
    @Override
    public String toString()
    {
        //Create a formatted string
        String coneInfo = "Cone:              Center at (" + super.toString() 
                + "), radius " + radius + ", height " + height;
        return coneInfo; // return the formatted string.
        
    }     
            
            
    
}
    

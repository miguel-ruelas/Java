/**
 * The Shape class is an abstract class that can be used to hold information
 * about 3 Dimensional shapes.
 * @author Miguel A. Ruelas Jacobo
 * Filename = Shape.java
 */
package assignment5;

/**
 * Shape is an abstract class that has a Point3D variable that correspond to the
 * center point in a 3 dimensional shape. It also has accessor methods for 
 * returning the distance from origin (0,0,0) to the center, the surface area,
 * and the volume. The getVolume() and getSurfaceArea() methods are abstract and
 * must be overridden.
 * 
 */
public abstract class Shape implements Comparable {
    
    Point3D center; //will hold a Point3D object

    /**
     * Shape() is a constructor method that receives 3 integers that
     * correspond to a single point in a 3 dimensional space. It then uses 
     * the 3 integers to create a Point3D.
     * 
     * @param a used to create a Point3D 
     * @param b used to create a Point3D
     * @param c used to create a Point3D
     */
    public Shape(int a, int b, int c)
    {
        center = new Point3D(a,b,c); //initiate the Point3D object
    }
    /**
     * getDistance() is an accessor method that computes the distance from 
     * origin (0,0,0) to the center of the shape (information stored in the 
     * object Point3D) It requests the information from the Point3D object and
     * then uses the distance formula √((x2−x1)^2+(y2−y1)^2+(z2−z1)^2) with 
     * x1, y1 and z1 ==0 and returns the result.
     * 
     * @return returns the distance from (0,0,0) the point held in Point3D.
     */
    public double getDistance()
    {
        //cast values to a double.
        double a = (double)center.getX(); //get the first value corresponding to the center of a shape.
        double b = (double)center.getY(); //get the first value corresponding to the center of a shape.
        double c = (double)center.getZ(); //get the first value corresponding to the center of a shape.
        
        //get the distance from origin to center point of a shape.
        double distance = Math.sqrt((Math.pow(a,2)+Math.pow(b, 2)+ 
                Math.pow(c, 2)));   
        return distance;   //return the distance as a double.
    }
    
    /**
     * getSurfaceArea() is an abstract method that must be overridden. It is to 
     * be used to compute the surface area of a 3 dimensional shape.
     * @return return the surface area of a 3 dimensional shape as a double.
     */
    public abstract double getSurfaceArea();
    
    /**
     * getVolume() is an abstract method that must be overridden. It is to 
     * be used to compute the volume of a 3 dimensional shape.
     * @return return the volume of a 3 dimensional shape as a double.
     */
    public abstract double getVolume();
    
    /**
     * compareTo() is a method used to compare the volume of two Shape objects.
     * If the volume of the shape being compared to is less it returns a -1, if
     * it is more it returns a 1 and it returns a 0 if the volume is equal.
     * 
     * @param o is a Shape object to compare against.
     * @return -1 ,1 or 0 to signify if the volume is less, more or equal.
     */
    @Override
    public int compareTo(Object o) {
    
        final int BEFORE = -1; //used to return if volume of other shape is less
        final int EQUAL = 0;   //used to return if volume of other shape is equal
        final int AFTER = 1;   //used to return if volume of other shape is greater.
        if(!(o instanceof Shape))    //check to see if object received is a shape.
        {
            System.out.println("ERROR! compareTo() received an object that is "
                    + "not a Shape! Program will now exit..."); //Display error message
            System.exit(-1); //Exit program as object received was not a shape.
        }
        Shape compareThat = (Shape)o; //cast object received to a Shape object.
                
        if (this == compareThat) return EQUAL;         //Check to see if they are the same object.
        if (this.getVolume() < compareThat.getVolume()) return BEFORE; //Check to see if volume is less
        if (this.getVolume() > compareThat.getVolume()) return AFTER;  //Check to see if volume is greater
        return 0;  //volume is not less or greater so they must be equal. 
    }
    
    /**
     * toString() method requests a formatted string from a Point3D object that 
     * corresponds to the center of a 3 dimensional Shape. It then returns that
     * string.
     * 
     * @return returns a formatted string received from a Point3D object. 
     */
    @Override
    public String toString()
    {
        String shapeInfo = center.toString(); //request string from Point3D object
        return shapeInfo; //return string
    }    
    
}

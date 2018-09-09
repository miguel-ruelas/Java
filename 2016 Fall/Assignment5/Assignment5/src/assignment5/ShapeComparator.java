/**
 * The ShapeComparator class is an interface that is used for comparing Shape
 * objects. This interface can be passed to the Arrays.sort() as a secondary
 * means of sorting Shape objects. This interface allows the Arrays.sort()
 * method to sort the shapes in descending order based on how far the center of
 * the object is from origin. 

 * 
 * @author Miguel A. Ruelas Jacobo
 * Filename = Cylinder.java
 */
package assignment5;
import java.util.Comparator;



/**
 * ShapeComparator class is used to compare the distance of two Shape objects.
 * 
 */
public class ShapeComparator implements Comparator {

    /**
     * compare() is a method used to compare the distance of two Shape objects.
     * If the distance of the shape being compared to is less it returns a 1, if
     * it is more it returns a -1 and it returns a 0 if the volume is equal.
     * This interface allows the Arrays.sort() method to sort the shapes in 
     * descending order based on how far the center of the object is from origin.  
     * 
     * @param o1 is a Shape object to compare.
     * @param o2 is a Shape object to compare against.
     * @return 1 ,-1 or 0 to signify if the volume is less, more or equal.
     */
    @Override
    public int compare(Object o1, Object o2) 
    {
        Shape s1 = (Shape)o1 ;                  //downcast the received object to a Shape
	double distance1 = s1.getDistance() ;   //get the distance for the first object
	Shape s2= (Shape)o2 ;                   //downcast the second received object to a Shape.
	double distance2 = s2.getDistance() ;   //get the distance for the second object.
	if ( distance1 > distance2 )            //if the distance of first object is greater return -1
            return -1 ;                         //return -1.
	if (distance1 == distance2)             //if the distance are equal return 0
            return 0 ;                          //return 0
	return 1 ;                              //distance is not greater or equal so it must be less, return 1.

    }
    
}

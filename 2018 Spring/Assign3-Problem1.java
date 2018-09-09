/**
 * *******************************************************************
 * Purpose/Description: simple operation on binary search trees where keys are integers
 * Author’s Panther ID: 4808540
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person.
 *******************************************************************
 */
package assignment3;

/**
 * In this problem, you will write some Java code for a simple operation on
 * binary search trees where keys are integers. Assume you already have the
 * following code.
 *
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    static void printRange(int lower, int upper, BinaryNode t) {
        //System.out.println("Lower:"+lower+ " Key:" + t.key + " Upper:"+upper);
        
        if (lower < t.key) //if lower is smaller than node key go left
        {
            if(t.left!=null) // only if there is a node to the left
            {
              printRange(lower, upper, t.left); // go left
            }
            
        }
        if (t.key >= lower && t.key <= upper) //print key if value is between range
        {
            System.out.print(t.key + " ");
        }
            
     
        if (upper > t.key ) //go right
        {
            if(t.right!=null) //only if there is a node to the right
            {
            printRange(lower, upper, t.right);
            }
        }

    }
    

}

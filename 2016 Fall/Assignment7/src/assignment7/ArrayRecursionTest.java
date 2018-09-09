/*  File: ArrayRecursion.java
 *
 *  Programmer: Miguel A. Ruelas Jacobo
 *  COP 3337 U07 - Programming II - Fall 2016
 */

import java.util.Random;

class ArrayRecursion
{
   // instance var's

   private int[] list;		// array of ints
   private int count = 0;	// number of elements used

   /**
    * Create an ArrayRecursion object. Create an array with between 10 and 15
    * elements, and fill it with random positive 2-digit ints
    */
   public ArrayRecursion()
   {
      Random r = new Random();
      count = r.nextInt(6) + 10;
      list = new int[count];

      for (int i = 0; i < count; i++)
      {
         list[i] = r.nextInt(90) + 10;
      }
   }

   /*
    * Return the list as a string
    * @return a string containing all ints stored in list
    */
   public String toString()
   {
      String out = "";
      for (int i = 0; i < count; i++)
      {
         out += list[i] + "  ";
      }
      return out + "\n";
   }

   /**
    * Reverse the order of the values stored in the list. (called by client to
    * reverse list using first algorithm)
    */
   public void reverse()
   {
      reverseRecurse(list, 0, count);
   }

   // recursive "helper" method to reverse the values stored in the list 
   // (called by public method reverse1())
   private void reverseRecurse(int[] list, int start, int count)
   {
       if (start < count-1) //If start >= count-1 then there are no more values to reverse
      {
         int temp = list[start]; //Stores the first value so it is not lost
         list[start] = list[count-1]; //Overwrites first value with last value
         list[count-1] = temp; //Overwrites last value with original first value
         reverseRecurse(list, start+1, count-1); //reverse the rest of the array excluding values we just reversed
      } 
       
   }

   /*
    * Returns the index of the largest value in the array.
    * @return the index of the largest value in the array
    */
   public int getIndexOfLargest()
   {
      return recursiveGetIndexOfLargest(list, count);
   }

   // recursive "helper" method to return index of largest value
   // (called by public method getLargest())
   private int recursiveGetIndexOfLargest(int[] list, int count)
   {
       if (count == 1) //if there is only one element return index of 0
      {
         return 0;
      }
      else
      {
         //Get the index of the largest value of the part of the array excluding 'last' value
         int index = recursiveGetIndexOfLargest(list, count-1);
         //if the last value is larger than the largest element in the smaller array
         //return the lindex of the last value otherwise return the index from the smaller array
         if (list[count-1] > list[index])
         {
            return count-1;
         }
         else
         {
            return index;
         }
      }
   }

   /*
    * Sort the array in ascending order using the selection sort
    */
   public void sort()
   {
      recursiveSort(list, count);
   }

   // recursive "helper" method to sort the array
   // (called by public method sort())
   private void recursiveSort(int[] list, int count)
   {
       if (count > 1) //only sort if more than 1 value
      {
         //get index of largest value
         int index = recursiveGetIndexOfLargest(list, count);
         //save last value
         int temp = list[count-1];
         //put largest value at the end
         list[count -1] = list[index];
         //put last value where largest value use to be
         list[index] = temp;
         //sort the rest of the array sans last value
         recursiveSort(list, count-1);
      }
   }
}

/**
 * A test class for the ArrayRecursion class
 */
public class ArrayRecursionTest
{

   public static void main(String[] args)
   {
      ArrayRecursion list = new ArrayRecursion();

      System.out.println("\nOriginal:  " + list);
      list.reverse();
      System.out.println("\nReversed:    " + list);
      System.out.println("Largest value is at index: "
              + list.getIndexOfLargest());
      list.sort();
      System.out.println("\nSorted:    " + list);
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author adminx
 */
public class Problem1 {
    int[] arr;
    
    void start(){
        arr= new int[16];
        for (int i = 0; i<16; i++)
        {
            arr[i]=genEven();
        }
        
        display(arr);
        radixSort(arr);
        
        
}
    
    public void radixSort(int arr[])
    {
        int mod = 10;
        int digit= 1;
        int max = arr[0] ;
        int least = arr[0];
        ArrayList<Integer> negative = new ArrayList<Integer>();
        ArrayList<Integer> positive = new ArrayList<Integer>();
        
        //first pass find msd and test for even and partition positive and negative
        for(int i=0; i< arr.length; i++ )
        {
            int test = arr[i];
            //check for even
            if (test%2 !=0)
            {
             return;   
            }
            //find the max
            if(arr[i]> max)
            {
                max = arr[i];
            }
            //find the least
            if(arr[i]< least)
            {
                least = arr[i];
            }
            //seperate negative from positive
            if(test<0)
            {
                negative.add(test);
            }
            else
                positive.add(test);
        }
            //Sort positive
            while (max / digit > 0)
            {
                 System.out.println("Sort:Mod:"+ mod + " Digit:"+ digit);
                //create buckets
            ArrayList<ArrayList> buckets = new ArrayList<ArrayList>();
            for (int i = 0; i < 10; i++) 
            {
              ArrayList innerList = new ArrayList();
              buckets.add(innerList); 
            }
            
            for(int i = 0; i <positive.size();i++)
            {
               
               int number = positive.get(i); 
               System.out.println("Sort:Number:"+number);
               int bucketNumber = (number%mod)/digit;
               System.out.println("Sort:Buck#:"+bucketNumber);
               ArrayList bucket = buckets.get(bucketNumber);
               bucket.add(number);
            }
            positive.clear();
            for(ArrayList<Integer> n : buckets)
            {
                
                for(int sort : n)
                {
                    positive.add(sort);
                }
            }
            digit*=10; 
            mod*=10;
            }
            int[] result = new int[positive.size()];
            for(int i =0 ; i < positive.size(); i++)
            {
                result[i]= positive.get(i);
            }
            display(result);
        
        
    }
    
    int genEven()
    {
        Random ran = new Random();
        int even = ran.nextInt();
        if (even % 2 !=0)
            even++;
        return even;
        
    }
    void display(int[] a)
    {
        for(int i=0;i<a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Problem1().start();
        
    }
    
}

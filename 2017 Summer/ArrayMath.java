/*********************************************************************
 Author : Miguel Alejandro Ruelas Jacobo
 Course : OS COP 3767 
 Professor : Caryl Rahn
 Program # : ArrayMath.java creates and displays a 10 X 10 two dimensional array
			 as a grid. I then assigs the value of row * col to the element at 
			 array[row][col]. It adds all the values in all odd columns, and prints
			 their total aligned below the column. It then sums the values of all
			 elements in the array and displays it, along with the name and ID of the
			 author.

 Due Date  : 06/04/2017 

 Certification: 
 I hereby certify that this work is my own and none of it is the work of any other person. 
 ..........{ Miguel Alejandro Ruelas Jacobo }..........
*********************************************************************/

public class ArrayMath
{
	
	public static void arrays (int[][] gridArray)
		{
			//Populate the array by multiplying row*cold and assigning it to the element
			for (int row = 0; row < 10 ; row++)
			{
				for (int col = 0; col <10; col++)
				{
					gridArray[row][col] = row*col; 
				}
			}
			
			//Display the array
			for (int row = 0; row < 10 ; row++)
			{
				for (int col = 0; col <10; col++)
				{
					//display a formatted string
					System.out.printf("%-4s" ,gridArray[row][col] );
				}
				//add an empty line
				System.out.println();
				System.out.println();
			}
			
			// add all the values in odd columns and print their total. Align it below the column			
			for (int col = 0; col < 10 ; col++)
			{
				//Check if the column is odd.
				if (col%2 ==1)
				{
					//create an accumulator variable to hold the sum of the column
					int accumulator = 0;
					//traverse the elements of the column and add them.
					for (int row = 0; row <10; row++)
					{
						accumulator += gridArray[row][col];
					}
					//Display the result underneath the column
					System.out.printf("%-4s", accumulator);
				}
				else
				{
					//add empty space underneath the even columns.
					String space = "";
					System.out.printf("%-4s", space);
					
				}
			}
			//Add an empty line underneath the grid
			System.out.println();
			System.out.println();
			
			//Create an accumulator and sum all the elements inthe array
			int sumOfAll = 0;
			for (int row = 0; row < 10 ; row++)
			{
				for (int col = 0; col <10; col++)
				{
					sumOfAll += gridArray[row][col];
				}
			}

			// Display the sum of all elements, author and pantherID
			String author = "Miguel Alejandro Ruelas Jacobo";
			String pantherID = "4808540";
			System.out.printf("Sum of all elements: %-4s\n", sumOfAll);
			System.out.println("Author: " + author); 
			System.out.printf("Panther ID: %-4s", pantherID);

		}

		
	public static void main (String[] args)
		{
			//Create a 10X10 grid array
			int[][] grid = new int[10][10];
			
			//Call the arrays() method.
			arrays(grid);	
					
		}
		
}

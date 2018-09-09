/********************************************************************************************
 Author : Miguel Alejandro Ruelas Jacobo
 Course : OS COP 3767 
 Professor : Caryl Rahn
 Program # : MemoryCalculator.java reads a file with memory errors and then displays the errors
		on the screen.

/ Due Date  : 7/02/2017

 Certification: 
 I hereby certify that this work is my own and none of it is the work of any other person. 
 ..........{ Miguel Alejandro Ruelas Jacobo }..........
**********************************************************************************************/
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MemoryCalculator
{
	
	/*fileOps() is a method that receives an ArrayList object and then attempts to 
	* open a file containing memory errors in hexadecimal format. It reads each error
	* and saves it as a string in the ArrayList.If it cannot find the file RAMerrors it
	* returns false, if it finds it and after reading all the errors it returns true.
	*/
	public static boolean fileOps(ArrayList<String> errorList) throws IOException 
               {
			//get the working directory
			String currentWorkingDir = System.getProperty("user.dir");
			//create the absolute path of the error file.
			String fileName = currentWorkingDir + "/RAMerrors";
			
			//for debug : System.out.println (fileName);         
			//Creaet a file object
			File errorFile = new File(fileName);
			//Check to see if the file exists
			if (!errorFile.exists())
				{	
					//Display an error file not found.
					System.out.println("The file RAMerrors is not found.");
					return false;
				}
			//Create a scanner object to read the file
			Scanner inputFile = new Scanner(errorFile);
			
			//Get all the errors fromt he file
			while (inputFile.hasNext())
				{
					//Read a value from the file and add it to the list
					String error = inputFile.nextLine();
					//Debug : System.out.println(error);
					
					//add the error to the ArrayList.
					errorList.add(error);
					
				}
			return true;  //Return true
		}
	
	public static ArrayList<String> hexToBinary(ArrayList<String> errors)
		{
			ArrayList<String> binErrors = new ArrayList<String>();
			errors.stream().forEach((string) -> 
				{
					binErrors.add(getEachCharVal(string));
				});
			return binErrors;
		}
	public static String getEachCharVal(String errorString)
		{
			String binary =""; 
			char testChar;
			for(int i =0; i < errorString.length(); i++)
			{
				testChar = errorString.charAt(i);
				binary = binary + hexToBin(testChar);
			}
			//System.out.println("**DEBUG** binary = " + binary);
			return binary;
		}
	public static String hexToBin(char convert)
		{
			//System.out.println("**DEBUG** Entered hexToBin");
			String converted ="";
			switch(convert)
			{
			case '0':
				converted = "0000";
				break;
			case '1':
				converted = "0001";
				break;
			case '2':
				converted = "0010";
				break;
			case '3':
				converted = "0011";
				break;
			case '4':
				converted = "0100";
				break;
			case '5':
				converted = "0101";
				break;
			case '6':
				converted = "0110";
				break;
			case '7':
				converted = "0111";
				break;
			case '8':
				converted = "1000";
				break;
			case '9':
				converted = "1001";
				break;
			case 'A':
				converted = "1010";
				break;
			case 'B':
				converted = "1011";
				break;
			case 'C':
				converted = "1100";
				break;
			case 'D':
				converted = "1101";
				break;
			case 'E':
				converted = "1110";
				break;
			case 'F':
				converted = "1111";
				break;
			 
			}
		//System.out.println("**DEBUG** converted = " + converted);
		return converted;			
		}
	public static ArrayList<Double> binToDec(ArrayList<String> binErrors)
		{
			ArrayList<Double> decErrors = new ArrayList<Double>();
			binErrors.stream().forEach((string) -> 
				{
					decErrors.add(getDecVal(string));
				});
			return decErrors;
		
		}
	public static Double getDecVal(String binStr)
		{
			Double value = new Double(0);
			for(int i = 0; i < binStr.length(); i++ )
			{
				if (binStr.charAt(i) == '1')
				{
					value = value + Math.pow(2,(binStr.length() -(1+i)));
				}
			}
		//System.out.println("**DEBUG** value = " + value);

			return value;
		
		}
	public static void print(ArrayList<Double> errorList)
		{
		errorList.stream().forEach((Error) -> 
				{
					findLoc(Error);
				});
			
		}
	public static void findLoc(Double error)
		{
			double Ram3EndAddress = 34359738368.00;
			double Ram2EndAddress = 25769803768.00;
			double Ram1EndAddress = 17179869184.00;
			double Ram0EndAddress = 8589934584.00;
			
			
			if(error>Ram3EndAddress || error<0)
			{
				System.out.printf("%.0f", error);
				System.out.println (" is not an acceptable" 
					+ " address location.");
			}
			else if (error>Ram2EndAddress)
			{
				System.out.print("Error found in RAM chip 3 " 
					+ "at memory address: " );
				System.out.printf("%.0f%n", error);
				
			}
			else if (error>Ram1EndAddress)
			{
				System.out.print("Error found in RAM chip 2 " 
					+ "at memory address: " );
				System.out.printf("%.0f%n", error);
				
			}
			else if (error>Ram0EndAddress)
			{
				System.out.print("Error found in RAM chip 1 " 
					+ "at memory address: " );
				System.out.printf("%.0f%n", error);
				
			}
			else
			{
				System.out.print("Error found in RAM chip 0 " 
					+ "at memory address: " );
				System.out.printf("%.0f%n", error);
				
			}
			
			
		}
	
		
	public static void main (String[] args)
		{
			ArrayList<String> ErrorInput = new ArrayList<String>();
			try
			{
			if (fileOps(ErrorInput))
			{
				System.out.println("Importing errors completed successfully");
			}
			else
			{
				System.out.println("Error locating file, please ensure "
					+ "RAMerrors exists.");
				System.exit(0);
			}
			}
			catch(IOException ex)
			{
				System.out.println("Error opening/reading file.");
			}

			ArrayList<String> binError = hexToBinary(ErrorInput);
		  	ArrayList<Double> decError = binToDec(binError);		
		        print(decError);	
		}
		
}

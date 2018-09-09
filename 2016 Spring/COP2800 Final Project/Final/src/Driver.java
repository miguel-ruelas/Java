/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel A. Ruelas Jacobo
 * COP2800 Final Project
 */
import java.util.Scanner;  // Needed for the Scanner class
import java.io.*;    // For File class and FileNotFoundException

public class Driver {
    
    public static void main (String[] args)  throws IOException 
    {
         String filename = "Accounts.txt"; // File name that stores bank info
         BankAccount account;   // To reference a BankAccount object
         double balance,        // The account's starting balance
                 interestRate,   // The monthly interest rate
                 pay,            // The user's deposit
                 cashNeeded;     // The amount of cash to withdraw
         balance=0;             //initiate temp storage for balance, stored while reading from file or input from user.
         interestRate = 0;      // initiate temp storage for interest rate, stored while reading from file or input from user.        
         boolean inputInfo= false;   // Used to tell program wehter or not to read from file.
         int number ; // A number entered by the user  // Used to for menu selection by user/
         // Create a Scanner object for keyboard input.
         Scanner keyboard = new Scanner(System.in);  

        //Create a FileWriter object to check for existing account info, uses append mode to open the file for editing or create the file if it does not exist.
        FileWriter fwriter = new FileWriter(filename, true);
     
        //Create a file object that points to the Accounts file that exists or was newly created by FileWriter object
        File file = new File("Accounts.txt"); 
     
        //Create a Scanner object to read file.
        Scanner inputFile = new Scanner(file); 
      
      

         //check to see if file has info. If blank then this is the first time the program was ran and it will initiate the new account sequence. 
         if (!inputFile.hasNext())
         {
             //Display that a new account is to be created as file accounts.txt is blank. 
             System.out.println("New savings account creation initiated");      
             
             //do loop for input validation
             do
                 {
                     // Get the starting balance.
                     System.out.print("What is the "
                             + "initial deposit? ");
                     balance = keyboard.nextDouble();
      
                     //Check input
                     if (balance<0)
                             System.out.println("Deposit cannot "
                                     + "be less than 0.");
                 }while (balance<0);
             
             //do loop for input validation    
             do
             {
                 // Get the monthly interest rate.
                 System.out.print("What is the yearly interest rate? ");
                 interestRate = keyboard.nextDouble();
                 if (interestRate<0)
                     System.out.println("Starting interest rate "
                             + "cannot be less than 0.");  
             }while (interestRate<0);
             keyboard.nextLine();   
         } 
         else //else there is information in the file so new account is skipped.
         { 
             System.out.println("Account found!");
        
             //get info from file    
             balance = inputFile.nextDouble();
             interestRate = inputFile.nextDouble();
             
             //set inputinfo flag to true to tell program to gather the previous account info from file after account object is created.
             inputInfo = true;
         }
         // Create a BankAccount object.
         account = new SavingAccount(balance, interestRate); 

         //run if info needs to be updated from file.
         if (inputInfo== true)
         {
             //Get monthly deposits and withdrawls from file.  
             account.setMonDep(inputFile.nextInt());
             account.setMonWith(inputFile.nextInt());
    
             //Close the file.
             inputFile.close(); 
         }
         //Ask user/Employee if this is a new month. This will run the monthly process and calculate interest/fees.
         System.out.print("Is this a new month since your "
                 + "last visit? enter Yes/No: ");
         String str;
         str = keyboard.nextLine(); 
         
         //while loop for input validation.
         while ((!str.equals("Yes")) && (!str.equals("No")))
         {    
             System.out.print("Please enter Yes or No: ");
             str = keyboard.nextLine();
         }
         if (str.equals("Yes"))
             account.monthlyProcess(); 
         
         //do loop for menu.
         do
         {  
             System.out.println();     
             System.out.println();
             System.out.println();      
             System.out.println("Enter \"1\" for balance");
             System.out.println("Enter \"2\" for deposit");
             System.out.println("Enter \"3\" for withdrawl");
             System.out.println("Enter \"4\" for account status");
             System.out.println("Enter \"5\" to exit");
             number = keyboard.nextInt();
             //if look for input validation
             
             while (number<1 || number >5)
             {
                  System.out.println("Please eneter a valid option, 1-5.");
                  number = keyboard.nextInt();
             } 
             
             
             System.out.println();
             System.out.println();
             System.out.println(); 
             
             //switch to execute user selection
             switch (number)           
                {          
                              
                 case 1: System.out.printf("The balance in your savings "   //call the method to get account balance
                         + "account is: $%.2f. \n", account.getBalance()); 
                        break;
                 case 2: do    //do/while loop for input validation                                           
                        {
                        // Get the amount of money to deposit into savings account
                            System.out.print("How much do you want to deposit? "
                                    + "Or enter 0 to cancel.");
                            pay = keyboard.nextDouble();
                            //input validation
                            if (pay<0)
                                System.out.println("That is an invalid"
                                        + " number please enter 0 to cancel or "
                                        + "the ammount you wish to deposit.");      
                        }while (pay<0);
                         // Deposit the user's pay into the account.
                         if (pay>0) //if pay can only be 0 or greater after do while loop. If pay is 0 user chose to cancel and the deposit is skipped.
                         {
                             //Deposit funds into account by calling deposit method.
                             System.out.printf("We will deposit $%.2f. into "
                                     + "your Savings account. \n", pay);
                             account.deposit(pay);
                         }
                         System.out.printf("Your current balance is:"
                                 + " $%.2f. \n", account.getBalance());         
                         break;
                 case 3:do  //do/while loop to validate there is enough money to withdrawl from savings account.
                         {
                             do //do/while loop for input validation
                             {            
                                 // Withdraw some cash from the account.
                                 System.out.print("How much would you like to "
                                         + "withdraw? Or enter 0 to cancel.");
                                 cashNeeded = keyboard.nextDouble();
                                 if (cashNeeded<0)
                                 {               
                                     System.out.println("That is an invalid "
                                             + "number please enter 0 to cancel"
                                             + " or the ammount you wish to "
                                             + "withdraw.");                
                                 }                 
                             }while (cashNeeded<0);
                             //let user know they don't have enough to do the transaction
                             if((account.getBalance()-cashNeeded)<0)
                                 System.out.printf("There are insufficient "
                                         + "funds in this account to complete "
                                         + "this transaction. \nYour current "
                                         + "balance is: "
                                         + "$%.2f \n", account.getBalance());
                         } while((account.getBalance()-cashNeeded)<0);
                         //Transaction can proceed after balance and input validated/
                         account.withdraw(cashNeeded); 
                         System.out.printf("Now your balance is: "
                                 + "$%.2f. \n", account.getBalance());
                         break;
                 case 4: account.getStatus(); //call account status
             }          
         }while (number!=5); //5 exits the menu loop and does the exit
         
         //Display balance on exit
         System.out.printf("Now your balance is: "
                 + "$%.2f. \n", account.getBalance());
         
         //Create new file by overriding existing.
         fwriter = new FileWriter(filename, false);
         
         //Create PrintWriter object to write to file.
         PrintWriter outputFile = new PrintWriter(fwriter);
         
         //Save info to file and close file
         outputFile.println(account.getBalance());
         outputFile.println(account.getInterest());
         outputFile.println(account.getMonDep());
         outputFile.println(account.getMonWith());
         outputFile.close();
      }
}
      
 
      
        
    
    
    
    
    

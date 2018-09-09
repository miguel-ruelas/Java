/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel A. Ruelas Jacobo
 */
public abstract class BankAccount {  
    private double bal= 0;        //Balance
    private int monDep = 0;       //Number of deposits this month
    int monWith = 0;      //Number of withdrawals
    private double rate = 0;      //Annual interest rate
    double monthFee=0;   //Monthly service charges
    
    /**
     * The constructor The constructor should accept arguments for the balance 
     * and annual interest rate.  
     */

     public BankAccount(double b,  double r) 
     {
         //Debug messages System.out.println("**BankAccount Constructor"); //Debug messages
         //Debug messages System.out.println(b);     
         //Debug messages  System.out.println(r);        
         bal = b;   //sets balance
         rate = r; // sets interest rate
     }
     
     /**
      * A method that accepts an argument for the amount of deposit. 
      * The method should add the argument to the account balance. 
      * It should also increment the variable holding the number of deposits.
      */
     
     public deposit (double in)
     {
         //Debug messages System.out.println("**BankAccount deposit");
         bal+= in;  // adds deposit to balance
         monDep++;  // increments the tally of monthly deposits  
          
     }
     
     /**
      * A method that accepts an argument for the amount of the withdrawal. 
      * The method should subtract the argument from the balance. It should 
      * also increment the variable holding the number of withdrawals.
      * @param out 
      */
 
     public withdraw (double out)
     {
         //Debug messages System.out.println("**BankAccount withdraw");
         bal-= out; //substracts withdrawl from balance
         monWith++; // increments the tally of monthly withdrawls
     }
     
     /**
      * A method that updates the balance by calculating the monthly interest 
      * earned by the account, and adding this interest to the balance. This 
      * is performed by the following formulas:
      * Monthly Interest Rate = (Annual Interest Rate/12)
      * Monthly Interest = Balance * Monthly Interest Rate
      * Balance = Balance + Monthly Interest
      */
     
    public calcInterest ()
    {
        //Debug messages System.out.println("**BankAccount calcInterest");
        double monthRate = rate/12;            //Monthly Interest Rate = (Annual Interest Rate/12)
        double monthInterest = bal*monthRate;  //Monthly Interest = Balance * Monthly Interest Rate
        bal+= monthInterest;                   //Balance = Balance + Monthly Interest
        
    }
    
    /**
     * A method that subtracts the monthly service charges from the balance, 
     * calls the calcInterest method, and then sets the variable les that hold 
     * the number of withdrawals, number of deposits and monthly service charge 
     * to zero.
     */  
    
    public monthlyProcess ()
    {
        //Debug messages System.out.println("**BankAccount monthlyProcess");
        bal-= monthFee; //subtract monthly fee from balance
        calcInterest(); //call the calcIntesest method
        monthFee=0;     //set monthly Fee to 0;
        monWith=0;      //set monthly withdrawls to 0;
        monDep=0;       //set monthly deposits to 0; 
    }
    public double getBalance()
    {
        //Debug messages System.out.println("**BankAccount getBalance");
        return bal;
    } 
    /**
     * The getInterest method returns the  
     * value in the interest field.  
     */

   public double getInterest()
   {
       //Debug messages System.out.println("**BankAccount getInterest");
       return rate;
   }
   
   /**
    * The getMonDep method returns the monthly deposits to be written to file
    * upon exiting the program.
    * @return 
    */
   
   public int getMonDep()
   {
       //Debug messages System.out.println("**BankAccount getMonDep");
      return monDep;
   }
   
   /**
    * The setMonDep method receives the deposits read from the file when program
    * begins.
    * @param d 
    */
   public void setMonDep(int d)
   {
       monDep= d;
       //Debug messages System.out.println("**BankAccount setMonDep");
      
   }
   
   /**
    * The getMonWith method returns the monthly withdraws to be written to file
    * upon exiting the program.
    * @return 
    */
   
   public int getMonWith()
   {
       //Debug messages System.out.println("**BankAccount getMonWith");
      return monWith;
   }
   
   /**
    * The setMonWith method receives the withdraws read from the file when program
    * begins.
    * @param w 
    */
   
    public void setMonWith(int w)
   {
       monWith= w;
       //Debug messages System.out.println("**BankAccount setMonWith");
      
   }
    
    /**
    * The getStatus method is to be Overriden by extended classes to send status
    * to program.
    * @param w 
    */
    
   public void getStatus()
    {
        
    }  
}

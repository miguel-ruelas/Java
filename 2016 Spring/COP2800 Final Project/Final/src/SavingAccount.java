/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adminx
 */
public class SavingAccount extends BankAccount {
    
    boolean status = false;   //status field to represent an active or inactive account
    final double minBal= 25;  //The minimum balance to have an active account
    
    
    public SavingAccount(double b, double r) 
    {
        super(b,r); //initialize the savings account
      System.out.println("**SavingAccount Constructor");
        
    }
        
    
    /**
     * A method that determines whether the account is inactive before a 
     * withdrawal is made. No withdrawal will be allowed if the account is not 
     * active. A withdrawal is then made by calling the super-class version of 
     * the method.
     */
    
    public void withdraw(double out)
    {
        
      //Debug messages   System.out.println("**SavingAccount withdraw");
        status();
        if (status==true)
        {
            super.withdraw(out);  
            status();
        }
        
    }
    
    /**
     * A method that determines whether the account is inactive before a deposit
     * is made. If the account is inactive and the deposit brings the balance 
     * above $25, the account becomes active again. The deposit is then made by 
     * calling the super-class version of the method
     * @param in 
     */
    
    @Override
    public void deposit(double in)
    {
       
       //Debug messages  System.out.println("**SavingAccount deposit");
        status();
        super.deposit(in);
        status();
    }
    
    /**
     * Before the super-class method is called, this method checks the number 
     * of withdrawals. If the number of withdrawals for the month is more than 
     * 4, a service charge of $1 for each withdrawal above 4 is added to the 
     * super-class fields that holds the monthly service charges. 
     * (Don’t forget the check the account balance after the service charge 
     * is taken. If the balance falls below $25, the account becomes inactive.)
     */
    
    @Override
    public void monthlyProcess()
    {
        //Debug messages System.out.println("**SavingAccount monthlyProcess");
        if(monWith>= 4)
        {
            final double fee = 1.00;
            int numFee;
            numFee = (monWith/4 + monWith%4);
            monthFee= fee*numFee;
            System.out.printf("Your account has been "
                    + "charged $%.2f ", monthFee);
            System.out.print("for " + numFee + " excess withdrawls.\n");
        }
        super.monthlyProcess();
        status();
    }
    
    /**
     * status() Method checks the balance to see if it there is enough balance 
     * to remain active.
     */
    public void status()
    {
       //Debug messages  System.out.println("**SavingAccount status");
        if (getBalance()>=25)
        {
            status=true;
            System.out.println("Your account is active");
        }
        else 
        {
            status=false;
            System.out.println("Your account is inactive");
            System.out.println("$" + getBalance() + " is needed to activate"
                    + " this account.");
        }
        System.out.println("Your account has " + monWith 
                + " withdrawls this month" );
            
    }
    /**
     * the getStatus() method returns status to program when user 
     * selects it from the menu.
     */
    
    @Override
    public void getStatus()
    {
        status();
        
    } 
}

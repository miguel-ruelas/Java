import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;  // Needed for the Scanner class
import java.io.*;    // For File class and FileNotFoundException

/**
 *  This class demonstrates a combo box.
 */

public class ComboBoxWindow extends JFrame
{
   private JPanel SavAccountPanel;         // To hold components
   private JPanel selectedSavAccountPanel; // To hold components
   private JComboBox Choice;        // List of selectChoices
   private JLabel label;               // To display a message
   private JTextField selectedChoice;  // The selected selectChoice

   // The following array holds the values that will be
   // displayed in the Choice combo box.
   private String[] selectChoice = { "Balance", "Withdrawls"
                          };
   String Bal , With;

   /**
    *  Constructor receives balance and withdraws from main method.
    */

   public ComboBoxWindow(String b, String w )
   {
      // Call the JFrame constructor.
      super("Savings account Display");
      
      Bal=b;
      With=w;

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager for the content pane.
      setLayout(new BorderLayout());

      // Build the panels.
      buildSavAccountPanel();
      buildSelectedSavAccountPanel();

      // Add the panels to the content pane.
      add(SavAccountPanel, BorderLayout.CENTER);
      add(selectedSavAccountPanel, BorderLayout.SOUTH);

      // Pack and display the window.
      pack();
      setVisible(true);
   }

   /**
    *  The buildSavAccountPanel method adds a combo box with the
    *  types of selectChoice to a panel.
    */

   private void buildSavAccountPanel()
   {
      // Create a panel to hold the combo box.
      SavAccountPanel = new JPanel();

      // Create the combo box
      Choice = new JComboBox(selectChoice);

      // Register an action listener.
      Choice.addActionListener(new ComboBoxListener());

      // Add the combo box to the panel.
      SavAccountPanel.add(Choice);
   }

   /**
    *  The buildSelectedSavAccountPanel method adds a read-only
    *  text field to a panel.
    */

   private void buildSelectedSavAccountPanel()
   {
      // Create a panel to hold the text field.
      selectedSavAccountPanel = new JPanel();

      // Create the label.
      label = new JLabel("You selected: ");

      // Create the uneditable text field.
      selectedChoice = new JTextField(10);
      selectedChoice.setEditable(false);

      // Add the label and text field to the panel.
      selectedSavAccountPanel.add(label);
      selectedSavAccountPanel.add(selectedChoice);
   }

   /**
    *  Private inner class that handles the event when
    *  the user selects an item from the combo box. 
    */

   private class ComboBoxListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
          
          
         
         String selection = (String) Choice.getSelectedItem();
         if ("Balance".equals(selection))
         {
         
         System.out.println("Balance");
         selectedChoice.setText(Bal);
         }
         else if ("Withdrawls".equals(selection))
         {
             
             System.out.println("Withdrawls");
             selectedChoice.setText(With);
         }
      }
   }
   
   /**
    *  The main method creates an instance of the class, gets the bank info 
    * from file which causes it to display its window.
    */

   public static void main(String[] args) throws IOException 
   {
       
      System.out.println("Main");
      System.out.println("Action");
      String filename = "GuiAccounts.txt"; // File name
      BankAccount account;   // To reference a BankAccount object         
      double balance,        // The account's starting balance
              interestRate;  
      
      //Debug message System.out.println("Before open file");
      //Create File object to open file
      File file = new File("GuiAccounts.txt"); 
      
      //Create Scanner object to read from file
      Scanner inputFile = new Scanner(file); 
      
      //Debug message System.out.println("After open file");
      
      //Read balance and interest rate from file.
      balance = inputFile.nextDouble();
      interestRate = inputFile.nextDouble();
      
      //Use balance and interest rate to create account object
      account = new SavingAccount(balance, interestRate);     
      
      /**Once account object is created, read deposit/withdraws and send to set
       * methods in account class.
       */ 
      
      account.setMonDep(inputFile.nextInt());
      account.setMonWith(inputFile.nextInt());
      
      //close the file.
      inputFile.close(); 
      
    //Format the balance into String format to be displayed in box
     String stringbal =  String.format( "%.2f", balance);
     
     
     //Format withdraws into string format to be displayed in box
     String stringwith =  String.valueOf(account.getMonWith());
     
     //Create ComboBox with formated Strings.
     new ComboBoxWindow(stringbal,stringwith);
    
      
     
   }
}
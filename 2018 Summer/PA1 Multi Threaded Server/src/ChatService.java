/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adminx
 */
public class ChatService implements Runnable {
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private ChatData chData;
    private ChatRoom ChRm;
    LatestChatDisplay usr;
    int ID =-1;
    int chID=-1;
    
    
    public ChatService(Socket aSocket, ChatData ch)
    {
        s = aSocket;
        System.out.println("Service started");
        chData = ch;
    }
    @Override
    public void run()
    {
        try
        {
         try
         {
            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream());
            initService();            
         }
         finally
         {
    
            if (ID != -1)
            {
                chData.removeUser(ID);
            }
            if(ChRm!= null)
            {
                ChRm.speak(0, ID+ " left the chat.");
                if (usr!= null)
                {
                 ChRm.removeObserver(usr);
                }
            }
                            
            s.close();
           
           
            
            System.out.println("Service stopped");
         }
       }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
        
    }
    
    public void initService() throws IOException
    {
       int logAttempts=0;
        out.println("Enter USER ID(1-100)");
        out.flush();
        try 
        {
                while(!in.hasNext())
                {       
                    return;
                }
                if(in.hasNextInt()) 
                {
                    ID = in.nextInt();  
                   
                }
                
                if (ID<1 || ID>100)
                {
                    out.println("\nInvalid Input Detected, Goodbye!");
                    out.flush();
                    return;
                }
                while (!validateUser(ID) && logAttempts < 4)
                {
                    ID=-1;
                    out.println("\nPlease enter a different user ID!");
                    out.flush();
                    if(in.hasNextInt()) 
                    {
                    ID = in.nextInt();  
                    }
                    logAttempts++;

                }
                if ( ID==-1)
                {
                     out.println("\nNumber of attempts reached Goodbye!!");
                    out.flush();
                    return;
                }
                out.println("\nWelcome USER " + ID);
                out.println("\nEnter CHAT ID");
                out.flush();
               
                
                while(!in.hasNext())
                {       
                    this.wait(10);
                }
                if(in.hasNextInt()) 
                {
                    chID = in.nextInt();  
                   
                }
                if (chID<1 || chID>100)
                {

                    out.println("\nInvalid Input Detected, Goodbye!");
                    out.flush();
                    
                    return;
                }
                if (chData.addChatRoom(chID))
                {
                    out.println("\nCreating CHAT:" + chID);
                   
                }
               
                    ChRm = chData.getChatRoom(chID);
                    out.println("\nEnterring CHAT:" + chID);
                    out.flush();           
               
               
         
        } 
        catch (InterruptedException ex) 
        {
              Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        usr = new LatestChatDisplay(ChRm, out);
       
        ChRm.speak(0, ID+ " joined the chat.");

        String command ="";
        
        while (command!="LOGOUT")
        {
            out.println("Enter Command:");
            out.flush();
            if (!in.hasNext()) { return; }
            command = in.next();
            System.out.println("Command:"+ command);
            if (command.equals("LOGOUT")) {
                //ChRm.speak(0, ID+ " left the chat.");
                //ChRm.removeObserver(usr);
                //chData.removeUser(ID);
           
                return; }
            else { executeCommand(command, ID); }
        }
        
    }
    
    public boolean validateUser(int ID)
    {
        if (chData.addUser(ID))
            return true;
        else return false;
        
        
    }
    
    public void executeCommand(String command, int ID)
    {
        if (command.equals("SPEAK"))
        {
            String input = in.nextLine(); 
            ChRm.speak(ID, input);
        }
        else
        {
            String input = command + in.nextLine(); 
            ChRm.speak(ID, input);
        }

    }
    
}

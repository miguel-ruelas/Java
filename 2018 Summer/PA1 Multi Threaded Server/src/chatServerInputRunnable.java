
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adminx
 */
class chatServerInputRunnable implements Runnable {
    
    Socket SrvIn;
    
     chatServerInputRunnable(Socket aSocket)
     {
         SrvIn = aSocket;
         System.out.println("SrvIN Created");
     }

    @Override
    public void run() 
    {
           System.out.println("SrvIN Running");
         
        try {
            InputStream instream = SrvIn.getInputStream();
            Scanner in = new Scanner(instream);
             while(true)
                {
             
             while(!in.hasNext())
             {
                 return;
             }
            String response = "";
            response = in.nextLine();
            System.out.println(response);
           
             }
        }
        catch (IOException ex) {
            Logger.getLogger(chatServerInputRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
     System.out.println("SrvIN Stopping");

        
      
       
    }
    
}

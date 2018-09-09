
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
class chatUserInputRunnable  implements Runnable
{
    Socket s;
    Scanner kbScanner = new Scanner(System.in);
    

    chatUserInputRunnable(Socket aSocket) {
        s= aSocket;
    }
    
     @Override
    public void run() 
    {
        try {
            OutputStream outstream = s.getOutputStream();
            PrintWriter out = new PrintWriter(outstream);
            while(true)
         {
             String usrInput = "";
             while(!kbScanner.hasNext())
             {
                 return;
             }
            
            usrInput = kbScanner.nextLine();
            out.println(usrInput);
         }
        } catch (IOException ex) {
            Logger.getLogger(chatUserInputRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }

         
      
      
    }
}

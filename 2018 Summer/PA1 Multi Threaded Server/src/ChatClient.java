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
import java.util.Scanner;


/**
 *
 * @author adminx
 */
public class ChatClient {
    public static void main(String[] args) throws IOException
    {
        final int SBAP_PORT = 8081;
        try (Socket s = new Socket("localhost", SBAP_PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
           
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);
            Scanner kbScanner = new Scanner(System.in);
           
            String response;
            String usrIn;
            String command;
            int ID = 1;
            int Rm = 1;
            
            //ID
            out.print(ID +"\n");
            out.flush();
            //CHRm
            out.print(Rm + "\n");
            out.flush();
            
            command = "SPEAK Hi I am " + ID + "\n";
            System.out.print("Sending: " + command);
            out.print(command);
            out.flush();
            System.out.println("Receiving: ");
            boolean EOF = false;
            while (EOF!=true)
            { 
                response = in.nextLine();
                if(response.compareTo("EOF") == 0)
                {
                    System.out.println("EOF REACHED: ");
                    EOF=true;
                }
                else
                System.out.println(response);
            }
            s.close();

        }
    }
    
}

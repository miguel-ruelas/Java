/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author adminx
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //Not used properly. Need a new thread to keep track of active connections
        ArrayList<Thread> ActiveConnections = new ArrayList<>(); 
        
        ChatData chat = new ChatData();
        final int SBAP_PORT = 8081;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");
        
        while(true)
        {
         Socket s = server.accept();
         System.out.println("Client connected.");
         ChatService service = new ChatService(s, chat);
         Thread t = new Thread(service);
         t.start();
         ActiveConnections.add(t); 


        
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

/**
 *
 * @author adminx
 */
public class ChatRoom implements Subject{
    
    private int ID;
    private Lock logChangeLock;
    private LinkedList<ChatMessage> chatLog;
    private List<Observer> observers; //Master list of occupants, observers have PrintWriter references
    
    /**
     * Creates a new ChatRoom with the ID specified
     * @param id 
     */
    public ChatRoom(int id)
    {
        this.ID = id;
        logChangeLock = new ReentrantLock();
        chatLog = new LinkedList<ChatMessage>();
        this.observers=  new ArrayList<>();
    }
    
    public void speak(int id, String input)
    {  
      logChangeLock.lock();
      try
      {
         ChatMessage msg =new ChatMessage(id, input);
         System.out.println("Message Created:" + msg.toString());
         chatLog.add(msg);
         notifyObservers();
     
      }
      finally
      {
         logChangeLock.unlock();
      }
      
    }
    
    @Override
    public String toString()
    {
        String chtlg = "";
        
        for(int num=0; num<chatLog.size(); num++)
        {
    	  chtlg +=(chatLog.get(num).toString())+"\n";
        }
        return chtlg;
    }
    

    @Override
    public void registerObserver(Observer obj) {
         if(obj == null) throw new NullPointerException("Null Observer");
        observers.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0)
        {
            observers.remove(i);
            
        }
    }

    @Override
    public void notifyObservers() {
        for (int i=0; i < observers.size();i++)
        {
            Observer observer = (Observer)observers.get(i);
            observer.update(chatLog);
        }
    }
    
    public int getID()
    {
        return ID;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author adminx
 */
public class ChatData {
    
   private ArrayList<ChatRoom> ChRms;
   private Lock chRmChangeLock;
   private ArrayList<Integer> Users;
   private Lock usrChangeLock;
    public ChatData()
   {   
      ChRms = new ArrayList<>();
      chRmChangeLock = new ReentrantLock();
      Users = new ArrayList<>();
      usrChangeLock = new ReentrantLock();
   }
    
   public boolean addUser(int usr)
   {  
      usrChangeLock.lock();
      System.out.println("UserLockon:Add");
      try
      {
         Integer newUsr = usr;
         if(Users.contains(newUsr))
                 return false;
         else
         {
             Users.add(newUsr);
             return true;
         }


      }
      finally
      {
         usrChangeLock.unlock();
         System.out.println("UserLockoff:Add");
      }
   }
   
    public boolean removeUser(int usr)
   {  
      usrChangeLock.lock();
      System.out.println("UserLockon:Remove");
      try
      {
         Integer remUsr = usr;
         if(Users.contains(remUsr))
         {
             Users.remove(remUsr);
                     return true;
         }
        else
         {
             return false;
         }
      }
      finally
      {
         usrChangeLock.unlock();
         System.out.println("UserLockoff:Rem");
      }
   }
    
    public boolean addChatRoom(int chRm)
   {  
      usrChangeLock.lock();
      System.out.println("ChatLockon:Add");
      try
      { 
         if(findChatIndex(chRm)> -1)
                 return false;
         else
         {
             ChatRoom nwRm = new ChatRoom(chRm);
            ChRms.add(nwRm);
             return true;
         }
      }
      finally
      {
         usrChangeLock.unlock();
         System.out.println("ChatLockOff:Add");
      }
   }
   
    public boolean removeChatRoom(int chRm)
   {  
      usrChangeLock.lock();
      System.out.println("ChatLockon:Rem");
      try
      {
         int index;
         if((index = findChatIndex(chRm))> -1)
         {
             ChRms.remove(index);
                     return true;
         }
        else
         {
             return false;
         }
      }
      finally
      {
         usrChangeLock.unlock();
         System.out.println("ChatLockOff:Rem");
      }
   }

     private int findChatIndex(int chID) 
     {
         int index = 0;
        for (ChatRoom test : ChRms)
        {
            if(test.getID()==chID)
            {
                 return index;
            }
            index++;
        }
        return -1;
    }

    ChatRoom getChatRoom(int chID) 
    {
        ChatRoom test;
        
        if (findChatIndex(chID)>-1)
        {
            test = ChRms.get(findChatIndex(chID));
            return test;
        } 
        return null; 
        
        
    }
     


    
}

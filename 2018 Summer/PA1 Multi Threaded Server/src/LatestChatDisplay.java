/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.util.List;

/**
 *Observer
 * @author adminx
 */
class LatestChatDisplay implements Observer{
    ChatRoom subject;
    List<ChatMessage> list;
    PrintWriter OUT;

    LatestChatDisplay(ChatRoom chtrm, PrintWriter out) {
        this.subject = chtrm;
        chtrm.registerObserver(this);
        this.OUT = out;
        
    }

    

    @Override
    public void update(List<ChatMessage> lst) {
        this.list = lst;
        display();
    }

    private void display() {
        OUT.println("--- CHAT LOG ----" );
        OUT.flush();
        for(int i =0; i<list.size();i++)
        {
            ChatMessage temp = list.get(i);
            OUT.println(temp.toString());
        }
        OUT.println("" );
        OUT.flush();
    }

    @Override
    public void setSubject(ChatRoom sub) {
        this.subject = sub;
    }
    
}

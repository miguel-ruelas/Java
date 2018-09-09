/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author adminx
 */
public class ChatMessage {
    
    private int ID;
    private Timestamp  msgDate ;
    private String msgText ="";
    
    public ChatMessage(int id, String txt)
    {
        ID=id;
        msgDate = new Timestamp(System.currentTimeMillis());
        msgText = txt;
    }
    @Override
    public String toString()
    {
        String msgDetails = msgDate + " ID:"+ ID + " =" + msgText;
        return msgDetails;
    }
    
}

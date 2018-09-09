/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author adminx
 */
public interface Observer {
    public void update(List<ChatMessage> list);
    public void setSubject(ChatRoom sub);
    
}

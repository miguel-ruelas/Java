Client Server Communications ChatServer 1.0
Protocol

USER Login:
CLIENT/SERVER REQUEST     | SERVER RESPONSE       | DESCRIPTION
  SRV REQUEST - ID int    | ID Accept Message     | Server requests user ID Welcome user is displayed
  SRV REQUEST - CHID int  | CHID Accept Message   | Chat Room is created and or User enters Chat room

After Login:
ChatRoom
CLIENT Commands    | SERVER RESPONSE       | DESCRIPTION
  SPEAK            | Updated Chat Log      | All users in chat room are updated with new messages
  LOGOUT  	   | Logout Message        | User is logged out and Chat Room message is broadcast.
  line of string   | Updated Chat Log      | All users in chat room are updated with new messages 
 
  
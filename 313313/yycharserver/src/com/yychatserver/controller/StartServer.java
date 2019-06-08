package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.yychat.model.Message;
import com.yychat.model.User;


public class StartServer {
                public static HashMap hmSocket=new HashMap<String,Socket>();
				ServerSocket ss;
				Socket s;
                String userName;
                String passWord;
                Message mess;
                ObjectOutputStream oos;
                
                public StartServer(){                	
                	try{//�����쳣
                		ss=new ServerSocket(3456);
                		System.out.println("�������Ѿ�����������3456�˿�"); 
                		while(true){
                		s=ss.accept();//���տͻ�����������
                		System.out.println("���ӳɹ���"+s);
                		
                		//����User����
                		ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
                		User user=(User)ois.readObject();
                		userName=user.getUserName();
                	    passWord=user.getPassWord();	
                		System.out.println(userName);
                		System.out.println(passWord);
                		
                		if(user.getUserMessageType().equals("USER_REGISTER")){
                			boolean seekUserResult=YychatDbUtil.seekUser(userName);
                			mess=new Message();
                			mess.setSender("Server");
                			mess.setReceiver(userName);
                			if(seekUserResult){
                				mess.setMessageType(Message.message_RegisterFailure);
                			}else{
                				YychatDbUtil.addUser(userName,passWord);
                				mess.setMessageType(Message.message_RegisterSuccess);
                			}
                			sendMessage(s,mess);
                			s.close();
                		}
                		
                		if(user.getUserMessageType().equals("USER_LOGIN")){	
                			//ʵ��������֤����*/
                    		
                    		boolean loginSuccess=YychatDbUtil.loginValidate(userName, passWord);
                    		
                    		mess=new Message();//��֤����
                			mess.setSender("Server");
                			mess.setReceiver(userName);
                    		if(loginSuccess){//����Ƚ�                		
                    			mess.setMessageType(Message.message_LoginSuccess);//"1"Ϊ��֤ͨ��
                    			
                    			/*String friend_Relation_Sql="select * from relation where majoruser=? and relationtype='1'";
                				ptmt=conn.prepareStatement(friend_Relation_Sql);
                				ptmt.setString(1, userName);
                				rs=ptmt.executeQuery();*/
                    			String friendString=YychatDbUtil.getFriendString(userName);
                				/*String friendType="";
                				while(rs.next()){
                					friendType=friendType+rs.getString("slaveuser")+" ";            					
                				}*/
                    		  mess.setContent(friendString);
                    		  System.out.println(userName+"��relation���ݱ��к��ѣ�"+friendString);
                				
                    		}else{
                    			mess.setMessageType(Message.message_LoginFailure);//"0"Ϊ��֤��ͨ��                			
                    		}
                    		//ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                    		//oos.writeObject(mess);
                    		sendMessage(s,mess);
                    		//
                    		if(loginSuccess){
                    			mess.setMessageType(Message.message_Newpy);
                    			mess.setSender("Server");
                    			mess.setContent(userName);
                    			
                    			Set onlineFriendSet=hmSocket.keySet();
                    			Iterator it=onlineFriendSet.iterator();
                    		    String friendName;
                    			while(it.hasNext()){
                    				friendName=(String)it.next();
                    				mess.setReceiver(friendName);
                    				Socket s1=(Socket)hmSocket.get(friendName);
                    				sendMessage(s1, mess);
                    			}
                    			
                    			hmSocket.put(userName, s);                		
                    		new ServerReceiverThread(s).start();
                    	}
                    		}
                    	}
                		}               		
                	catch(IOException|ClassNotFoundException e){
                		e.printStackTrace();//�����쳣
                	}					                	
                }
                private void sendMessage(Socket s,Message mess) throws IOException {			
        			oos=new ObjectOutputStream(s.getOutputStream());
                	 oos.writeObject(mess);
        		}
}

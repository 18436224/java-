package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
                		
                		//ʵ��������֤����
                		
                		mess=new Message();//��֤����
            			mess.setSender("Server");
            			mess.setReceiver(userName);
                		if(user.getPassWord().equals("123456")){//����Ƚ�                		
                			mess.setMessageType(Message.message_LoginSuccess);//"1"Ϊ��֤ͨ��
                			
                		}else{
                			mess.setMessageType(Message.message_LoginFailure);//"0"Ϊ��֤��ͨ��                			
                		}
                		//ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
                		//oos.writeObject(mess);
                		sendMessage(s,mess);
                		//
                		if(user.getPassWord().equals("123456")){
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
                	}catch(IOException e){
                		e.printStackTrace();//�����쳣
                	}catch (ClassNotFoundException e){
                		e.printStackTrace();
                	}
                	
                }
                private void sendMessage(Socket s,Message mess) throws IOException {			
        			oos=new ObjectOutputStream(s.getOutputStream());
                	 oos.writeObject(mess);
        		}
}
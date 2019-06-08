package com.yychatserver.controller;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YychatDbUtil {
	public static final String MYSQLDRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/YYchat";
	public static final String DBUSER="root";
	public static final String DBPASS="";

	//ʹ�����ݿ�����û�������֤
	//1��������������
	public static void loadDriver(){
		try{
			Class.forName(MYSQLDRIVER);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//��ȡ���Ӷ���
	public static Connection getConnection(){
		loadDriver();
		Connection conn=null;
		try{
			conn=DriverManager.getConnection(URL,DBUSER,DBPASS);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int addRelation(String majorUser,String slaveUser,String relationType){
		int count=0;
		Connection conn=getConnection();
		//3������PreparedStatement��������ִ��SQL���
		String relation_Add_Sql="insert into relation(majoruser,slaveuser,relationtype) values(?,?,?)";
		PreparedStatement ptmt=null;
		try{
			ptmt=conn.prepareStatement(relation_Add_Sql);
			ptmt.setString(1, majorUser);
			ptmt.setString(2, slaveUser);
			ptmt.setString(3, relationType);
						
			
			//4��ִ�в�ѯ�����ؽ����
			count=ptmt.executeUpdate();
			
			//5�����ݽ�������ж��Ƿ��ܵ�¼				
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeDB(conn,ptmt);
		}
		return count;
	}		
	
	public static void addUser(String userName,String passWord){		
		Connection conn=getConnection();
		//3������PreparedStatement��������ִ��SQL���
		String user_Login_Sql="insert into user(username,password,registertimestamp) values(?,?,?)";
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=conn.prepareStatement(user_Login_Sql);
			ptmt.setString(1, userName);
			ptmt.setString(2, passWord);
			
			Date date=new Date();
			java.sql.Timestamp timestamp=new java.sql.Timestamp(date.getTime());
			
			ptmt.setTimestamp(3, timestamp);
			
			//4��ִ�в�ѯ�����ؽ����
			int count=ptmt.executeUpdate();
			
			//5�����ݽ�������ж��Ƿ��ܵ�¼				
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeDB(conn,ptmt,rs);
		}
	}
	
	public static boolean seekUser(String userName){
		boolean seekUserResult=false;
		Connection conn=getConnection();
		//3������PreparedStatement��������ִ��SQL���
		String user_Login_Sql="select * from user where userName=?";
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=conn.prepareStatement(user_Login_Sql);
			ptmt.setString(1, userName);			
			//4��ִ�в�ѯ�����ؽ����
			rs=ptmt.executeQuery();
			
			//5�����ݽ�������ж��Ƿ��ܵ�¼
			seekUserResult=rs.next();	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeDB(conn,ptmt,rs);
		}
		return seekUserResult;
	}
	
	public static boolean loginValidate(String userName,String passWord){
		boolean loginSuccess=false;
		Connection conn=getConnection();
		//3������PreparedStatement��������ִ��SQL���
		String user_Login_Sql="select * from user where userName=? and passWord=?";
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=conn.prepareStatement(user_Login_Sql);
			ptmt.setString(1, userName);
			ptmt.setString(2, passWord);
			//4��ִ�в�ѯ�����ؽ����
			rs=ptmt.executeQuery();
			
			//5�����ݽ�������ж��Ƿ��ܵ�¼
			loginSuccess=rs.next();	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeDB(conn,ptmt,rs);
		}
          System.out.println("loginSuccessΪ:"+loginSuccess);    
            return loginSuccess;
	}

	public static boolean seekRelation(String majorUser,String slaveUser,String relationType){
		boolean seekRelationResult=false;
		Connection conn=getConnection();
		String seek_Relation_Sql="select * from relation where majoruser=? and slaveuser=? and relationtype=?";
		PreparedStatement ptmt=null;		
		ResultSet rs=null;
		try{
			ptmt=conn.prepareStatement(seek_Relation_Sql);
			ptmt.setString(1, majorUser);
			ptmt.setString(2, slaveUser);
			ptmt.setString(3, relationType);
			rs=ptmt.executeQuery();
			//String friendType="";
			seekRelationResult=rs.next();
	  }catch (SQLException e){
		e.printStackTrace();
	 }finally{
		closeDB(conn,ptmt,rs);
	 }			
	      return seekRelationResult;
	 }
	
	public static String getFriendString(String userName){
		Connection conn=getConnection();
		String friend_Relation_Sql="select * from relation where majoruser=? and relationtype='1'";
		PreparedStatement ptmt=null;
		String friendString="";
		ResultSet rs=null;
		try{
			ptmt=conn.prepareStatement(friend_Relation_Sql);
			ptmt.setString(1, userName);
			rs=ptmt.executeQuery();
			//String friendType="";
			while(rs.next()){
				friendString=friendString+rs.getString("slaveuser")+" "; 
				System.out.println("���ݿ��к��ѵ�����:"+rs.getString("slaveuser"));
		}
	}catch (SQLException e){
		e.printStackTrace();
	}finally{
		closeDB(conn,ptmt,rs);
	}
		System.out.println("ȫ�����ѣ�"+friendString);
		return friendString;
	}		
	
	public static void closeDB(Connection conn,PreparedStatement ptmt){
		  if(conn!=null){
			  try{
				  conn.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		  }
		  if(ptmt!=null){
			  try{
				  ptmt.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		  }		 
	  }

  public static void closeDB(Connection conn,PreparedStatement ptmt,ResultSet rs){
	  if(conn!=null){
		  try{
			  conn.close();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
	  if(ptmt!=null){
		  try{
			  ptmt.close();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
	  if(rs!=null){
		  try{
			  rs.close();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
  }
}
	
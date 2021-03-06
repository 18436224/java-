package com.chatclient.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
           CardLayout cardLayout;
           
           JPanel myFriendPanel;
           JButton myFriendJButton;
           
           JScrollPane myFriendJScrollPane;
           JPanel myFriendListJPanel;
           static final int FRIENDCOUNT=51;
           JLabel[] myFriendJLabel=new JLabel[FRIENDCOUNT];
           
           JScrollPane sky;
           JPanel myStrangerListJPanel;
           static final int A=21;
           JLabel[] myStrangerJLabel=new JLabel[A];
           
           JPanel myStrangerBlackListJPanel;
           JButton myStrangerJButton;
           JButton blackListJButton;
           
           JPanel myStrangerPanel;
           
           JPanel myFriendStrangerPanel;
           JButton myFriendJButton1;
           JButton myStrangerJButton1;
           
           JButton blackListJButton1;
           
           String userName;
           
	public FriendList(String userName) {
		this.userName=userName;
		myFriendPanel=new JPanel(new BorderLayout());//边界布局
		
		myFriendJButton=new JButton("我的好友");
		myFriendPanel.add(myFriendJButton,"North");
		
		myFriendListJPanel=new JPanel(new GridLayout(FRIENDCOUNT-1,1));
		for(int i=1;i<FRIENDCOUNT;i++)
		{
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy4.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
		    myFriendListJPanel.add(myFriendJLabel[i]);
		}
		
		myFriendJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendJScrollPane);
		
		myStrangerBlackListJPanel=new JPanel(new GridLayout(2,1));
		myStrangerJButton=new JButton("我的陌生人");
		
		
		myStrangerJButton.addActionListener(this);
		
		blackListJButton=new JButton("黑名单");
		myStrangerBlackListJPanel.add(myStrangerJButton);
		myStrangerBlackListJPanel.add(blackListJButton);
		myFriendPanel.add(myStrangerBlackListJPanel,"South");
		
		
		
		myStrangerPanel=new JPanel(new BorderLayout());
		
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
		myFriendJButton1=new JButton("我的好友");
		myFriendJButton1.addActionListener(this);
		myStrangerJButton1=new JButton("我的陌生人");
		myFriendStrangerPanel.add(myFriendJButton1);
		myFriendStrangerPanel.add(myStrangerJButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");
		
		myStrangerListJPanel=new JPanel(new GridLayout(A-1,1));
		for(int s=1;s<A;s++)
		{
			myStrangerJLabel[s]=new JLabel(s+"",new ImageIcon("images/yy4.gif"),JLabel.LEFT);
			myStrangerJLabel[s].addMouseListener(this);		    
			myStrangerListJPanel.add(myStrangerJLabel[s]);
		}
		
		sky=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(sky);
		
		blackListJButton1=new JButton("黑名单");
		myStrangerPanel.add(blackListJButton1,"South");
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel,"2");
		
		this.setSize(150,500);
		this.setTitle(userName+" 的好友列表");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==myStrangerJButton)
		{
			cardLayout.show(this.getContentPane(),"2");
		}
		if(arg0.getSource()==myFriendJButton1){
			cardLayout.show(this.getContentPane(),"1");
		}
	}

	public static void main(String[] args) 
    {
   //FriendList FriendList=new FriendList();
}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		 if(arg0.getClickCount()==2){
			 JLabel jlbl=(JLabel)arg0.getSource();
			 String recever=jlbl.getText();
		  new FriendChat(this.userName,recever);		  
		 }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.black);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

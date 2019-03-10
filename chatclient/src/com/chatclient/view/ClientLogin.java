package com.chatclient.view;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class ClientLogin extends JFrame
{
    JLabel jlbl1;
    
    JTabbedPane jtp1;   
    JPanel jp2,jp3,jp4;
    JLabel jlbl2,jlbl3,jlbl4,jlbl5;
    JLabel jlbl6,jlbl7,jlbl8,jlbl9;
    JLabel jlblA,jlblB,jlblC,jlblD;
    JTextField jtf1,jtf2,jtf3;
    JPasswordField jpf1,jpf2,jpf3;
    JButton jb4;
    JCheckBox jcb1,jcb2;
    JCheckBox jcb3,jcb4;
    JCheckBox jcb5,jcb6;
    
    JButton jb1,jb2,jb3;
    JPanel jp1;
	public ClientLogin() 
	{
		jlbl1=new JLabel(new ImageIcon("images/tou.gif"));
		this.add(jlbl1,"North");
		
        jp2=new JPanel(new GridLayout(3,3));
        jp3=new JPanel();jp4=new JPanel();
        //第一个版块
		jlbl2=new JLabel("QQ号码",JLabel.CENTER);jlbl3=new JLabel("QQ密码",JLabel.CENTER);
		jlbl4=new JLabel("忘记密码",JLabel.CENTER);
		jlbl4.setForeground(Color.blue);
		jlbl5=new JLabel("申请密码保护",JLabel.CENTER);
		jtf1=new JTextField();
		jpf1=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb1=new JCheckBox("隐身登录");jcb2=new JCheckBox("记住密码");
        jp2.add(jlbl2); jp2.add(jtf1); jp2.add(jb4);
        jp2.add(jlbl3); jp2.add(jpf1); jp2.add(jlbl4);
        jp2.add(jcb1); jp2.add(jcb2); jp2.add(jlbl5);
        
        jtp1=new JTabbedPane();
        jtp1.add(jp2,"QQ号码");jtp1.add(jp3,"手机号码");jtp1.add(jp4,"电子邮箱");
        this.add(jtp1);              
        //第二个版块
		jp3=new JPanel(new GridLayout(3,3));
		jlbl6=new JLabel("手机号码",JLabel.CENTER);jlbl7=new JLabel("手机验证密码",JLabel.CENTER);
		jlbl8=new JLabel("没收到密码",JLabel.CENTER);
		jlbl8.setForeground(Color.blue);
		jlbl9=new JLabel("申请密码保护",JLabel.CENTER);
		jtf2=new JTextField();
		jpf2=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb3=new JCheckBox("隐身登录");jcb4=new JCheckBox("记住密码");
        jp3.add(jlbl6); jp3.add(jtf2); jp3.add(jb4);
        jp3.add(jlbl7); jp3.add(jpf2); jp3.add(jlbl8);
        jp3.add(jcb3); jp3.add(jcb4); jp3.add(jlbl9);
		//第3个版块
        jp4=new JPanel(new GridLayout(3,3));
		jlblA=new JLabel("邮箱地址",JLabel.CENTER);jlblB=new JLabel("登录密码",JLabel.CENTER);
		jlblC=new JLabel("忘记地址",JLabel.CENTER);
		jlblC.setForeground(Color.blue);
		jlblD=new JLabel("申请密码保护",JLabel.CENTER);
		jtf3=new JTextField();
		jpf3=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb5=new JCheckBox("隐身登录");jcb6=new JCheckBox("记住密码");
        jp4.add(jlblA); jp4.add(jtf3); jp4.add(jb4);
        jp4.add(jlblB); jp4.add(jpf3); jp4.add(jlblC);
        jp4.add(jcb5); jp4.add(jcb6); jp4.add(jlblD);
		
		jtp1=new JTabbedPane();
		jtp1.add(jp2,"QQ号码");jtp1.add(jp3,"手机号码");jtp1.add(jp4,"电子邮箱");
		this.add(jtp1);
		
		
		
		jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jb2=new JButton(new ImageIcon("images/zhuce.gif"));
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jp1=new JPanel();
		jp1.add(jb1);jp1.add(jb2);jp1.add(jb3);
		this.add(jp1,"South");
		
		this.setSize(350,240);
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	     {
		ClientLogin clientLogin=new ClientLogin();
	}

}

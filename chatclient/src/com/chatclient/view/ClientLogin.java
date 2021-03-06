package com.chatclient.view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClientLogin extends JFrame implements ActionListener
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
        //��һ�����
		jlbl2=new JLabel("QQ����",JLabel.CENTER);jlbl3=new JLabel("QQ����",JLabel.CENTER);
		jlbl4=new JLabel("��������",JLabel.CENTER);
		jlbl4.setForeground(Color.blue);
		jlbl5=new JLabel("�������뱣��",JLabel.CENTER);
		jtf1=new JTextField();
		jpf1=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb1=new JCheckBox("������¼");jcb2=new JCheckBox("��ס����");
        jp2.add(jlbl2); jp2.add(jtf1); jp2.add(jb4);
        jp2.add(jlbl3); jp2.add(jpf1); jp2.add(jlbl4);
        jp2.add(jcb1); jp2.add(jcb2); jp2.add(jlbl5);
        
        jtp1=new JTabbedPane();
        jtp1.add(jp2,"QQ����");jtp1.add(jp3,"�ֻ�����");jtp1.add(jp4,"��������");
        this.add(jtp1);              
        //�ڶ������
		jp3=new JPanel(new GridLayout(3,3));
		jlbl6=new JLabel("�ֻ�����",JLabel.CENTER);jlbl7=new JLabel("�ֻ���֤����",JLabel.CENTER);
		jlbl8=new JLabel("û�յ�����",JLabel.CENTER);
		jlbl8.setForeground(Color.blue);
		jlbl9=new JLabel("�������뱣��",JLabel.CENTER);
		jtf2=new JTextField();
		jpf2=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb3=new JCheckBox("������¼");jcb4=new JCheckBox("��ס����");
        jp3.add(jlbl6); jp3.add(jtf2); jp3.add(jb4);
        jp3.add(jlbl7); jp3.add(jpf2); jp3.add(jlbl8);
        jp3.add(jcb3); jp3.add(jcb4); jp3.add(jlbl9);
		//��3�����
        jp4=new JPanel(new GridLayout(3,3));
		jlblA=new JLabel("�����ַ",JLabel.CENTER);jlblB=new JLabel("��¼����",JLabel.CENTER);
		jlblC=new JLabel("���ǵ�ַ",JLabel.CENTER);
		jlblC.setForeground(Color.blue);
		jlblD=new JLabel("�������뱣��",JLabel.CENTER);
		jtf3=new JTextField();
		jpf3=new JPasswordField();
		jb4=new JButton(new ImageIcon("images/clear.gif"));
        jcb5=new JCheckBox("������¼");jcb6=new JCheckBox("��ס����");
        jp4.add(jlblA); jp4.add(jtf3); jp4.add(jb4);
        jp4.add(jlblB); jp4.add(jpf3); jp4.add(jlblC);
        jp4.add(jcb5); jp4.add(jcb6); jp4.add(jlblD);
		
		jtp1=new JTabbedPane();
		
		jtp1.add(jp2,"QQ����");jtp1.add(jp3,"�ֻ�����");jtp1.add(jp4,"��������");
		this.add(jtp1);
		
		
		
		jb1=new JButton(new ImageIcon("images/denglu.gif"));
		jb1.addActionListener(this);
		jb2=new JButton(new ImageIcon("images/zhuce.gif"));
		jb3=new JButton(new ImageIcon("images/quxiao.gif"));
		jp1=new JPanel();
		jp1.add(jb1);jp1.add(jb2);jp1.add(jb3);
		this.add(jp1,"South");
		
		
		
		this.setSize(350,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	     {
		ClientLogin clientLogin=new ClientLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			String userName =jtf1.getText();
			new FriendList(userName);
		    this.dispose();
		}
	}

}

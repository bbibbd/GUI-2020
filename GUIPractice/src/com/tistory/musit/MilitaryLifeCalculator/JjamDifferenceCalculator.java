package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class JjamDifferenceCalculator extends JFrame{

	
	public JjamDifferenceCalculator(String title, int x, int y, int sizeX, int sizeY) {	//constructor�� ���� (frame�̸�, xy��ǥ, ũ��)
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
	}

	public void calculateJjamDifference() {
		DataSettingFrame user1 = new DataSettingFrame();
		DataSettingFrame user2 = new DataSettingFrame();
		user1.setTitleBorder("User 1");
		user1.setData();
		user2.setTitleBorder("User 2");
		user2.setData();
		
		add(user1.getDataInputPanel(),BorderLayout.NORTH);
		add(user2.getDataInputPanel(),BorderLayout.CENTER);
		JButton calculateBtn = new JButton("���");
		add(calculateBtn,BorderLayout.SOUTH);
		
		calculateBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�������� �̿ϼ���.. ���� ����","???",3);
			}
		});
		
	}
	
}

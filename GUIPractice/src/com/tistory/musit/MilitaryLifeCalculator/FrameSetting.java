package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class FrameSetting extends JFrame {
	
	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
	}


	public void setButton () {
		JPanel buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);
		buttonPanel.add(new JButton("���"));
		buttonPanel.add(new JButton("�ʱ�ȭ"));
		buttonPanel.add(new JButton("txt���Ϸ� ����"));
		buttonPanel.setLayout(fl);
		//buttonPanel.setPreferredSize(new Dimension( 320, 120));
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);
	}
	
	public void setDate() {

		 GridLayout g = new GridLayout(0,1,5,5);
		 StartEndInputPanel textField = new StartEndInputPanel(g);
		 
		JTextField inputStartDate = new JTextField("�Դ����� �Է����ֽʽÿ�");
		JTextField inputEndDate = new JTextField("�������� �Է����ֽʽÿ�");
		textField.add(inputStartDate);
		textField.add(inputEndDate);
		add(textField,BorderLayout.NORTH);	
	}
	
	public void showResult() {
		ResultPanel resultP = new ResultPanel();
		JLabel textArea = new JLabel();
		textArea.setPreferredSize(new Dimension( 0, 700));
		resultP.add(textArea,BorderLayout.CENTER);
		

		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW),"���"));
		add(resultP,BorderLayout.CENTER);

	}
}

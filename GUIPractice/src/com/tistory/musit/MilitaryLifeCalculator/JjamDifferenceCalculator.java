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
		    	String user1Name = user1.getNameField().getText();	String user2Name = user2.getNameField().getText();
		    	int startYear1 = user1.getSty(), startMonth1 = user1.getStm(), startDate1 = user1.getStd(), endYear1 = user1.getEdy(), endMonth1 = user1.getEdm(), endDate1 = user1.getEdd();
		    	int startYear2 = user2.getSty(), startMonth2 = user2.getStm(), startDate2 = user2.getStd(), endYear2 = user2.getEdy(), endMonth2 = user2.getEdm(), endDate2 = user2.getEdd();
		    	
		    	if(user1.getNameField().getText().equals("123")) {
		    		user1Name = "����";
		    		startYear1 = 2019;	startMonth1 = 4;	startDate1 = 1;
		    		endYear1 = 2020;	endMonth1 = 11;	endDate1 = 2;
		    	}
		    	if(user2.getNameField().getText().equals("123")) {
		    		user2Name = "����";
		    		startYear2 = 2019;	startMonth2 = 4;	startDate2 = 1;
		    		endYear2 = 2020;	endMonth2 = 11;	endDate2 = 2;
		    	}
		    	
		    	if(user1.getNameField().getText().equals("1234")) {
		    		user1Name = "���� ��������";
		    		startYear1 = 2019;	startMonth1 = 4;	startDate1 = 1;
		    		endYear1 = 2020;	endMonth1 = 10;	endDate1 = 11;
		    	}
		    	if(user2.getNameField().getText().equals("1234")) {
		    		user2Name = "���� ��������";
		    		startYear2 = 2019;	startMonth2 = 4;	startDate2 = 1;
		    		endYear2 = 2020;	endMonth2 = 10;	endDate2 = 11;
		    	}
		
		
		    	Run gibeom = new Run(user1Name,startYear1, startMonth1, startDate1, endYear1,endMonth1,endDate1);
		    	Run cheeun = new Run(user2Name,startYear2, startMonth2, startDate2, endYear2,endMonth2,endDate2);
		    	gibeom.calculating();
		    	cheeun.calculating();
		    	
		        int differenceDays = Math.abs(gibeom.getRemainDays()-cheeun.getRemainDays());
		        double differencePercentage = Math.abs(cheeun.getPercentage()-gibeom.getPercentage());

		        String name1 = user1Name;
		        String name2 = user2Name;
		        String tmp;
		        
		        if(gibeom.getRemainDays() < cheeun.getRemainDays()) {
		        	tmp = name1;
		        	name1 = name2;
		        	name2 = tmp;
		        }
		        else	;
		        
		        String result = String.format("%s�԰� %s���� « ����: \n%s���� %s�Ժ��� %d�� �� ���������� \n%.4f%%��ŭ ���̰� ���ϴ�. ",gibeom.getName(), cheeun.getName(),name1, name2, differenceDays,differencePercentage);
		        String title;
		        if(differenceDays==0) 	title = String.format("%s���� �췯�� �� ���� ���� %s��",name2, name1);
		        else if(differenceDays<8)	title = "���� �� ���� �ȳ�";
		        else if(differenceDays<25)	title = "���� ���� �� ���� ��";
		        else if(differenceDays<60)	title = "�����ӱ��� ����";
		        else if(differenceDays<90)	title =	String.format("%s���� �뼱�ӱ�",name2);
		        else if(differenceDays<180)	title = String.format("%s���� �췯�� �� ���� ���� %s��",name2, name1);
		        else	title = String.format("%s���� �췯�� �� ���� ���� %s��",name2, name1);
		        JOptionPane.showMessageDialog(null, result,title,3);

		    }
		});
		

	}
	
}
package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {		

	private static final long serialVersionUID = 1L;
	JTextArea textArea = new JTextArea(5,20);	//	resultP�ȿ� ���� TextArea�� ������ ���� ����� ����� �� �ְ� ��.
	
	int startYear, startMonth, startDate,  endYear, endMonth, endDate;	//������� �Դ��, �Դ��, �Դ���, ������, ������, �������� ������ ����
	String userName = "";
	
	DataSettingFrame ds = new DataSettingFrame();
	MenuBarFrame mf = new MenuBarFrame();
	
	public MainFrame(String title, int x, int y, int sizeX, int sizeY) {	//constructor�� ���� (frame�̸�, xy��ǥ, ũ��)
		super(title);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
		textArea.setFont(new Font("���",Font.TRUETYPE_FONT,17));
		textArea.setEditable(false);
	}
	
	//�޴��ٸ� �����ϴ� method
	public void setMenuBar() {
		mf.setMenuBar();
		setJMenuBar(mf.getMb());
	}

	//�Դ���, ������, �̸��� �Է��ϱ����� Panel�� �����ϴ� method
	public void setDataPanel() {	
		ds.setData();
		add(ds.getDataInputPanel(),BorderLayout.NORTH);	
		ds.getDataInputPanel().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));
	}

	//����� �����ִ� Panel
	public void setResultPanel() {
		ResultPanel resultP = new ResultPanel();	
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating �� �� 
		setVisible(true);
	}
	
	//�ϴ��� calculate, reset ��ư�� �������ִ� method
	public void setButtonPanel() {		
		JPanel buttonPanel = new JPanel();	//��ư 3���� ���� Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//��������ϱ� ���� FlowLayout�� ����
		JButton calculateBtn = new JButton("���");	//����ϴ� ��ư ����
		buttonPanel.add(calculateBtn);		//��ư�гο� ����ư �߰�

		//��� ��ư Ŭ�� ���� �̺�Ʈ
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				
				startYear = ds.getSty();	startMonth = ds.getStm(); startDate = ds.getStd();
				userName = ds.getNameField().getText();
				
				EndCalculator ec = new EndCalculator(startYear, startMonth, startDate);
				endYear = ec.getEndYear();	endMonth = ec.getEndMonth();	endDate = ec.getEndDate();
				
				if(userName.equals("123")) {
					userName = " ����"; 	startYear=2019;	startMonth=4;	startDate=1;	setName(userName);
				}
				
						
				String confirmMes = String.format("�̸�: %s \n�Դ���: %d�� %d�� %d��\n������: %d�� %d�� %d��\n�����ʴϱ�?", userName,startYear,startMonth,startDate,endYear,endMonth,endDate);
				
				int answer = JOptionPane.showConfirmDialog(null,confirmMes, "confirm",JOptionPane.YES_NO_OPTION );
				if(answer ==JOptionPane.YES_OPTION) {
					if(userName.equals("����"))
						JOptionPane.showMessageDialog(null, "õ�� ���α׷��� ������.!","???",3);
					if(userName.equals("������")) 
						JOptionPane.showMessageDialog(null, "1�Ҵ� ���̽� ��������, ȯ���մϴ�.","???",3);
					if(userName.equals("������")) 
						JOptionPane.showMessageDialog(null, "�������� ���ƾ� �����۾��Ϸ�����¡","???",3);
					if(userName.equals("����")||userName.equals("�� ��")) 
						JOptionPane.showMessageDialog(null, "���� �� �����ϴ� ����!!ȯ��","???",3);
					
					mf.setName(userName);
					Run gibeom = new Run(userName, startYear,  startMonth, startDate, endYear, endMonth, endDate);	//�̸��� �Դ���, �������� �� �����ؼ� Initiating��
					try {
						gibeom.calculating();
						mf.setTx(gibeom.getFinalResult().toString());
						textArea.setText(mf.getTx());
					}	catch (DateTimeException er) {
						String errMessage = "��¥�� �߸��Է��Ͻŵ��ϳ׿�. \n�ٽ��Է����ֽñ� �ٶ��ϴ�.";
						textArea.setText(errMessage);
					}
				}
			}
		});

		JButton resetBtn = new JButton("�ʱ�ȭ");	//reset��ư initiating
		buttonPanel.add(resetBtn);	//��ư��ο� reset��ư �߰�

		//�ʱ�ȭ ��ư Ŭ�� ���� �̺�Ʈ
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");	//����� �� string�� ����ϰ� ��
			}
		});
		
		JButton exitButton = new JButton("«���� ����");	//text���Ϸ� �����ϴ� ��ư
		buttonPanel.add(exitButton);	
		//���� ��ư Ŭ�� �� �̺�Ʈ
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JjamDifferenceCalculator jdc = new JjamDifferenceCalculator("«���� ����", 760, 400, 400,330);
				jdc.calculateJjamDifference();
				jdc.setVisible(true);
			
			}

		});

		buttonPanel.setLayout(fl);	//buttonPanel�� FlowLayout CENTER�� ����
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);
	}

}
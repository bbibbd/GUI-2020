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
	String tx = "Empty,,,";
	JTextArea textArea = new JTextArea(5,20);	//	resultP�ȿ� ���� TextArea�� ������ ���� ����� ����� �� �ְ� ��.

	
	int sty, stm, std,  edy, edm, edd;	//������� �Դ��, �Դ��, �Դ���, ������, ������, �������� ������ ����
	String name;
	
	DataSettingFrame ds = new DataSettingFrame();
	
	public MainFrame(String title, int x, int y, int sizeX, int sizeY) {	//constructor�� ���� (frame�̸�, xy��ǥ, ũ��)
		super(title);
		JOptionPane.showMessageDialog(null, "����� ����Ȱ�� �ñ��ϽŰ���?","???",3);
		JOptionPane.showMessageDialog(null, "�� ���̽��ϴ�. ����� ����Ȱ�� �����մϴ�!!!","???",2);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);
		textArea.setEditable(false);
	}
	
	public void setDate() {
		sty = ds.getSty();	stm = ds.getStm(); std = ds.getStd();
		edy = ds.getEdy(); edm = ds.getEdm();	edd = ds.getEdd();
		name = ds.getNameField().getText();
	}

	public void showResult(StringBuilder str) {
		textArea.setText(str.toString());
		textArea.setEditable(false);
		textArea.setFont(new Font("���",Font.TRUETYPE_FONT,17));
	}

	public void setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mFile, mHelp;
		JMenuItem  exportToTxtFile, aboutProgram, howToUse;

		mFile = new JMenu("����");	exportToTxtFile = new JMenuItem("��� ����");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("����");
		mFile.add(exportToTxtFile);		
		mHelp.add(howToUse);	mHelp.add(aboutProgram);	
		menuBar.add(mFile); 
		menuBar.add(mHelp);	

		//export to txt file
		exportToTxtFile.addActionListener(new ActionListener() {	//txt���Ϸ� �������� 
			public void actionPerformed(ActionEvent e) {
				try
				{
					SimpleDateFormat format1 = new SimpleDateFormat ( "yy��MM��dd�� EEE����");
					String today= format1.format (System.currentTimeMillis());
					String fileName = String.format("%s���� ����Ȱ(%s).txt",name,today);	//�����̸�
					FileWriter fw = new FileWriter(fileName,false); 
					BufferedWriter bw = new BufferedWriter(fw);
					String str = tx;
					bw.write(str);
					bw.newLine(); // �ٹٲ�
					bw.close();
					JOptionPane.showMessageDialog(null, String.format("%s�� ����Ǿ����ϴ�.",fileName),"saved",1);
				}
				catch (IOException er)
				{
					System.err.println(er); // ������ �ִٸ� �޽��� ���
					System.exit(1);
				}
			}
		});

		//about...�� Ŭ����
		aboutProgram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String about = "Maker: Bluemini \nContact: bbibbochaa74@gmail.com\nVersion: 2020-09 (3.1.1)\r\n" + 
						"This program tells you about your military life. \nThere is no copyright. You can use it as you want and share it.\n\n���� 2020�� 11�� 2�Ͽ� �����մϴ�. ��������\t";
				JOptionPane.showMessageDialog(null, about,"about",1);
			}
		});

		//���� Ŭ����
		howToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String howToUse = "1. �Դ��ϰ� �������� �����Ͽ� �Է��մϴ�.\n2. �̸��� �Է��մϴ�.\n3. �ϴ��� ����ư�� Ŭ���մϴ�.\n4. �׷��� �߾ӿ� ����� ��Ÿ�� ���Դϴ�.\n\n*�ʱ�ȭ��ư�� ������ ���â�� ��� �� �ֽ��ϴ�.";
				JOptionPane.showMessageDialog(null, howToUse,"����",1);
			}
		});
	}

	//�Դ���, ������, �̸��� �Է��ϱ����� Panel
	public void setData() {	
		ds.setData();
		add(ds.getDataInputPanel(),BorderLayout.NORTH);	
		ds.getDataInputPanel().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));
	}

	//����� �����ִ� method
	public void setResult() {
		ResultPanel resultP = new ResultPanel();	
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating �� �� 
		setVisible(true);
	}
	//�ϴ��� calculate, reset ��ư�� �������ִ� method
	public void setButton () {		
		JPanel buttonPanel = new JPanel();	//��ư 3���� ���� Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//��������ϱ� ���� FlowLayout�� ����
		JButton calculateBtn = new JButton("���");	//����ϴ� ��ư ����
		buttonPanel.add(calculateBtn);		//��ư�гο� ����ư �߰�

		//��� ��ư Ŭ�� ���� �̺�Ʈ
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.printf("%s/ %d %d %d\n", name, sty, stm, std);
				
				if(name.equals("123")) {
					name = " ����"; 	sty=2019;	stm=4;	std=1;	edy=2020;	edm=11;	edd=2;	setName(name);
				}
				String confirmMes = String.format("�̸�: %s \n�Դ���: %d�� %d�� %d��\n������: %d�� %d�� %d��\n�����ʴϱ�?", name,sty,stm,std,edy,edm,edd);
				
				int answer = JOptionPane.showConfirmDialog(null,confirmMes, "confirm",JOptionPane.YES_NO_OPTION );
				if(answer ==JOptionPane.YES_OPTION) {
					if(name.equals("����"))
						JOptionPane.showMessageDialog(null, "õ�� ���α׷��� ������.!","???",3);
					if(name.equals("������")) 
						JOptionPane.showMessageDialog(null, "1�Ҵ� ���̽� ��������, ȯ���մϴ�.","???",3);
					if(name.equals("������")) 
						JOptionPane.showMessageDialog(null, "�������� ���ƾ� �����۾��Ϸ�����¡","???",3);
					if(name.equals("����")||name.equals("�� ��")) 
						JOptionPane.showMessageDialog(null, "���� �� �����ϴ� ����!!ȯ��","???",3);

					Run gibeom = new Run(name, sty,  stm, std, edy,edm, edd);	//�̸��� �Դ���, �������� �� �����ؼ� Initiating��
					try {
						gibeom.calculating();
						tx = gibeom.getFinalResult().toString();
						showResult(gibeom.getFinalResult());		//StringBuilder������ ����� �����ͼ� textArea�� ���
					}	catch (DateTimeException er) {
						String errMessage = "��¥�� �߸��Է��Ͻŵ��ϳ׿�. \n�ٽ��Է����ֽñ� �ٶ��ϴ�.";
						showResult(new StringBuilder(errMessage));
					}
				}
				
			}
		});

		JButton resetBtn = new JButton("�ʱ�ȭ");	//reset��ư initiating
		buttonPanel.add(resetBtn);	//��ư��ο� reset��ư �߰�

		//�ʱ�ȭ ��ư Ŭ�� ���� �̺�Ʈ
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showResult(new StringBuilder(""));	//����� �� string�� ����ϰ� ��
				tx = "empty,,, ";
			}
		});

		JButton exitButton = new JButton("«���� ����");	//text���Ϸ� �����ϴ� ��ư
		buttonPanel.add(exitButton);	
		//���� ��ư Ŭ�� �� �̺�Ʈ
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}

		});

		buttonPanel.setLayout(fl);	//buttonPanel�� FlowLayout CENTER�� ����
		buttonPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(buttonPanel,BorderLayout.SOUTH);

	}


	public int getSty() {
		return sty;
	}

	public void setSty(int sty) {
		this.sty = sty;
	}

	public int getStm() {
		return stm;
	}

	public void setStm(int stm) {
		this.stm = stm;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getEdy() {
		return edy;
	}

	public void setEdy(int edy) {
		this.edy = edy;
	}

	public int getEdm() {
		return edm;
	}

	public void setEdm(int edm) {
		this.edm = edm;
	}

	public int getEdd() {
		return edd;
	}

	public void setEdd(int edd) {
		this.edd = edd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
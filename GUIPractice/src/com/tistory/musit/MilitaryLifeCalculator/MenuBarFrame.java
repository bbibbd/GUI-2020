package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBarFrame extends JFrame {
	
	JMenuBar mb = new JMenuBar();
	String tx = "empty,,,";
	String name = "";

	public void setMenuBar() {

		JMenu mFile, mHelp;
		JMenuItem  exportToTxtFile, aboutProgram, howToUse;

		mFile = new JMenu("����");	exportToTxtFile = new JMenuItem("��� ����");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("����");
		mFile.add(exportToTxtFile);		
		mHelp.add(howToUse);	mHelp.add(aboutProgram);	
		mb.add(mFile); 
		mb.add(mHelp);	

		//export to txt file
		SimpleDateFormat format1 = new SimpleDateFormat ( "yy��MM��dd�� EEE����");
		String today= format1.format (System.currentTimeMillis());
		
		exportToTxtFile.addActionListener(new ActionListener() {	//txt���Ϸ� �������� 
			public void actionPerformed(ActionEvent e) {
				try
				{
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
	
	public JMenuBar getMb() {
		return mb;
	}
	
	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public void setName(String name) {
		this.name = name;
	}

}

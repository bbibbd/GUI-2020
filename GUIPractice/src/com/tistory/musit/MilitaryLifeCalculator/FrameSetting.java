package com.tistory.musit.MilitaryLifeCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import au.com.bytecode.opencsv.*;





public class FrameSetting extends JFrame {		/**
 * 
 */
	private static final long serialVersionUID = 1L;
	String tx = "Empty,,,";

	JTextField nameField = new JTextField("",14);	//�̸� �Է��� ���� TextField�� ����
	JTextArea textArea = new JTextArea(5,20);	//	resultP�ȿ� ���� TextArea�� ������ ���� ����� ����� �� �ְ� ��.
	//���� ����� Txt���Ϸ� �����ϱ����� ����, reset��ư�� calculate��ư�� ������ �� ����ؾ��ϱ⶧����

	int sty, stm, std,  edy, edm, edd;	//������� �Դ��, �Դ��, �Դ���, ������, ������, �������� ������ ����
	@SuppressWarnings("unused")
	private String name;	//textField�� �Էµ� �̸����� �����ϱ�����  ����


	HashMap<String, String> userInfo = new HashMap<>();

	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {	//constructor�� ���� (frame�̸�, xy��ǥ, ũ��)
		
		super(title);
		JOptionPane.showMessageDialog(null, "����� ����Ȱ�� �ñ��ϽŰ���?","???",3);
		JOptionPane.showMessageDialog(null, "�� ���̽��ϴ�. ����� ����Ȱ�� �����մϴ�!!!","???",2);
		setLocation(x,y);
		setSize(sizeX,sizeY);
		setResizable(false);
		setVisible(true);



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
		JMenuItem saveUser, loadUser, exportToTxtFile, aboutProgram, howToUse;

		mFile = new JMenu("����");	exportToTxtFile = new JMenuItem("��� ����");	
		mHelp = new JMenu("Help");	aboutProgram = new JMenuItem("About...");	howToUse = new JMenuItem("����");


		mFile.add(exportToTxtFile);		
		mHelp.add(howToUse);	mHelp.add(aboutProgram);	
		menuBar.add(mFile); 
		menuBar.add(mHelp);	

		

		//export to txt file
		//TODO �������ϸ��� ��¥+�̸�
		exportToTxtFile.addActionListener(new ActionListener() {	//txt���Ϸ� �������� 
			public void actionPerformed(ActionEvent e) {

				try
				{
					StringBuilder fileName = null ;
					
					
					FileWriter fw = new FileWriter("fileName",false); // �����ּ� ��� ����
					BufferedWriter bw = new BufferedWriter(fw);
					String str = tx;

					bw.write(str);
					bw.newLine(); // �ٹٲ�

					bw.close();
					JOptionPane.showMessageDialog(null, "result.txt ���Ϸ� ����Ǿ����ϴ�.","save",1);
				}
				catch (IOException er)
				{
					System.err.println(er); // ������ �ִٸ� �޽��� ���
					System.exit(1);
				}


			}


		});


		aboutProgram.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String about = "Maker: Bluemini \nContact: bbibbochaa74@gmail.com\nVersion: 2020-09 (3.1.1)\r\n" + 
						"Build id: 20200806-1200\nThis program tells you about your military life. \nThere is no copyright. You can use it as you want and share it.\n\n���� 2020�� 11�� 2�Ͽ� �����մϴ�. ��������\t";
				JOptionPane.showMessageDialog(null, about,"about",1);
			}
		});

		howToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String howToUse = "1. �Դ��ϰ� �������� �����Ͽ� �Է��մϴ�.\n2. �̸��� �Է��մϴ�.\n3. �ϴ��� ����ư�� Ŭ���մϴ�.\n4. �׷��� �߾ӿ� ����� ��Ÿ�� ���Դϴ�.\n\n*�ʱ�ȭ��ư�� ������ ���â�� ��� �� �ֽ��ϴ�.";
				JOptionPane.showMessageDialog(null, howToUse,"����",1);
			}
		});
	}


	@SuppressWarnings("unchecked")
	public void setDate() {	//�Դ���, ������, �̸��� �Է��ϱ����� Panel

		GridLayout g = new GridLayout(3,4,2,2);
		StartEndInputPanel textField = new StartEndInputPanel(g);

		JPanel startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"Start"�� JComboBox 3��(��, ��, ��)�� �ִ� panel
		JPanel endPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//"End"��  JComboBox 3��(��, ��, ��)�� �ִ� panel
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));	//name�� textField�� �ִ� panel

		JLabel startLabel = new JLabel("�Դ���");
		JLabel endLabel = new JLabel("������");
		JLabel nameLabel = new JLabel("�̸� ");

		this.name = nameField.getText();
		// TODO JComboBox�� �⺻���� ���ڰ� �ƴ� �⵵, ��, �� �̷������� �����
		//�Դ�⵵, ��, ���� LIST�� ����� JComboBox�� �����
		String [] startYear = {"2018", "2019", "2020", "2021", "2022", "2023"};
		String [] startMonth = { "1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] startDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		//�����⵵, ��, ���� LIST�� ����� JComboBox�� �����
		String [] endYear =  { "2019", "2020", "2021", "2022", "2023","2024","2025"};
		String [] endMonth = {"1","2","3","4","5","6","7","8","9","10","11","12"};		
		String  [] endDay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

		JComboBox <String> sty = new JComboBox<String>(startYear);
		JComboBox <String> stm = new JComboBox<String>(startMonth);
		JComboBox <String> std = new JComboBox<String>(startDay);
		JScrollPane psty = new JScrollPane(sty);
		JScrollPane pstm = new JScrollPane(stm);
		JScrollPane pstd = new JScrollPane(std);

		this.sty = Integer.parseInt(sty.getSelectedItem().toString());	//Integer�� �����ϱ� ���� ��ȯ������ ��ħ.
		this.stm = Integer.parseInt(stm.getSelectedItem().toString());
		this.std =  Integer.parseInt(std.getSelectedItem().toString());

		//���� combobox�� �Էµ� ���� sty, sym, syd, edy, edm, edd�� ������
		sty.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setSty(Integer.parseInt(str));

				}
			}
		});

		stm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStm(Integer.parseInt(str));

				}
			}
		});

		std.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setStd(Integer.parseInt(str));

				}
			}
		});


		JComboBox<String> edy = new JComboBox<String>(endYear);
		JComboBox<String> edm = new JComboBox<String>(endMonth);
		JComboBox<String> edd = new JComboBox<String>(endDay);
		JScrollPane pedy = new JScrollPane(edy);
		JScrollPane pedm = new JScrollPane(edm);
		JScrollPane pedd = new JScrollPane(edd);

		this.edy = Integer.parseInt(edy.getSelectedItem().toString());
		this.edm = Integer.parseInt(edm.getSelectedItem().toString());
		this.edd =  Integer.parseInt(edd.getSelectedItem().toString());

		edy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdy(Integer.parseInt(str));

				}
			}
		});


		edm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdm(Integer.parseInt(str));

				}
			}
		});

		edd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange() == ItemEvent.SELECTED){
					JComboBox<String> jbox = (JComboBox<String>)ev.getItemSelectable();
					String str = jbox.getSelectedItem().toString();
					setEdd(Integer.parseInt(str));

				}
			}
		});

		startPanel.add(startLabel); 
		startPanel.add(psty);	startPanel.add(pstm); startPanel.add(pstd);
		endPanel.add(endLabel); 
		endPanel.add(pedy); endPanel.add(pedm); endPanel.add(pedd);
		namePanel.add(nameLabel); namePanel.add(nameField);

		textField.add(startPanel);
		textField.add(endPanel);
		textField.add(namePanel);
		add(textField,BorderLayout.NORTH);	

		textField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Data"));


	}

	public void setResult() {
		ResultPanel resultP = new ResultPanel();	//����� �����ִ�Panel�ε�, size�� �������ϱ����ؼ� ResultPanel extends JPanel�� ���� overRide�ؼ� �ҷ���
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		p.setPreferredSize(new Dimension(360,390));
		resultP.add(p,BorderLayout.CENTER);
		resultP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Result"));
		add(resultP,BorderLayout.CENTER);	//initiating �� �� 
		setVisible(true);

	}


	public void setButton () {		//�ϴ��� calculate, reset ��ư�� �������ִ� method

		JPanel buttonPanel = new JPanel();	//��ư 3���� ���� Panel
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 7, 7);	//��������ϱ� ���� FlowLayout�� ����

		JButton calculateBtn = new JButton("���");	//����ϴ� ��ư ����
		buttonPanel.add(calculateBtn);		//��ư�гο� ����ư �߰�

		//��� ��ư Ŭ�� ���� �̺�Ʈ
		calculateBtn.addActionListener( new ActionListener(){		
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();	//nameField�� �Էµ� �̸����� �ҷ�����
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
		});

		JButton resetBtn = new JButton("�ʱ�ȭ");	//reset��ư initiating
		buttonPanel.add(resetBtn);	//��ư��ο� reset��ư �߰�

		//reset��ư Ŭ�� ���� �̺�Ʈ
		resetBtn.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showResult(new StringBuilder(""));	//����� �� string�� ����ϰ� ��
				tx = "empty,,, ";
			}
		});

		JButton exitButton = new JButton("����");	//text���Ϸ� �����ϴ� ��ư
		buttonPanel.add(exitButton);	

		//Save as txt��ư Ŭ�� �� �̺�Ʈ
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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


}
package com.musit.tistory.GUIP;

import java.awt.BorderLayout;		//��ü �������� ��, ��, ��, ��, �߾� 5�κ����� ����� ���. �⺻ �������� �� ���̾ƿ��� ���
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/*
 JFrame�� ��ӹ޴� FrameŬ������ �����.
 �׷� �� Constructor�� �������ִµ� Factor�� ���� String title, int x, int y, int sixeX, int sizeY)
 title�� ������ ����, int x�� int y�� ���� �� �������� ��ǥ, int sizeX, sizeY�� ���ο� ���� ������						 
*/

public class FrameSetting extends JFrame {

	public FrameSetting(String title, int x, int y, int sizeX, int sizeY) {
		super(title);
		setLocation(x,y);
		setSize(sizeX, sizeY);
	}

	
	/*
	 JButton����ؼ� ��ư�����
	 1. JButton (��ư�̸�) = new JButton(String) --> ��ư�̸����� initiating�� �� ������, String�� ��ư�� �� ���ڸ� ����.
	 2. add(��ư�̸�, ��ġ) --> ��ġ�� BorderLayout�� �̿��Ͽ� ����(���� JLabel�̳� �ٸ� panel�� BorderLayout�̶� ��ġ�� Main���� ���߿� �ҷ��� ���� �켱���� ������
	 */
	public void setButton() {	//��ư�� ����� ���� method

		JButton east = new JButton("E");	//���ʿ� ��ġ�ϴ� ��ư
		JButton west = new JButton("W");//���ʿ� ��ġ�ϴ� ��ư
		JButton center = new JButton("C");//�߾ӿ� ��ġ�ϴ� ��ư
		
		add(east,BorderLayout.EAST);	//add(��ư, ��ġ)
		add(west,BorderLayout.WEST);
		add(center,BorderLayout.CENTER);
	}
	
	/*
	 * �޴��� ����� Method. JMenuBar�� �̿��Ͽ� ���� ���� �� ����
	 */
	public void setMenuBar() {		
		JMenuBar menuBar = new JMenuBar();	//menuBar�� initiating
		JMenu mFile, mEdit, mHelp;	//�޴��ٿ� ���� ���� ����

		mFile = new JMenu("File");	 //������ ���� initiating�ϴµ�, string�� �޴� �׸��� ����, ������ �����Ű�� �޴��ٿ� �� string�� ���.
		mEdit = new JMenu("Edit");
		mHelp = new JMenu("Help");
		setJMenuBar(menuBar);	//�̰� ���� �𸣰����� �ؾ���.. �Ƹ� �����ӿ� �޴��ٸ� add�ϴ°� �ƴұ�...

		menuBar.add(mFile);	//�޴��ٿ� JMenu�� �߰��ϴ� ����
		menuBar.add(mEdit);
		menuBar.add(mHelp);

	}
	
	/*
	 * �̰� ���ž���,,,�׳� �� ���̵� �ؽ�Ʈ�� �ٿ����� �� ���
	 * BorderLayout�� �̿��Ͽ� ��ġ ����
	 */
	public void setJLabel() {

		JLabel label = new JLabel("Love You!");
		add(label,BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);	//���� ���������� ��ġ�� ���ϴ� method.

	}

	/*
	 * �� �״��  CheckBox�� ����� ��(�ϳ���)
	 */
	public void setJCheckBox() {
		JCheckBox box1 = new JCheckBox("Lee Cheeun");
		box1.setSelected(true);
		//box1.isSelected()	���õǾ���? return true, �ƴϴ�? return false
		add(box1, BorderLayout.SOUTH);
		box1.setHorizontalAlignment(JCheckBox.CENTER);

	}

	/*
	 * ���� ���ϻ� �� �׷���, �ƴϴ�, �𸣰ڴٿ� ���� CheckBox�� 2�� �̻� �� �ϳ��� �����ؾ��� �� ����.
	 */
	public void setJRadioButton() {	//CheckBox�� ������ ���� �ϳ��� �����ϰ� �Ҷ� ���� method
		JRadioButton r1 = new JRadioButton("yes");
		JRadioButton r2 = new JRadioButton("no");
		JRadioButton r3 = new JRadioButton("think");

		ButtonGroup g = new ButtonGroup();	//�׷��� ����� 3�� �� �ϳ��� �����ϵ��� ��
		g.add(r1);		g.add(r2);		g.add(r3);

		add(r1, BorderLayout.NORTH);
		add(r2, BorderLayout.SOUTH);
		add(r3, BorderLayout.CENTER);

		r1.setHorizontalAlignment(JRadioButton.CENTER);
		r2.setHorizontalAlignment(JRadioButton.CENTER);
		r3.setHorizontalAlignment(JRadioButton.CENTER);
	}

	/*
	 * �޺��ڽ��� ������ ����Ʈ�� �߰� �ϴ°�...(�����ϱ� ����� ���� �غ���)
	 */
	public void setJComboBox() {
		String [] love = {"Kim Gibeom","Choi Kwunseok","Hong Saehyeon","Jealous Guy"}; 

		JComboBox cb = new JComboBox(love);	//�����ڴ� JComboBox(String [])
		add(cb, BorderLayout.SOUTH);
		cb.setSelectedIndex(0);	//�⺻������ � ���� ������ ���ΰ�. index���̶� 0�̸� ���, 1�̸� �Ǽ�, 2�̸� ������ �ȴ�.
	}

	/*
	 * �޺��ڽ��� ������ �Ʒ��� ����Ʈ�� �ߴ°��̶��, JList�� ó������ ����Ʈ�� �����ְ� �� �� �ϳ� ������ �� �ְ� �Ѵ�.
	 */
	public void setJList() {
		String [] love = {"Kim Gibeom","Choi Kwunseok","Hong Saehyeon","Jealous Guy", "����", "�ֱǼ�", "ȫ����", "�� ����", "�� ��īƮ��", "���� �ظ���", "���� ��Ÿ"}; 

		JList list1 = new JList(love);
		JScrollPane p = new JScrollPane(list1);	//list�� ��ũ�Ѱ� ���ս�Ŵ

		add(p, BorderLayout.NORTH);	//���ս�Ų P�� add�� �ϸ� �ȴ�.
		list1.setSelectedIndex(0); 	//setSelectedIndices()�� ���������� �Ǿ�������, getter�� �Ȱ���
		list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION ); 	//����ڰ� ������ �� �ִ� ������ ������ �Ŵ� method,
		//���⼭�� ���� ������ �������� ���� �����ϰ� �� �� �ִ�...?
		//ListSelectionModel.SINGLE_SELECTION => �� ���� ������
		//ListSelectionModel.MULTIPLE_INTERVAL_SELECTION  => �⺻ ��, �����Ӱ� ���� ����
	}

	/*
	 * �ؽ�Ʈ�� �Է�â�� �����. ���̹� �˻�âó�� �� �ٷ� ���� �� ���
	 */
	public void setJTextField() {
		JTextField textField = new JTextField(20);	//ȭ�鿡 20�ڸ� ǥ�õ�, ���߿� Pannel���� ����� ��
		textField.setText("I love you");
		add(textField, BorderLayout.NORTH);
		//textField.setEditable(false);		//������ �Ұ����ϰ� �ϴ� method, �⺻���� True�̰�, ����� ��

	}		
	
	/*
	 * �ؽ�Ʈ�Է�â�ε�, �� �� �̻��� ������ �� ���
	 */
	public void setJTextArea()	{
		JTextArea textArea = new JTextArea(5,20);	//5��, 20���ڱ����� ǥ�õ�, ���߿� Pannel���� ����� ��		
		JScrollPane p = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		//textArea�� ��ũ�Ѱ� ���ս�Ŵ, ��ũ�ѿ��� ������ũ�ѹٴ� �׻� �߰� ������, ����ũ���� �ʿ��� �� ���� �ߴ�. 
		//����� ��� AS_NEEDED
		textArea.setText("John Lennon\nPaul McCartney\nGeorge Harrison\nRingo Strarr");
		add(p, BorderLayout.CENTER);

	}
	
	/*
	 * 
	 */
	public void  setContainer() {
		JLabel head = new JLabel("Enter your name");	//���� ����
		head.setHorizontalAlignment(JLabel.CENTER);
		add(head, BorderLayout.NORTH);	//������ ���ʿ� ��ġ

		JPanel pc = new JPanel();	//���ο� �г� pc�� ����
		JLabel name = new JLabel("Name: ");	//�� name��
		JTextField tf = new JTextField(20);	//�ؽ�Ʈ�ʵ� ft��

		pc.add(name);	pc.add(tf);	//�ǳ� pc�� ���� ��
		add(pc, BorderLayout.CENTER);	//�� �ǳ� pc�� �������� �߾ӿ� �ִ´�.

		JPanel ps = new JPanel();	
		JButton b1 = new JButton("confirm");
		JButton b2 = new JButton("reset");

		ps.add(b1);	ps.add(b2);
		add(ps, BorderLayout.SOUTH);
	}
	
	
	
}

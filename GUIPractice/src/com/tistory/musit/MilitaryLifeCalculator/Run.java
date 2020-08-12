package com.tistory.musit.MilitaryLifeCalculator;

import java.text.DecimalFormat;

class Run {
	private String name;
	PeriodCalculator calculator = new PeriodCalculator();
	private int betweenY = calculator.getBetweenYear();
	
	public int getBetweenYaer() {
		return betweenY;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	private int sy, sm, sd, ey, em, ed;

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getSm() {
		return sm;
	}

	public void setSm(int sm) {
		this.sm = sm;
	}

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		this.sd = sd;
	}

	public int getEy() {
		return ey;
	}

	public void setEy(int ey) {
		this.ey = ey;
	}

	public int getEm() {
		return em;
	}

	public void setEm(int em) {
		this.em = em;
	}

	public int getEd() {
		return ed;
	}

	public void setEd(int ed) {
		this.ed = ed;
	}

	public String getName(){
		return name;
	}
	


	public Run(String name, int sy, int sm, int sd, int ey, int em, int ed) {
		this.name = name;
		this.sy = sy;
		this.sm = sm;
		this.sd = sd;
		this.ey = ey;
		this.em = em;
		this.ed = ed;
	}


	StringBuilder  finalResult = new StringBuilder("");	//�� method�� ����� String���� �����ϱ����� StringBuilder�� �����

	public void calculating(){

		calculator.setStartYear(sy);
		calculator.setStartMonth(sm);
		calculator.setStartDate(sd);
		calculator.setEndYear(ey);
		calculator.setEndMonth(em);
		calculator.setEndDate(ed);
		calculator.calculatingPeriode();
		

		
		//����Ȱ�� 1�⵵ �ȵǴ� ���(��, �߸� �Է��� ���)
		if(calculator.getBetweenYear()==0) {
			finalResult.append(String.format("%s��..�߸��Է��ϽŰ� �����ϴ�.\n�ٽ� �Է��� �ֽñ�.....\n\n", name));
			return ;
		}
		//�̹� ������ ����� ���
		if(calculator.getRemainDays()<=0){
			finalResult.append(String.format("%s���� �̹� �����ϼ̽��ϴ�...\n�׷��� ����� �ñ�����..?.\n\n", name));
		}
		//���� �Դ����� ���� ����� ���
		if(calculator.getPastDays()<0) {
			finalResult.append(String.format("%s���� ���� �Դ뵵 ���� �����̳׿�...��\n�׷��� �ñ��Ͻôٸ��...\n\n", name));
		}
		//��ü ����Ȱ �� �ϼ�, ���� �ϼ�
		finalResult.append(String.format("- %s���� ��ü ����Ȱ: %d�� %d���� %d��\n(�� %d��) ��\n%d��(%.4f%%) �ϼ�����, \n%d�� �����̽��ϴ�.\n\n",
				name,calculator.getBetweenYear(), calculator.getBetweenMonth(), calculator.getBetweenDay(), calculator.getTotalDays(),
				calculator.getPastDays(), (double)calculator.getPercentage(),calculator.getRemainDays()));	
		
		//��ð����� ���߰�, �����ñ����� �󸶳� ��������
		int hours = 24*calculator.getPastDays();
		double workHours = calculator.getPastDays()*(5.0/7.0)*9;	//�����Ͽ� 5�ϵ��� �Ϸ翡 9�ð���
		double wage = workHours*8590;	//2020����� �����ñ� 8590��
		DecimalFormat df = new DecimalFormat("#,##0");
		double lol = hours*(2.0/3.0);
		int book = hours/6;
		finalResult.append(String.format("�� %s�ð�(�ϰ� %s�ð�)���� \n����Ȱ�� �ϼ����� ���� ��ȸ�� �־��ٸ� \n�����ñ����� %s�� ��Ұ�\n���� %s���� �� ������, \nå�� %s�� ������ �ְ�,\n����ģ���� 0�� ��� �� �ֽ��ϴ�.\n\n", df.format(hours),df.format(workHours),df.format(wage),df.format(lol),df.format(book)));

		//Ư�� �ۼ�Ʈ(10%, 20%, 25%, 30%, 33%, ..., 90%)���� ���� �ϼ�
		DayCalculator dayCalculator = new DayCalculator();
		finalResult.append(String.format("- �Ϸ翡 %.3f%%�� �����մϴ�. \n10%%������ %d�� (%s)\n20%%������ %d�� (%s)\n25%%������ %d�� (%s) \n30%%������ %d�� (%s)\n33%%������ %d�� (%s)\n40%%������ %d�� (%s)\n50%%������ %d�� (%s)\n60%%������ %d�� (%s)\n66%%������ %d�� (%s)\n70%%������ %d�� (%s)\n75%%������ %d�� (%s)\n80%%������ %d�� (%s)\n90%%������ %d�� (%s)\n���ҽ��ϴ�.\n"
				,calculator.dayPercentage()
				,calculator.remainPercentage(10) ,dayCalculator.addDays(calculator.remainPercentage(10))
				,calculator.remainPercentage(20) ,dayCalculator.addDays(calculator.remainPercentage(20))
				,calculator.remainPercentage(25) ,dayCalculator.addDays(calculator.remainPercentage(25))
				,calculator.remainPercentage(30) ,dayCalculator.addDays(calculator.remainPercentage(30))
				,calculator.remainPercentage(33) ,dayCalculator.addDays(calculator.remainPercentage(33))
				,calculator.remainPercentage(40) ,dayCalculator.addDays(calculator.remainPercentage(40))
				,calculator.remainPercentage(50) ,dayCalculator.addDays(calculator.remainPercentage(50))
				,calculator.remainPercentage(60) ,dayCalculator.addDays(calculator.remainPercentage(60))
				,calculator.remainPercentage(66) ,dayCalculator.addDays(calculator.remainPercentage(66))
				,calculator.remainPercentage(70) ,dayCalculator.addDays(calculator.remainPercentage(70))
				,calculator.remainPercentage(75) ,dayCalculator.addDays(calculator.remainPercentage(75))
				,calculator.remainPercentage(80) ,dayCalculator.addDays(calculator.remainPercentage(80))
				,calculator.remainPercentage(90) ,dayCalculator.addDays(calculator.remainPercentage(90))));


		//100��, 200�� ,,, 500�� ��������
		finalResult.append(String.format("\n- �Դ� D+ \n100���� %d�� (%s)\n200���� %d�� (%s)\n300���� %d�� (%s)\n400���� %d�� (%s)\n500���� %d�� (%s) \n�����̽��ϴ�.\n\n- ���� D-\n500���� %d�� (%s)\n400���� %d�� (%s)\n300���� %d�� (%s)\n200���� %d�� (%s)\n100���� %d�� (%s)\n�����̽��ϴ�.\n",
				calculator.pastHund(100), dayCalculator.addDays(calculator.pastHund(100)),
				calculator.pastHund(200), dayCalculator.addDays(calculator.pastHund(200)),
				calculator.pastHund(300), dayCalculator.addDays(calculator.pastHund(300)),
				calculator.pastHund(400), dayCalculator.addDays(calculator.pastHund(400)),
				calculator.pastHund(500), dayCalculator.addDays(calculator.pastHund(500)),
				calculator.remainHund(500), dayCalculator.addDays(calculator.remainHund(500)),
				calculator.remainHund(400), dayCalculator.addDays(calculator.remainHund(400)),
				calculator.remainHund(300), dayCalculator.addDays(calculator.remainHund(300)),
				calculator.remainHund(200), dayCalculator.addDays(calculator.remainHund(200)),
				calculator.remainHund(100), dayCalculator.addDays(calculator.remainHund(100))));
		

		//�Դ����� 1�� �Ѱ� ���Ҵ���,  1���� ��������
		switch(calculator.oneYear()){
		case 1: finalResult.append(String.format("\n- 1��(D-365��)�� ����������, \n�Դ� 1�������� %d�� �����̽��ϴ�.",365-calculator.getPastDays()));
		break;
		case 2:  finalResult.append("\n- 1��(D-365��)�� ����������, \n�� �Դ����� 1�ֳ��̽ʴϴ�. ���ϵ帳�ϴ�^^");
		break;
		case 3:  finalResult.append("\n- 1��(D-365��)�� ����������, \n�Դ����� 1������ �̹� �������ϴ�.");
		break;
		case 4: finalResult.append("\n- �� 1�� �����̽��ϴ�..^^");
		break;
		case 5:finalResult.append(String.format("\n- ���� 1��(D-365��)�� �ȱ����̽��ϴ�. \n1�� ��������� %d�� �������� (%s), \n%d�� �� �Դ� 1������ �˴ϴ�.",calculator.getRemainDays()-365, dayCalculator.addDays(calculator.getRemainDays()-365),365-calculator.getPastDays()));
		default:  break;
		}

		//���ݱ��� �밭 ���� «��
		finalResult.append(String.format("\n\n- �Դ� �� ���ݱ��� ��� «�� %d�� �̸�, \n������ %d�� �� ��ž� �մϴ�.\n\n",calculator.eatedJjam(),calculator.willEatJjam()));
		//����Ȱ�� 24�ð����� ǥ���Ͽ��� ��
		finalResult.append(String.format("- ����Ȱ�� 24�ð��̶��?, \n���� �ð��� "+calculator.dayConvert()+"�Դϴ�.\n\n"));
		//������� « á���� ������
		switch(calculator.jjam(calculator.getPercentage())){
		case 1:finalResult.append("�����...?"); break;	//20%������ ���
		case 2: finalResult.append("������ ���� ���׿�."); break;	//30%������ ���
		case 3: finalResult.append("��������������. ���� «���Դϴ�."); break;	//40%������ ���
		case 4:finalResult.append("������ �޷����� ������ «��");  break;	//50%������ ���
		case 5: finalResult.append("���� �ܿ� �� ������");  break;	//60%������ ���
		case 6: finalResult.append("«�� ���ݾ� ���°� �������ó���?\n������ ������ ���� ���ҳ׿�^^");  break;	//70%������ ���
		case 7: finalResult.append("������ ����Ȱ�� �� �������̰ھ��~");  break;	//80%������ ���
		case 8: finalResult.append("������ ���̽ó���?..�׷��� �����Դϴ�^^");  break;	//90%������ ���
		case 9: finalResult.append("������ ���δ�!");  break;	//100%������ ���
		default:  finalResult.append("����");  break;
		}
		finalResult.append("\n-------------------------------------------------------");
		
	}

	private double remainPercentage = calculator.getPercentage();  //����percentage�� 

	public double getPercentage(){
		return remainPercentage;
	}

	public StringBuilder getFinalResult() {
		return finalResult;
	}



}
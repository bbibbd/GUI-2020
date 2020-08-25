package com.tistory.musit.MilitaryLifeCalculator;

class DataManagement{
	
	protected String name;

	protected int startYear=2019; //�Դ��� �⵵
	protected int startMonth=1;   //�Դ��� ��
	protected int startDate=21;   //�Դ��� ��

	public int getBetweenDays() {
		return betweenDays;
	}

	public void setBetweenDays(int betweenDays) {
		this.betweenDays = betweenDays;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public int getStartDate() {
		return startDate;
	}

	public int getEndYear() {
		return endYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setBetweenYear(int betweenYear) {
		this.betweenYear = betweenYear;
	}

	public void setBetweenMonth(int betweenMonth) {
		this.betweenMonth = betweenMonth;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public void setRemainDays(int remainDays) {
		this.remainDays = remainDays;
	}

	public void setPastDays(int pastDays) {
		this.pastDays = pastDays;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	protected int endYear=2020;   //�����ϴ� �⵵
	protected int endMonth=11;    //�����ϴ� ��
	protected int endDate=20;     //�����ϴ� ��

	protected int betweenYear;  //��ü ����Ȱ O��
	protected int betweenMonth; //��ü ����Ȱ O��
	protected int betweenDays;  //��ü ����Ȱ O��
	protected int minusDays;

	public int getMinusDays() {
		return minusDays;
	}

	public void setMinusDays(int minusDays) {
		this.minusDays = minusDays;
	}

	protected int totalDays;    //��ü ����Ȱ�ϴ� �ϼ�
	protected int remainDays;   //���� �ϼ�
	protected int remainWeeks;  //���� ��
	protected int pastDays;     //�̹� �� �ϼ�
	protected double percentage;//����Ȱ ���ۼ�Ʈ �ߴ���

	public void setStartYear(int startYear){
		this.startYear = startYear;
	}

	public void setStartMonth(int startMonth){
		this.startMonth = startMonth;
	}

	public void setStartDate(int startDate){
		this.startDate = startDate;
	}  

	public void setEndYear(int endYear){
		this.endYear = endYear;
	}

	public void setEndMonth(int endMonth){
		this.endMonth = endMonth;
	}

	public void setEndDate(int endDate){
		this.endDate = endDate;
	}  

	public void setRemainWeeks(int remainWeeks){
		this.remainWeeks = remainWeeks;
	}

	public int getBetweenYear(){
		return betweenYear;
	}

	public int getBetweenMonth(){
		return betweenMonth;
	}

	public int getBetweenDay(){
		return betweenDays;
	}

	public int getTotalDays(){
		return totalDays;
	}

	public int getRemainDays(){
		return remainDays;
	}

	public int getPastDays(){
		return pastDays;
	}

	public int getRemainWeeks(){
		return remainWeeks;
	}

	public double getPercentage(){
		return percentage;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
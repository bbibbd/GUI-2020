package com.tistory.musit.MilitaryLifeCalculator;

public class Main {

	public static void main(String[] args) {
		FrameSetting frame = new FrameSetting("����Ȱ ����", 800, 200, 400, 600);
		frame.setButton();
		frame.setDate();
		frame.showResult();
		frame.setVisible(true);
	}

}

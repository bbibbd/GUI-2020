package com.tistory.musit.MilitaryLifeCalculator;

public class MilitaryLifeCalculator {

	public static void main(String[] args) {
		FrameSetting frame = new FrameSetting("����Ȱ ����", 800, 200, 330,555);
		frame.setButton();
		frame.setDate();
		frame.showResult();
		frame.setVisible(true);
	}

}

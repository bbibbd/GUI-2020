package com.tistory.musit.MilitaryLifeCalculator;

import java.time.LocalDate;
import java.util.Calendar;

public class DayCalculator{		

	public String addDays(int days){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, days);

		return now.get(Calendar.YEAR)+"�� "+(now.get(Calendar.MONTH)+1)+"�� "+now.get(Calendar.DATE)+"��";
	}
	
	public Calendar subDays(int sty, int stm, int std, int mid) {
		if(mid<=0)	mid =0;
		if(mid>=91)	mid = 91;
		Calendar cl = Calendar.getInstance();
		cl.set(sty,stm,std);
		cl.add(Calendar.DATE, 640-mid);
		return cl;
	}
}
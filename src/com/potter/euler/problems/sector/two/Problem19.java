package com.potter.euler.problems.sector.two;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Problem19 {
	private final int[] daysInMonth = {31,	28,	31,	30,	31,	30,	31,	31,	30,	31,	30,	31};
	
//	private final String initialDateString = "01/01/1900";
	private final String startDateString = "01/01/1901";
	private final String endDateString = "12/31/2000";
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//	private Date initial;
	private Date start;
	private Date end;
	private Calendar c = Calendar.getInstance();
	
	public static boolean isLeapYear(int year){
		if(year%400==0){
			return true;
		}
		if(year%4 == 0){
			if(year%100!=0){
				return true;
			}
		}
		return false;
	}
	
	public int calculate(){
		int i=0;
		int count = 0;
		do{
			if(c.getTime().after(start)){
				if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
					count++;
				}
			}
			if(isLeapYear(c.get(Calendar.YEAR))){
				if(c.get(Calendar.MONTH) == Calendar.FEBRUARY){
					c.add(Calendar.DATE, 1);
				}
			}
			c.add(Calendar.DATE, daysInMonth[i]);
			i = (i+1)%12;
		}while(c.getTime().before(end));
		return count;
	}
	
	public Problem19(){
		try {
//			initial = dateFormat.parse(initialDateString);
			start = dateFormat.parse(startDateString);
			end = dateFormat.parse(endDateString);
			c.setTime(start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int alternateCalculator(){
		int count = 0;
		for(int year = 1901; year < 2001; year++){
			for(int month = 1; month <= 12; month++){
				Calendar cal = Calendar.getInstance();
				cal.set(year, month, 1);
				if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Problem19 problem = new Problem19();
		
		
		int countOne = problem.calculate();
		System.out.println(countOne);
		long next = (System.currentTimeMillis()-start);
		System.out.println("Runtime = " + next + " ms");
		System.out.println();
		
		int countTwo = Problem19.alternateCalculator();
		System.out.println(countTwo);
		System.out.println("Runtime = " + (System.currentTimeMillis()-next-start) + " ms");
		
	}
	
}

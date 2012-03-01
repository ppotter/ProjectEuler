package com.potter.euler.problems.sector.one;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Problem1 {
	public static void problem1(){
		int three = 3, five = 5, max = 1000;
		int sum = 0;
		Set<Integer> multiples = new TreeSet<Integer>();
		
		for(int i = 1; i < max; i++){
			if(i%three == 0 || i%five == 0){
				multiples.add(i);
			}
		}
		for (Iterator iterator = multiples.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			sum += integer.intValue();
		}
		System.out.print(sum);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem1();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}


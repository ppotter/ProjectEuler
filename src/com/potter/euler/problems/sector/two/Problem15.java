package com.potter.euler.problems.sector.two;

import com.potter.euler.problems.ProblemUtilities;

public class Problem15 {

	public static void problem15(){
		System.out.println(ProblemUtilities.combination(40,20));
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem15();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
	
}

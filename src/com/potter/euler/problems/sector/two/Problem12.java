package com.potter.euler.problems.sector.two;

import com.potter.euler.problems.ProblemUtilities;

public class Problem12 {

	//Triangle numbers.
	public static void problem12(){
		int i = 2;
		int sum = 1;
		
		while(ProblemUtilities.numberOfDivisors(sum) < 500){
			sum += i;
			i++;
		}
		
		
		System.out.println(sum);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem12();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

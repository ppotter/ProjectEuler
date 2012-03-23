package com.potter.euler.problems.sector.two;

import java.util.ArrayList;

import com.potter.euler.problems.ProblemUtilities;

public class Problem10 {
	public static void problem10(){
		long num = 2000000;
		ArrayList<Long> primes = new ArrayList<Long>();
		for(long i = 2; i < num; i++){
			if(ProblemUtilities.isPrime(i)){
				primes.add(i);
			}
		}
		System.out.println("sum = " + ProblemUtilities.getSumLong(primes));
		
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem10();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

package com.potter.euler.problems.sector.one;

import java.util.ArrayList;

import com.potter.euler.problems.ProblemUtilities;

public class Problem7 {
	public static void problem7(){
		ArrayList<Long> primes = new ArrayList<Long>();
		//the number-th prime we wish to find
		long n = 10001;
		long i = 2;
		while(primes.size() <= n){
			if(ProblemUtilities.isPrime(i)){
				primes.add(new Long(i));
			}
			i++;
		}
		System.out.println(primes.get(10000).longValue());
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem7();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

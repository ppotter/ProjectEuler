package com.potter.euler.problems.sector.two;

import java.math.BigInteger;

import com.potter.euler.problems.ProblemUtilities;

public class Problem16 {
	public static void problem16(){
		BigInteger number = new BigInteger("2").pow(1000);
		BigInteger result = ProblemUtilities.sumDigits(number);

		System.out.println(result);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem16();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

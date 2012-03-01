package com.potter.euler.problems.sector.one;

import static com.potter.euler.problems.ProblemUtilities.square;
import static com.potter.euler.problems.ProblemUtilities.sumSquares;
import static com.potter.euler.problems.ProblemUtilities.sum;

public class Problem6 {

	public static void problem6(){
		long sumOfSquares = sumSquares(1, 100);
		long squareOfSums = square(sum(1, 100));
		long result = squareOfSums-sumOfSquares;
		System.out.println(result);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem6();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

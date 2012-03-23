package com.potter.euler.problems.sector.three;

import java.math.BigInteger;

public class Problem20 {
	
	public static BigInteger factorial(int n){
		BigInteger result = new BigInteger("1");
		for(int i = n; i > 0; i--){
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		return result;
	}
	
	public static int sumDigits(BigInteger n){
		int result = 0;
		while(!n.equals(BigInteger.ZERO)){
			result += n.mod(BigInteger.TEN).intValue();
			n = n.divide(BigInteger.TEN);
		}
		return result;
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		System.out.println(sumDigits(factorial(100)));
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
	}
	
}

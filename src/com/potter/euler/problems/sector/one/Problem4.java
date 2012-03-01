package com.potter.euler.problems.sector.one;

import java.util.ArrayList;
import static com.potter.euler.problems.ProblemUtilities.isPalindrome;
import static com.potter.euler.problems.ProblemUtilities.getMax;

public class Problem4 {
	public static void problem4(){
		int n;
		ArrayList<Long> palindroms = new ArrayList<Long>();
		for(int i = 999; i > 99; i--){
			for(int j = 999; j > 99; j--){
				Long num = new Long(i*j);
				if(isPalindrome(num.toString())){
					palindroms.add(num);
				}
			}
		}
		System.out.println(getMax(palindroms));
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem4();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

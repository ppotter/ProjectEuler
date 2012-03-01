package com.potter.euler.problems.sector.one;

public class Problem5 {

	/*
	 * generic solution for problem 5
	 */
	public static void problem5(){
		long min = 1, max = 20;
		long n = 1;
		for( long j = min; j <= 20; j++){
			n *= j;
		}
		
		newNumber:
		for(long i = max; i < n; i++ ){
			for(long j = min; j <= max; j++){
				if(i%j != 0){
					continue newNumber;
				}
			}
			n = i;
		}
		System.out.println(n);
	}
	
	/*
	 * optimized solution for problem 5 assuming you always start at 1 or 2 
	 * 232792560
	 */
	public static void problem5_Opt(){
		long min = 1, max = 20;
		long n = 1;
		for( long j = 2; j <= 20; j++){
			n *= j;
		}
		
		newNumber:
		for(long i = max; i < n; i+=2 ){
			for(long j = 2; j <= max; j++){
				if(i%j != 0){
					continue newNumber;
				}
			}
			n = i;
		}
		System.out.println(n);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem5();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

package com.potter.euler.problems.sector.one;

public class Problem2 {

	public static void problem2(){
		long max = 4000000;
		long[] fibo = new long[10000];
		fibo[0] = 1;
		fibo[1] = 2;
		int index = 2;
		long sum = 2;
		while(fibo[index-1] < max){
			fibo[index] = fibo[index-1]+ fibo[index-2];
			if(fibo[index]%2 == 0){
				sum += fibo[index];
			}
			index++;
		}
		System.out.print(sum);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem2();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

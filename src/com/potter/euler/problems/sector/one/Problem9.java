package com.potter.euler.problems.sector.one;

public class Problem9 {
	
	public static void problem9(){
		int sum = 1000;
		int a = 0, b = 0, c = 0;
		all:
		for(a = 2; a < sum; a++){
			for(b = 2; b < sum; b++){
				for(c = 2; c < sum; c++){
					if(a + b + c == sum){
						if((a*a) + (b*b) == c*c){
							break all;
						}
					}
				}
			}
		}
		System.out.println("a = " + a );
		System.out.println("b = " + b );
		System.out.println("c = " + c );
		System.out.println("abc = " + a*b*c);
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem9();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

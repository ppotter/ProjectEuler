package com.potter.euler.problems.sector.one;

import java.util.ArrayList;
import static com.potter.euler.problems.ProblemUtilities.isPrime;
import static com.potter.euler.problems.ProblemUtilities.getMax;;
public class Problem3 {

	public static void problem3(){
		Long factor = new Long("600851475143");
		ArrayList<Long> primes = new ArrayList<Long>();
		for(long i = 3; i < (factor.longValue()); i++){
			while(factor.longValue()%i ==0){
				factor = new Long(factor.longValue()/i);
				if(isPrime(i)){
					primes.add(i);
				}
			}
		}
		if(isPrime(factor.longValue())){
			primes.add(factor);
		}
		 System.out.println(getMax(primes));
		
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem3();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

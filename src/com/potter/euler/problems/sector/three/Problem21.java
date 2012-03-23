package com.potter.euler.problems.sector.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.potter.euler.problems.ProblemUtilities;

public class Problem21 {

	private Set<Integer> amicable = new HashSet<Integer>();

	public void calculateAmicable(int n){
		for(int i = 1; i < n; i++){
			if(!amicable.contains(new Integer(i))){
				ArrayList<Integer> divisors = ProblemUtilities.getDivisors(i); 
				int sum = ProblemUtilities.getSumInt(divisors);
				ArrayList<Integer> sumDivisors = ProblemUtilities.getDivisors(sum);
				int sum2 = ProblemUtilities.getSumInt(sumDivisors);
				if(i == sum2 && sum != sum2){
					amicable.add(new Integer(i));
					amicable.add(new Integer(sum));
				}
			}
		}
	}
	
	/**
	 * @return the amicable
	 */
	public Set<Integer> getAmicable() {
		return amicable;
	}

	/**
	 * @param amicable the amicable to set
	 */
	public void setAmicable(Set<Integer> amicable) {
		this.amicable = amicable;
	}

	public Problem21(){}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Problem21 problem = new Problem21();
		problem.calculateAmicable(10000);
		int result = ProblemUtilities.getSumInt(problem.getAmicable());
		
		System.out.println(result);
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
	}
}

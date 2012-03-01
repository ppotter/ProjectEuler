package com.potter.euler.problems.sector.two;

import java.io.File;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;

import com.potter.euler.problems.ProblemUtilities;

public class Problem13 {
	
	public static void problem13(){
		File file = new File("./etc/problem13.txt");
		Collection<String> numbers = ProblemUtilities.readFile(file);
		BigInteger sum = new BigInteger("0");
		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			BigInteger number = new BigInteger(string);
			sum = sum.add(number);
		}
		
		System.out.println("Sum = " + sum);
			
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem13();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

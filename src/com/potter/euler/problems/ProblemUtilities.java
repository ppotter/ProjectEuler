package com.potter.euler.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProblemUtilities {

	
	public static boolean isPrime(long n){
		 if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
	}
	
	public static int getMax(ArrayList<Long> nums){
		int max = 0;
		for (Iterator iterator = nums.iterator(); iterator.hasNext();) {
			Long integer = (Long) iterator.next();
			if(integer.intValue() > max){
				max = integer.intValue();
			}
		}
		return max;
	}
	
	public static boolean isPalindrome(String s){
		for(int i = 0; i < s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	
	public static long getSum(ArrayList<Long> nums){
		long result = 0;
		for (Iterator iterator = nums.iterator(); iterator.hasNext();) {
			Long long1 = (Long) iterator.next();
			result += long1.longValue();
		}
		return result;
	}
	
	public static long sum(int min, int max){
		long result = 0;
		for(int i = min; i <= max; i++){
			result += i;
		}
		return result;
	}
	
	public static long sumSquares(int min, int max){
		long result = 0;
		for(int i = min; i <= max; i++){
			result += square(i);
		}
		return result;
	}
	
	public static long square(long n){
		return n*n;
	}
	
	public static long multiplyNumbers(String n){
		int result = 1;
		int number = Integer.parseInt(n);
		for(int i = 0; i < n.length(); i++){
			result *= number%10;
			number = number/10;
		}
		return result;
	}
	
	public static boolean containsZero(String n){
		for(int i = 0; i < n.length(); i++){
			if(n.charAt(i) == '0'){
				return true;
			}
		}
		return false;
	}
	
	public static int containsZeroAt(String n){
		for(int i = 0; i < n.length(); i++){
			if(n.charAt(i) == '0'){
				return i;
			}
		}
		return -1;
	}
	
	public static int[][] readTextIntoArray(String s, int rows, int columns){
		int[][] square = new int[20][20];
		String[] splitString = s.split(" ");
		int stringIndex = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				square[i][j] = Integer.parseInt(splitString[stringIndex++]);
			}
		}
		return square;
	}
	
	public static boolean isDivisor(int n, int factor){
		return (n%factor==0);
	}
	
	public static boolean isDivisor(long n, long factor){
		return (n%factor==0);
	}
	
	public static int numberOfDivisors(int n){
		int result = 0;
		int sqrt = (int) Math.sqrt(n);
		for(int i = 1; i <= sqrt; i++){
			if(isDivisor(n, i)){
				result+=2;
			}
		}
		if(sqrt*sqrt == n){
			result--;
		}
		return result;
	}
	
	public static boolean isOdd(long n){
		return (n%2==1);
	}
	
	public static boolean isEven(long n){
		return (n%2==0);
	}
	
	public static BigInteger factorial(int n){
		if(n == 0){
			return new BigInteger("0");
		}
		BigInteger result = new BigInteger("1");
		for(int i = 1; i <= n; i++){
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		return result;
	}
	
	public static BigInteger combination(int pool, int choose){
		BigInteger result = factorial(pool);
		BigInteger denom = factorial(choose).multiply(factorial(pool - choose));
		result = result.divide(denom);
		return result;
	}
	
	public static BigInteger sumDigits(BigInteger n){
		BigInteger result = new BigInteger("0");
		while(!n.toString().equals("0")){
			result = result.add(n.mod(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		return result;
	}
	
	public static Collection<String> readFile(File file){
		Collection<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}
}

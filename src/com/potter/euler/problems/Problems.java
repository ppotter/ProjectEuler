package com.potter.euler.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class Problems {

	
	public static void problem1(){
		int three = 3, five = 5, max = 1000;
		int sum = 0;
		Set<Integer> multiples = new TreeSet<Integer>();
		
		for(int i = 1; i < max; i++){
			if(i%three == 0 || i%five == 0){
				multiples.add(i);
			}
		}
		for (Iterator iterator = multiples.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			sum += integer.intValue();
		}
		System.out.print(sum);
	}
	
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
	
	public static boolean isPalindrome(String s){
		for(int i = 0; i < s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	
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
	
	public static void problem6(){
		long sumOfSquares = sumSquares(1, 100);
		long squareOfSums = square(sum(1, 100));
		long result = squareOfSums-sumOfSquares;
		System.out.println(result);
	}
	
	public static void problem7(){
		ArrayList<Long> primes = new ArrayList<Long>();
		//the number-th prime we wish to find
		long n = 10001;
		long i = 2;
		while(primes.size() <= n){
			if(isPrime(i)){
				primes.add(new Long(i));
			}
			i++;
		}
		System.out.println(primes.get(10000).longValue());
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
	
	
	
	public static void problem8(){
		String number = 
			  "73167176531330624919225119674426574742355349194934"
			+ "96983520312774506326239578318016984801869478851843"
			+ "85861560789112949495459501737958331952853208805511"
			+ "12540698747158523863050715693290963295227443043557"
			+ "66896648950445244523161731856403098711121722383113"
			+ "62229893423380308135336276614282806444486645238749"
			+ "30358907296290491560440772390713810515859307960866"
			+ "70172427121883998797908792274921901699720888093776"
			+ "65727333001053367881220235421809751254540594752243"
			+ "52584907711670556013604839586446706324415722155397"
			+ "53697817977846174064955149290862569321978468622482"
			+ "83972241375657056057490261407972968652414535100474"
			+ "82166370484403199890008895243450658541227588666881"
			+ "16427171479924442928230863465674813919123162824586"
			+ "17866458359124566529476545682848912883142607690042"
			+ "24219022671055626321111109370544217506941658960408"
			+ "07198403850962455444362981230987879927244284909188"
			+ "84580156166097919133875499200524063689912560717606"
			+ "05886116467109405077541002256983155200055935729725"
			+ "71636269561882670428252483600823257530420752963450";
		ArrayList<Long> products = new ArrayList<Long>();
		for(int i = 0; i < number.length()-5; i++){
			String fiveDigitNumber = number.substring(i, i+5);
			if(!containsZero(fiveDigitNumber)){
				products.add(new Long(multiplyNumbers(fiveDigitNumber)));
			}else{
				i+=containsZeroAt(fiveDigitNumber);
			}
		}
		System.out.println(getMax(products));
		
	}
	
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
	
	public static void problem10(){
		long num = 2000000;
		ArrayList<Long> primes = new ArrayList<Long>();
		for(long i = 2; i < num; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		System.out.println("sum = " + getSum(primes));
		
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
	
	public static void problem11(){
		int r = 20, c = 20;
		String numString = 
			  "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
			+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
			+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
			+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
			+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
			+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
			+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
			+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
			+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
			+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
			+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
			+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
			+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
			+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
			+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
			+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
			+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
			+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
			+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
			+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 ";
		int[][] nums = readTextIntoArray(numString, r, c);
		
		ArrayList<Long> products = new ArrayList<Long>();
		for(int i = 0; i < c; i++ ){
			for(int j = 0; j < r; j++){
				//vertical 
				if(i+4 <= r){
					products.add(new Long(nums[i][j]*nums[i+1][j]*nums[i+2][j]*nums[i+3][j]));
				}
				//horizontal
				if(j+4 <= c){
					products.add(new Long(nums[i][j]*nums[i][j+1]*nums[i][j+2]*nums[i][j+3]));
				}
				//diagonal
				if(i+4 <= r && j+4 <= c){
					products.add(new Long(nums[i][j]*nums[i+1][j+1]*nums[i+2][j+2]*nums[i+3][j+3]));
				}
				//reverse diagonal
				if(i+4 <= r && j-4 >= 0){
					products.add(new Long(nums[i][j]*nums[i+1][j-1]*nums[i+2][j-2]*nums[i+3][j-3]));
				}
			}
		}
		
		System.out.println(getMax(products));
		
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
	
	//Triangle numbers.
	public static void problem12(){
		int i = 2;
		int sum = 1;
		
		while(numberOfDivisors(sum) < 500){
			sum += i;
			i++;
		}
		
		
		System.out.println(sum);
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
	
	public static void problem13(){
		File file = new File("./etc/problem13.txt");
		Collection<String> numbers = readFile(file);
		BigInteger sum = new BigInteger("0");
		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			BigInteger number = new BigInteger(string);
			sum = sum.add(number);
		}
		
		System.out.println("Sum = " + sum);
			
	}
	
	public static boolean isOdd(long n){
		return (n%2==1);
	}
	
	public static boolean isEven(long n){
		return (n%2==0);
	}
	
	public static void problem14(){
		int longestStarter = 0;
		int longestChain = 0;
		for(int i = 2; i < 1000000; i++){
			int chainLength = 1;
			//i is the starter number
			long current = i;
			while(current > 1){
				if(isOdd(current)){
					current = (current * 3) + 1;
				}else{
					current = current/2;
				}
				chainLength++;
			}
			if(chainLength > longestChain){
				longestStarter = i;
				longestChain = chainLength;
			}
		}
		System.out.println("Longest Starter = " + longestStarter);
		System.out.println("Longest Chain = " + longestChain);
	}
	
	//This method over fills the stack and wont well work for 20x20
	public static long recursiveCube(int x, int y, int MaxX, int MaxY){
		long result = 0;
		if(x == (MaxX) || y == (MaxY)){
			result++;
		}else{
			if(x < MaxX){
				result += recursiveCube(x+1,y,MaxX,MaxY); 
			}
			if(y < MaxY){
				result += recursiveCube(x,y+1,MaxX,MaxY); 
			}
		}
		return result;
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
	
	public static void problem15(){
		System.out.println(combination(40,20));
	}
	
	public static BigInteger sumDigits(BigInteger n){
		BigInteger result = new BigInteger("0");
		while(!n.toString().equals("0")){
			result = result.add(n.mod(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		return result;
	}
	

	
	public static void problem16(){
		BigInteger number = new BigInteger("2").pow(1000);
		BigInteger result = sumDigits(number);

		System.out.println(result);
	}

	//	public static String spellOutNumber(int n){
	//	if(n > 1000){
	//		throw new UnsupportedOperationException("Value cannot be over 1000");
	//	}
	//	NumberFormat formatter;
	//	String result = "";
	//	String [] ones = {null,"one","two","three","four","five","six","seven","eight","nine","ten"};
	//	String [] teens = {null,"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
	//	String [] tens = {null,"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety","hundred"};
	//	String number = Integer.toString(n);
	//	
	//	
	//	
	//	return result;
	//}

	public static String getSpellOutNumber(int n){
		NumberFormat formatter = new RuleBasedNumberFormat(RuleBasedNumberFormat.SPELLOUT);
		String result = formatter.format(n);
		String[] strings = result.split("hundred");
		if(strings.length > 1){
				result = strings[0] + "hundred and" + strings[1];
		}
		return result;
	}

	public static long getNumberOfCharacters(int n){
		String spellout = getSpellOutNumber(n);
		long result = 0;
		for(int i = 0; i < spellout.length();i++){
			if(spellout.charAt(i) != ' ' && spellout.charAt(i) != '-'){
				result++;
			}
		}
		return result;
	}
	
	public static void problem17(){
		long result = 0; 
		for(int i = 1; i <= 1000; i++){
			result += getNumberOfCharacters(i);
		}
		System.out.println(result);
	}
	


	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
	
}

package com.potter.euler.problems.sector.two;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RuleBasedNumberFormat;

public class Problem17 {
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
		
		problem17();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

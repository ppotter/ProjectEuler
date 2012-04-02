package com.potter.euler.problems.sector.three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

import com.potter.euler.problems.ProblemUtilities;

public class Problem22 {

	private static final String filePath = "./etc/problem22.txt";
	
	
	public ArrayList<String> importNames(String file){
		File f = new File(file);
		StringBuilder lines = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = br.readLine()) != null) {
				lines.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] rawNames = lines.toString().split(",");
		ArrayList<String> result = new ArrayList<String>();
		
		for(String name : rawNames){
			result.add(name.split("\"")[1]);
		}
		
		return result;
	}
	
	public static long calculateNameValue(String name){
		long result = 0;
		String caps = name.toUpperCase();
		for(int i = 0; i < name.length(); i++){
			result += (long) caps.charAt(i) - 64;
		}
		
		return result;
	}
	
	public BigInteger execute(){
		ArrayList<String> names = importNames(filePath);
		ArrayList<Long> nameValues = new ArrayList<Long>();
		Collections.sort(names);
		for(int i = 0; i < names.size(); i++){
			String name = names.get(i);
			nameValues.add(new Long(calculateNameValue(name)*(i+1)));
		}
		
		return ProblemUtilities.getSumBig(nameValues);
	}
	
	public Problem22(){}
	
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Problem22 problem = new Problem22();
		BigInteger result = problem.execute();
		
		System.out.println(result.toString());
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
	}
}

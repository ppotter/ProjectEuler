package com.potter.euler.problems.sector.two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import com.potter.euler.problems.ProblemUtilities;

public class Problem18 {

	private ArrayList<Long> numbers = new ArrayList<Long>();
	private ArrayList<Long> numbersTop = new ArrayList<Long>();
	private ArrayList<Long> numbersBottom = new ArrayList<Long>();
	private int[][] triangle;
	
	public void constructTriangle(File file){
		int j = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			String[] numbers;
			while ((line = br.readLine()) != null) {
				numbers = line.split(" ");
				for(int i = 0; i < numbers.length; i++){
					triangle[j][i] = Integer.parseInt(numbers[i]);
				}
				j++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void bruteForceTriangle(int r, int c, int sum){
		if(r < triangle.length && c < triangle[r].length){
			bruteForceTriangle(r+1, c,sum+triangle[r][c]);
			bruteForceTriangle(r+1, c+1,sum+triangle[r][c]);
		}else{
			numbers.add(new Long(sum));
		}
	}
	
	public void splitTopBruteForceTriangle(int r, int c, int sum){
		if(r < triangle.length/2 && c < triangle[r].length){
			bruteForceTriangle(r+1, c,sum+triangle[r][c]);
			bruteForceTriangle(r+1, c+1,sum+triangle[r][c]);
		}else{
			numbers.add(new Long(sum));
		}
	}
	
	public void splitBottomBruteForceTriangle(int r, int c, int sum){
		if(r < triangle.length && c < triangle[r].length){
			bruteForceTriangle(r+1, c,sum+triangle[r][c]);
			bruteForceTriangle(r+1, c+1,sum+triangle[r][c]);
		}else{
			numbers.add(new Long(sum));
		}
	}
	
	
	public void choiceTriangle(int r, int c, int sum){
		if(r < triangle.length && c < triangle[r].length){
			for(int i = 0; i < triangle[r].length; i++){
				
			}
		}
	}
	
	public Problem18(String file, int triangleSize){
		triangle = new int[triangleSize][triangleSize];
		constructTriangle(new File(file));
//		bruteForceTriangle(0,0, 0);
		
		System.out.println(ProblemUtilities.getMax(numbers));
		
	}

	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		Problem18 problem18 = new Problem18("./etc/problem18.txt",15);
		
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

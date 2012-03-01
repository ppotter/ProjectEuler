package com.potter.euler.problems.sector.two;

import com.potter.euler.problems.ProblemUtilities;

public class Problem14 {
	
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
	
	public static void problem14(){
		int longestStarter = 0;
		int longestChain = 0;
		for(int i = 2; i < 1000000; i++){
			int chainLength = 1;
			//i is the starter number
			long current = i;
			while(current > 1){
				if(ProblemUtilities.isOdd(current)){
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
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		problem14();
		System.out.println();
		System.out.println("Runtime = " + (System.currentTimeMillis()-start) + " ms");
		
	}
}

package com.ds.graph;

import java.util.Arrays;

public class MinimumSumPair {

	public static void main(String[] args) {
		
		   int[][] matrix = new int[][] { {1,3,1}, {1,5,1}, {4,2,1} };
		   
		   int[][] dp = new int[matrix.length][matrix[0].length];
		   
		   for(int i=0;i<matrix.length;i++) {
			   for(int j =0;j<matrix[0].length;j++) {
				   dp[i][j] += matrix[i][j];
				   
				   if(i>0 && j>0) 
					   dp[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
			   }
		   }
		
		   
		   for(int i=0;i<matrix.length;i++) {
			   System.out.println(Arrays.toString(matrix[i]));
			   System.out.println(Arrays.toString(dp[i]));
		   }
	}
}

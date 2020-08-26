package com.prog;

public class Knapsack {

	public static void main(String args[]) {
		
		int values[] = new int[] { 1,2,5,6 };
		int weight[] = new int[] { 2,3,4,5 };
		
		int totWeight = 8;
		int noOfItems = values.length;
		
		System.out.println("\n\n\n"+knapSack(totWeight, weight, values, noOfItems));
	}

	static int knapSack(int totWeight, int weight[], int values[], int noOfItems) {
		
		int i, j;
		
		int dp[][] = new int[noOfItems + 1][totWeight + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= noOfItems; i++) {
			for (j = 0; j <= totWeight; j++) {
				
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				
				else if (weight[i - 1] <= j)
					dp[i][j] = Math.max( dp[i - 1][j],  (values[i-1] + dp[i-1][j-weight[i-1]]));
				
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		
		System.out.println("Solution Table ::::: ");
		for(i=0;i<dp.length;i++) {
			System.out.println();
			for(j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j] +" ");
			}
		}
		
		
		
		return dp[noOfItems][totWeight];
	}

}

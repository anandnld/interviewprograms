package com.prog;

public class LongestPath {

	private int n = 3;
	
	public static void main (String[] args)  
    { 
        int  matrix[][] = { {1, 2, 9}, 
                         {5, 3, 8}, 
                         {4, 6, 7} }; 
        
        LongestPath obj = new LongestPath();
        System.out.println("Longest Path : "+obj.finLongestOverAll(matrix));
    } 
	
	public int finLongestOverAll(int matrix[][]) 
    { 
        // Initialize result 
        int result = 1;   
   
        // Create a lookup table and fill all entries in it as -1 
        int[][] dp = new int[n][n]; 
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++) 
                dp[i][j] = -1; 
   
        // Compute longest path beginning from all cells 
        for (int i=0; i<n; i++) 
        { 
            for (int j=0; j<n; j++) 
            { 
                if (dp[i][j] == -1) 
                    findLongestFromACell(i, j, matrix, dp); 
   
                //  Update result if needed 
                result = Math.max(result, dp[i][j]); 
            } 
        } 
        
        System.out.println("DP TABLE :::: ");
        for (int i=0; i<n; i++) 
        { 
            for (int j=0; j<n; j++) 
            { 
            	System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        
        
        return result; 
    } 
	
	public int findLongestFromACell(int i, int j, int matrix[][], int dp[][]) 
    { 
        // Base case 
        if (i<0 || i>=n || j<0 || j>=n) 
            return 0; 
   
        // If this subproblem is already solved 
        if (dp[i][j] != -1) 
            return dp[i][j]; 
   
        // Since all numbers are unique and in range from 1 to n*n, 
        // there is atmost one possible direction from any cell 
        if (j<n-1 && (matrix[i][j] +1 == matrix[i][j+1])) 
            return dp[i][j] = 1 + findLongestFromACell(i,j+1,matrix,dp); 
   
        if (j>0 && (matrix[i][j] +1 == matrix[i][j-1])) 
            return dp[i][j] = 1 + findLongestFromACell(i,j-1,matrix,dp); 
   
        if (i>0 && (matrix[i][j] +1 == matrix[i-1][j])) 
            return dp[i][j] = 1 + findLongestFromACell(i-1,j,matrix,dp); 
   
        if (i<n-1 && (matrix[i][j] +1 == matrix[i+1][j])) 
            return dp[i][j] = 1 + findLongestFromACell(i+1,j,matrix,dp); 
   
        // If none of the adjacent fours is one greater 
        return dp[i][j] = 1; 
    } 
}

package com.prog;

public class LargestSquareMatrix {

	public static void main(String[] args) {
		
		int arr[][] = new int[][] { { 1, 1, 0, 0 },
									{ 1, 1, 1, 1 },
									{ 1, 1, 1, 0 },
									{ 1, 1, 1, 1 } };
		
		int solArr[][] = new int[arr.length][arr[0].length];
									
		LargestSquareMatrix obj = new LargestSquareMatrix();							
		
		int result = obj.getLargestSquareMatrix(arr, solArr);
		
		System.out.println("Max square size  : "+ result);
		
	}
	
	public int getLargestSquareMatrix(int[][] arr, int solArr[][]){
		
		int r = arr.length;
		int c = arr[0].length;
		int result = 0;
		
		for(int i=0;i<r;i++){
			
			for(int j=0;j<c;j++){
				
				if(i == 0 || j == 0) 
					solArr[i][j] =  arr[i][j];
				else 
					solArr[i][j] =  arr[i][j] == 1 ? arr[i][i]+getMin(solArr, i, j) : arr[i][j];
				
				result = solArr[i][j] > result ? solArr[i][j] : result;
			}
		}
		return result;
	}
	
	public int getMin(int[][] arr, int r, int c){
		
		return  Math.min( Math.min(arr[r-1][c-1], arr[r-1][c]), arr[r][c-1]);
	}
}

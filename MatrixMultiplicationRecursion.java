package com.prog;

public class MatrixMultiplicationRecursion {

	public static void main(String[] args) {
		
	        int A[][] = { {1, 2, 3}, 
	                      {4, 5, 6} }; 
	   
	        int B[][] = { {1, 2, 3}, 
	                      {4, 5, 6}, 
	                      {7, 8, 9} }; 
	        
	        int r1 = A.length;
	        int c1 = A[0].length;
	        
	        int r2 = B.length;
	        int c2 = B[0].length;
	        
	        MatrixMultiplicationRecursion obj = new MatrixMultiplicationRecursion();
	        
	        int[][] C = new int[A[0].length][B.length]; 
	        
	        obj.multiplyMatrix(r1, c1, A, r2, c2, B, C); 
	        
	        System.out.println("OUTPUT: ");
	        for(int i=0;i<A.length;i++) {
	        	System.out.println();
	        	for(int j=0;j < A[i].length;j++){
	        		System.out.print(C[i][j] +"\t");
	        	}
	        }
	}
	
	public static int i = 0, j = 0, k = 0; 
	
	public void multiplyMatrix(int row1, int col1, int[][] A, int row2, int col2, int[][] B, int[][] C){
		
		// If all rows traversed 
        if (i >= row1) 
            return; 
   
        // If i < row1 
        if (j < col2) 
        { 
            if (k < col1) 
            { 
                C[i][j] += A[i][k] * B[k][j]; 
                k++; 
   
                multiplyMatrix(row1, col1, A, row2, col2, B, C); 
            } 
   
            k = 0; 
            j++; 
            multiplyMatrix(row1, col1, A, row2, col2, B, C); 
        } 
   
        j = 0; 
        i++; 
        multiplyMatrix(row1, col1, A, row2, col2, B, C);
	}
}

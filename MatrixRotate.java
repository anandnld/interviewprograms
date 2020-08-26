package com.prog;

public class MatrixRotate {

	private int prev, curr;

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5, 6 }, 
									   { 7, 8, 9, 10, 11, 12 }, 
									   { 13, 14, 15, 16, 17, 18 }, 
									   { 19, 20, 21, 22, 23, 24 },
									   };
		

		MatrixRotate obj = new MatrixRotate();
		obj.rotateMatrix_(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
		}
	}

	
	public void rotateMatrix_(int[][] matrix) {

		int r = matrix.length;
		int c = matrix[0].length;
		int row = 0, col = 0;

		while (row < r && col < c) {
			
			System.out.println("Inside");
			
		
			prev = matrix[row + 1][col];

			for (int i = col; i < c; i++) {
				swap(row, i, matrix); 
			}
			
			
			System.out.println("--------------");
			for (int i = 0; i < matrix.length; i++) {
				System.out.println();
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.print(matrix[i][j] + ", ");
				}
			}
			System.out.println("\n--------------");

			
			row++;

			for (int i = row; i < r; i++) {
				swap(i, c - 1, matrix); 
			}
			c--;

			if (row < r) {
				for (int i = c - 1; i >= col; i--) {
					swap(r - 1, i, matrix);
				}
			}
			r--;

			if (col < c) {
				for (int i = r - 1; i >= row; i--) {
					swap(i, col, matrix);
				}
			}
			col++;
		}
	}
	
	
	public void rotateMatrix(int[][] matrix) {

		int r = matrix.length;
		int c = matrix[0].length;
		int row = 0, col = 0;

		for (int cnt = 0;cnt<(r*c);cnt++) {
			
			System.out.println("Inside");
			prev = matrix[row + 1][col];

			for (int i = col; i < c; i++) {
				swap(row, i, matrix); cnt++;
			}
			row++;

			for (int i = row; i < r; i++) {
				swap(i, c - 1, matrix); cnt++;
			}
			c--;

			if (row < r) {
				for (int i = c - 1; i >= col; i--) {
					swap(r - 1, i, matrix); cnt++;
				}
			}
			r--;

			if (col < c) {
				for (int i = r - 1; i >= row; i--) {
					swap(i, col, matrix); cnt++;
				}
			}
			col++;
		}
	}

	public void swap(int i, int j, int matrix[][]) {
		curr = matrix[i][j];
		matrix[i][j] = prev;
		prev = curr;
	}
}

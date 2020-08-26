package com.prog;

public class MatrixChainMultiplication {
	static int cnt = 1;

	static int MatrixChainOrder(int p[], int i, int j) {
		System.out.println(cnt++ + " :---> " + i + " : " + j);

		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int count = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}

		return min;
	}

	static int MatrixChainOrder(int p[], int n) {
		
		cnt = 1;
		
		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in m[][]. 0th row and 0th column of m[][] are not used
		 */
		int m[][] = new int[n][n];

		int i, j, k, L, q;

		/*
		 * m[i, j] = Minimum number of scalar multiplications needed to compute
		 * the matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is
		 * p[i-1] x p[i]
		 */

		// cost is zero when multiplying one matrix.
		for (i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (L = 2; L < n; L++) {
			cnt++;
			for (i = 1; i < n - L + 1; i++) {
				cnt++;
				j = i + L - 1;
				if (j == n)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				//cnt++;
				for (k = i; k <= j - 1; k++) {
					
					System.out.println(cnt++ + " :--------------> ");

					
					// q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}

		System.out.println("Matrix :::: ");
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(m[i][j] +"\t");
			}
			System.out.println();
		}
		
		return m[1][n - 1];
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 2,2,3,5 };
		int n = arr.length;
		
		//System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
		
		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr,n));
	}

}

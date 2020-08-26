package com.prog;

public class LongestPalindromeSequence {

	public static void main(String[] args) {

		String str = "ABCDQRDC";

		LongestPalindromeSequence obj = new LongestPalindromeSequence();

		System.out.println("\nLength of Longest palindrome subsequence : " + obj.lps(str));

	}

	public int lps(String seq) {
		int n = seq.length();
		int j, k, i;
		int L[][] = new int[n][n];

		// Strings of 1 character will be palindrome size of 1 
		// starting with upper matrix and all single character falls diagonally and size will be 1
		for (j = 0; j < n; j++)
			L[j][j] = 1;

		for (i = 2; i <= n; i++) {
			for (j = 0; j < n - i + 1; j++) {

				k = j + i - 1;

				if (seq.charAt(j) == seq.charAt(k)) {
					L[j][k] = L[j + 1][k - 1] + 2;

				} else {
					L[j][k] = Math.max(L[j][k - 1], L[j + 1][k]);
				}
			}
		}

		/*System.out.println("Final solution Matrix :::: ");
		for (j = 0; j < n; j++) {
			System.out.print(seq.charAt(j) +" - ");
			for (k = 0; k < n; k++) {
				System.out.print(L[j][k] + "\t");
			}
			System.out.println();
		}*/
		return L[0][n - 1];
	}
}

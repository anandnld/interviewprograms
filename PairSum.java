package com.prog;

import java.util.HashSet;

public class PairSum {

	public static void main(String[] args) {

		int[] val = new int[] { 1, 7, 3, 3, 4, 3, -1, 3, 6, 2, 6, 3, 5, 8, 10  };
		PairSum obj = new PairSum();
		obj.getPairs(val, 9);
	}

	public void getPairs(int[] val, int sum) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i : val) {
			if (set.contains(sum - i)) {
				System.out.println("Pair : (" + (sum - i) + ", " + i + ")");
				set.remove(sum - i); // Removing existing value from set to avoid duplicate pair to print
				count++;
			}
			set.add(i);
		}
		
		System.out.println("\nNo. of pairs : "+count);
	}
}

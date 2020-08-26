package com.prog;

public class MaximumSubarrayUsingDivAndCon {

	public static void main(String[] args) {

		int array[] = new int[] { 2, -4, 1, 9, -6, 7, -3 };
		
		MaximumSubarrayUsingDivAndCon obj = new MaximumSubarrayUsingDivAndCon();
		
		System.out.println("OUTPUT : "+obj.maxSubArray(array, array.length));
	}

	int maxSubArray(int arr[], int n) {
		
		if (n == 1) {
			return arr[0];
		}
		
		int m = n / 2;
		
		int left_MSS = maxSubArray(arr, m);
		int right_MSS = maxSubArray(arr, n - m);
		
		int leftsum = -1, rightsum = -1, sum = 0;
		
		for (int i = m; i < n; i++) {
			sum += arr[i];
			rightsum = Math.max(rightsum, sum);
		}
		sum = 0;
		
		for (int i = (m - 1); i >= 0; i--) {
			sum += arr[i];
			leftsum = Math.max(leftsum, sum);
		}
		
		int ans = Math.max(left_MSS, right_MSS);
		
		return Math.max(ans, leftsum + rightsum);
	}
}

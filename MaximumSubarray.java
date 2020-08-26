package com.prog;

public class MaximumSubarray {

	public static void main(String[] args) {

		int array[] = new int[] {  -1 -2 -3 -4 };

		MaximumSubarray obj = new MaximumSubarray();

		obj.getMaximumSumSubArray(array);
		
		System.out.println("Maxi sum : "+obj.getMaximumSumSubArrayWithoutIndex(array));
	}
	
	
	public int getMaximumSumSubArrayWithoutIndex(int[] array) {

		int sum = 0, finalSum = 0;

		for (int i = 0; i < array.length; i++) {
			
			// +ve numbers
			if (array[i] > 0) {
				sum += array[i];

				// -ve numbers
			} else {
				if (sum > finalSum) {
					finalSum = sum;
				}
				if ((array[i] + sum) <= 0) {
					sum = 0;

				} else {
					sum += array[i];
				}
			}
		}

		// Last compare and sum and finalSum
		if (sum > finalSum) {
			finalSum = sum;
		}
		
		return finalSum;
	}

	public void getMaximumSumSubArray(int[] array) {

		int start = 0, end = 0, sum = 0, finalSum = 0, fStart = 0, fEnd = 0;

		for (int i = 0; i < array.length; i++) {
			
			
			// Avoid initial array with negative
			if (array[i] > 0 && sum == 0) {
				start = end = i;
				sum = array[i];

				// Add current value with sum
			} else if (array[i] > 0) {
				end = i;
				sum += array[i];

			} else {
				// Copy sum to finalSum if sum > finalSum
				if (sum > finalSum) {
					finalSum = sum;
					fStart = start;
					fEnd = end;
				}

				// If sum + current <= 0 then start new sum
				if ((array[i] + sum) <= 0) {
					sum = 0;

				} else {
					sum += array[i];
				}
			}
		}

		// Last compare and sum and finalSum
		if (sum > finalSum) {
			finalSum = sum;
			fStart = start;
			fEnd = end;
		}

		System.out.println("Sum         : " + finalSum);
		System.out.println("Start Index : " + fStart);
		System.out.println("End Index   : " + fEnd);

	}
}

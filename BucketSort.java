package com.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{22,45,12,8,10,6,72,81,33,18,50,14};
		
		System.out.println("Given Array : ");
		for (int i : arr) {
			System.out.print(i+", ");
		}
		new BucketSort().bucketSort(arr);
	}
	
	public int[] bucketSort(int[] arr){
		
		int bSize = 10;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i : arr) {
			if(i > max) max = i;
			if(i < min) min = i;
		}

		ArrayList<Integer>[] bucket = new ArrayList[bSize];
		
		long divider = getDivider(max, bSize);
		
		for (int i : arr) {
			int j = (int) Math.floor(i/divider);
			if(bucket[j] == null || bucket[j].size() == 0){
				bucket[j] = new ArrayList<>();
			}
			bucket[j].add(i);	
		
		}
		
		System.out.println("\n\nSorted Array : ");
		for (List<Integer> list : bucket) {
			if(list != null) {
				Collections.sort(list); // Insertion sort here comes 
				for (Integer integer : list) {
					System.out.print(integer +", ");
				}
			}
		}
		
		return new int[]{1,2,};
	}
	
	public long getDivider(int max, int bSize){
		float divider = (((float)max+1)/(float)bSize);
		int i = (Integer) Math.round(divider);
		if(i < divider) i++;
		return i;
	}
}

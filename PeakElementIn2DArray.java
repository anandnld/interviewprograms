package com.prog;

public class PeakElementIn2DArray {

	public static void main(String[] args) {
		
		int arr[][] = {{ 10, 8, 10, 10 }, 
                { 14, 13, 12, 11 }, 
                { 15, 9, 11, 21 }, 
                { 16, 17, 19, 20 } }; 
		
		PeakElementIn2DArray obj = new PeakElementIn2DArray();
		System.out.println("Peak Element :::: "+obj.findPeak(arr));
		
	}
	
	public int findPeak(int arr[][]){
		return findPeak(arr, arr.length, arr[0].length, arr[0].length/2);
	}
	
	public int findPeak(int arr[][], int row, int col, int mid){
		
		
		
		return 0;
	}
}

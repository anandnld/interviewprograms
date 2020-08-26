package com.prog;

public class FindingMissingNumber {

	public static void main(String[] args) {
		
		int[] arr = new int[]{11,12,13,15,16,17,18,19};
		int sr = 11;
		int er = 19;
		
		FindingMissingNumber obj = new FindingMissingNumber();
		
		System.out.println("Missing number using XOR : "+obj.findMissingNumberUsingXOR(arr, sr, er));
		
	}
	
	
	
	public int findMissingNumberUsingXOR(int[] arr, int sr, int er){
		
		int xor = 0;
		int actualXor = 0;
		
		for(int i=0;i<arr.length;i++){
			xor = xor ^ arr[i];;
		}
		
		for(int i=sr;i<=er;i++){
			actualXor = actualXor ^ i;
		}
		
		return (xor ^ actualXor);
	}
}

package com.prog;

public class BiggerNumber {

	public static void main(String[] args) {
		
		int val = 23478091;
		
		BiggerNumber obj = new BiggerNumber();
		obj.findBiggestNumber(val);
	}

	
	public int findBiggestNumber(int val){
		int[] arr = new int[10];
		while(val >= 1){
			arr[val%10]++;
			val = val/10;
		}
		String str = "";
		for(int i=9;i>=0;i--){
			while(arr[i] > 0){
				str = str + i;
				arr[i]--;
			}
		}
		return Integer.valueOf(str);
	}
}

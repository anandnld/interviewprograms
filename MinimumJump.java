package com.prog;

public class MinimumJump {

	public static void main(String[] args) {
		//int arr[] = new int[] { 1, 2, 5, 1, 8, 2, 6, 3, 6, 8, 9, 1, 2, 3, 7 };
		
		int arr[] = new int[] { 2,1,3,2,3,4,5,1,2,8 };
		//int arr[] = new int[] { 1,0,0,0 };
		//int arr[] = new int[] {1, 2, 5, 1, 8, 2, 6, 7, 6, 8, 9, 3, 2, 1};
		
		System.out.println(new MinimumJump().minimumJump(arr));
		
		System.out.println(new MinimumJump().minJumps(arr));
		
	}
	
	
	public int minJumps(int arr[]) {
		
		if (arr.length <= 1)return 0;

		if (arr[0] == 0) return -1;

		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		for (int i = 1; i < arr.length; i++) {
			
			if (i == arr.length - 1) return jump;

			maxReach = Math.max(maxReach, i + arr[i]);
			step--;

			if (step == 0) {
				
				jump++;
				
				if (i >= maxReach) return -1;
				
				step = maxReach - i;
				System.out.println("MAX ::::: "+arr[maxReach-1] + " ::: STEP ::: "+step);
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//{ 1, 2, 5, 1, 9, 2, 6, 7, 6, 8, 9 };
	//{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	
	
	public int minimumJump(int[] arr) {
		
		if (arr.length <= 1) return 0;

		if (arr[0] == 0) return -1;

		int jump = 1;
		int val = 0;
		int step = arr[0];
		int ii = 0;
		
		for (int i = 1; i < arr.length;i++) {

			if (i >= arr.length - 1) return jump;
			
			if(step > 0) {
				
				if((i+arr[i]) > (ii+val)) {
					ii = i;
					val = arr[i];
					
				}
				step--;
			}

			if(step == 0){
				i = ii;
				if(val == 0) return -1;

				step =  val;
				val = 0;
				ii=0;
				jump++;
				
			}
		}
		return jump;
	}
}

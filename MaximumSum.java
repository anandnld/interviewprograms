package com.prog;

public class MaximumSum {

	public static void main(String[] args) {
		
		int[] array = new int[]{3,7,4,1,6,9,10};
		
		System.out.println("Maximum sum : "+new MaximumSum().getMaxiSum(array));
	}
	
	public int getMaxiSum(int[] arr){
		
		int n = arr.length;
		int incl = arr[0]; 
        int excl = 0; 
        int excl_new; 
        int i; 
  
        for (i = 1; i < n; i++) 
        { 
            excl_new = (incl > excl) ? incl : excl; 
  
            /* current max including i */
            incl = excl + arr[i]; 
            excl = excl_new; 
        } 
  
        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl); 
	}
}

package com.prog;

public class GreatSmall {

	public static void main(String[] args) {
		
		int[] val = new int[]{1,4,7,2,65,89,3,7,2};
		
		for(int i=0;i<val.length-1;i++){
			System.out.print(val[i]);
			if(val[i] > val[i+1])
				System.out.print(">");
			else if(val[i] < val[i+1])
				System.out.print("<");
			else 
				System.out.print("=");
			
			if(i+1 == val.length-1)
				System.out.print(val[i+1]);
		}
		
	}
}

package com.prog;

public class Ballons {

	public static void main(String[] args) {
		
		int[] height = {5, 4, 3, 3, 2, 2, 1, 1, 1};
		
		int count = new Ballons().findArrows(height);
		
		System.out.println(count);
		
	}
	
	public int findArrows(int[] height){
		int count = 0;
		while(true){
			boolean flag = false;
			for(int i=0, max=0;i<height.length;i++){
				if(max == 0 && height[i] > 0) {
					max = height[i] - 1;
					flag = true;
					height[i] = 0;
				}else if(height[i] > 0 && height[i] == max) {
					max--;
					height[i] = 0;
				}
				
			}
			for(int i =0;i<height.length;i++){
				System.out.print(height[i] +", ");
			}
			System.out.println();
			if(flag)
				count++;
			else
				return count;
		}
	}
}

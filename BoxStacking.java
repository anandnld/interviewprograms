package com.prog;

import java.util.Arrays;

public class BoxStacking {

	public static void main(String[] args) {
		
		//h ,w, d
		Box[] arr = new Box[4]; 
		arr[0] = new Box(10, 12, 32); 
		arr[1] = new Box(4, 6, 7); 
        arr[2] = new Box(1, 2, 3); 
        arr[3] = new Box(4, 5, 6); 
        
        BoxStacking obj = new BoxStacking();
        System.out.println("Maximum height : "+obj.getBoxStackingHeight(arr));
	}
	
	public int getBoxStackingHeight(Box list[]){

		int size = list.length;
		int noOfRotations = 3;
		
		Box[] rotation = new Box[size*noOfRotations];
		
		//Creating all sizes of box with given boxes (4 boxes with 3 in each = 12 boxes)
		for(int i = 0;i < size;i++){ 
            
			Box box = list[i];
			
			//rotation[3*i] = new Box(box.h, Math.max(box.w,box.d), Math.min(box.w,box.d)); 
			//rotation[3*i + 1] = new Box(box.w, Math.max(box.h,box.d),  Math.min(box.h,box.d)); 
			//rotation[3*i + 2] = new Box(box.d, Math.max(box.w,box.h),  Math.min(box.w,box.h));
			
			rotation[3*i] = new Box(box.h, box.w, box.d); 
			rotation[3*i + 1] = new Box(box.w, box.d, box.h); 
			rotation[3*i + 2] = new Box(box.d, box.h, box.w);
			
			rotation[3*i].area = rotation[3*i].w * rotation[3*i].d; 
			rotation[3*i+1].area = rotation[3*i+1].w * rotation[3*i+1].d; 
			rotation[3*i+2].area = rotation[3*i+2].w * rotation[3*i+2].d; 
		}
		
		// Sorting which compares area in box objects
		Arrays.sort(rotation);
		
		int maxHeight = -1;
		int[] maxStackHeight = new int[size * noOfRotations]; 

		for(int i = 0; i < (size * noOfRotations); i++){ 
			
			Box box = rotation[i]; 
            int val = 0; 
              
            for(int j = 0; j < i; j++){ 
                Box prevBox = rotation[j]; 
                if(box.w < prevBox.w && box.d < prevBox.d){ 
                    val = Math.max(val, maxStackHeight[j]); 
                } 
            } 
            maxStackHeight[i] = val + box.h;
            maxHeight = Math.max(maxHeight, maxStackHeight[i]);
		}
		
		return maxHeight;
	}
}

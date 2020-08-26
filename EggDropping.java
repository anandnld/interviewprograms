package com.prog;

public class EggDropping {

	public static void main(String[] args) {
		
		int eggs = 2;
		int floors = 10;
			
		EggDropping obj = new EggDropping();
		System.out.println("OUTPUT ::: "+obj.eggDrop(eggs, floors));
			
	}
	
	public int eggDrop(int eggs, int floors) { 
		
		/* A 2D table where entery eggFloor[i][j] will represent minimum 
	       number of trials needed for i eggs and j floors. */
		int eggFloor[][] = new int[eggs+1][floors+1]; 
   
		int res; 
        int i, j, x;
		
        
        
        // We need one trial for one floor and0 trials for 0 floors 
        for (i = 1; i <= eggs; i++) 
        { 
            eggFloor[i][1] = 1; 
            eggFloor[i][0] = 0; 
        } 
           
       // We always need j trials for one egg and j floors. 
        for (j = 1; j <= floors; j++) 
            eggFloor[1][j] = j; 
           
        // Fill rest of the entries in table using optimal substructure 
        // property 
        for (i = 2; i <= eggs; i++) 
        { 
            for (j = 2; j <= floors; j++) 
            { 
                eggFloor[i][j] = Integer.MAX_VALUE; 
                for (x = 1; x <= j; x++) 
                { 
                     res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]); 
                     if (res < eggFloor[i][j]) 
                        eggFloor[i][j] = res; 
                } 
            } 
        } 
           
        // eggFloor[n][k] holds the result 
        return eggFloor[eggs][floors];
    }
}

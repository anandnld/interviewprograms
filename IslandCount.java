package mylearning;

public class IslandCount {

	public static void main(String[] args) {
		
		IslandCount obj = new IslandCount();
		//int[][] A = new int[][] {{0,1,0},{0,0,0},{0,0,1}};
		
		int[][] A = new int[][] {	{1,1,1,1,1},
									{1,0,0,0,1},
									{1,0,1,0,1},
									{1,0,0,0,1},
									{1,1,1,1,1}};
		
		
		System.out.println("TOTAL ::: "+obj.shortestBridge(A));
		
	}
	
	public int shortestBridge(int[][] A) {
        
        int island = 0;
        boolean flag = true;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                
                  /* 
                       1,1 1,2 1,3
                       2,1 2,2 2,3
                       3,1 3,2 3,3    
                  */
            	
                if(A[i][j] == 1) {
                	flag = true;
                    if(i != 0 && A[i-1][j] == 1) continue;         
                    if(j != 0 && A[i][j-1] == 1) continue;         
                    if(i<A.length-1 && A[i+1][j] == 1) continue;
                    if(j<A[0].length-1 && A[i][j+1] == 1) continue;
                    if(i > 0 && j > 0 && A[i-1][j-1] == 1) continue;
                    if(i < A.length-1 && j < A[0].length-1 && A[i+1][j+1] == 1) continue;
                    
                    if(i > 0 && j < A[0].length-1 && A[i-1][j+1] == 1) continue;
                    if(i < A.length-1 && j > 0 && A[i+1][j-1] == 1) continue;
                    flag=false;
                    island++;
                }
            }
        }
        if(flag) island++;
        return island;
    }
}

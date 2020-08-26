package mylearning;

public class CountIsland {

	public static void main(String[] args) {
		
		char grid[][] = new char[][]  {{'1','1','1'},
									   {'0','0','0'},
									   {'1','1','1'}};
		
		CountIsland obj = new CountIsland();
		int count = obj.getNoOfIslands(grid);
		System.out.println("No. of Islands : "+count);
		
	}
	
	public int getNoOfIslands(char[][] grid) {
		
		int islandCount = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				
				if(grid[i][j] == '1' && islandCount == 0) islandCount++;
				
				if(grid[i][j] == '1' && (j+1)<grid[0].length && grid[i][j+1] == '1') continue; 
				
				if(grid[i][j] == '1' && (i+1)<grid.length && grid[i+1][j] == '1') continue; 
				
				if(grid[i][j] == '1' && i > 0 && grid[i-1][j] == '1') continue;
				
				if(grid[i][j] == '1' && j > 0 && grid[i][j-1] == '1') continue;
				
				islandCount++;
			}
		}
		
		return islandCount;
		
	}
}

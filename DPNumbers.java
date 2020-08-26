package mylearning;

public class DPNumbers {

	int dp[] = new int[1000];
	public static void main(String[] args) {
		
		
		int n = 6;
		int arr[] = {1,3,5};
		DPNumbers obj = new DPNumbers();
		int count = obj.getNoOfWays(n, arr);
		System.out.println(count);
		
		for(int i=0;i<n;i++) {
			System.out.println(obj.dp[i]);
		}
	}
	
	public int getNoOfWays(int n, int arr[]) {
		
		if (n < 0) return 0; 
		  if (n== 0) return 1; 
		  
		  if (dp[n]!=0) return dp[n]; 
		
		  return dp[n] = getNoOfWays(n-arr[0], arr) + getNoOfWays(n-arr[1], arr) + getNoOfWays(n-arr[2], arr);
		  
	}
}

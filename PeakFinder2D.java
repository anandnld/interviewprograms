package com.prog;

class PeakFinder2D {
	
	
	public static void main(String args[])
	{
		
		int[][] arr = { 	{ 12, 2 }, 
				{ 11, 9 }, 
				{ 10, 6 }, 
				{ 7, 5 } };
		
		int n=arr.length;
		int m=arr[0].length;
		
		int low=0;
		int high=m;
		int mid=low+(high-low)/2;
		while(low<=high)
		{
			int max=0;
			int index=0;
			for(int i=0;i<n;i++)
			{
				if(arr[i][mid]>max)
				{
					max=arr[i][mid];
					index=i;
				}
			}
			if(mid-1!=-1&&arr[index][mid]<arr[index][mid-1])
				high=mid-1;
		    else if(mid+1!=m&&arr[index][mid]<arr[index][mid+1])
		    	low=mid+1;
		    else
		    {
		    	System.out.println(arr[index][mid]);
		    	break;
		    }
		    mid=low+(high-low)/2;
 
		}
 
 
	}
	
	
	/*public static void main(String[] args) {
		int[][] A = { 	{ 12, 2 }, 
						{ 11, 9 }, 
						{ 10, 6 }, 
						{ 7, 5 } };
		
		int[] peak = findPeak(A, A.length, A[0].length);
		
		System.out.println("The peak is " + A[peak[0]][peak[1]]);
	}*/

	private static int midCol;

	private static int[] findPeak(int[][] a, int i, int j) {
		if (j == 1) {
			int row = findMax(a, i, 0);
			return new int[] { row, 0 };
		} else {
			midCol = j / 2;
			return findPeakMach(a, i, j, midCol);
		}
	}

	private static int[] findPeakMach(int[][] a, int i, int j, int mid) {
		int row = findMax(a, i, mid);
		if ((mid == 0 && a[row][mid] >= a[row][mid + 1]) || (mid == j - 1 && a[row][mid] >= a[row][mid - 1])
				|| (a[row][mid] >= a[row][mid - 1] && a[row][mid] >= a[row][mid + 1])) {
			return new int[] { row, mid };
		} else if (a[row][mid] < a[row][mid - 1]) {
			midCol = midCol / 2;
			return findPeakMach(a, i, j, mid - midCol);
		} else {
			midCol = midCol / 2;
			return findPeakMach(a, i, j, mid + midCol);
		}
	}

	private static int findMax(int[][] a, int i, int mid) {
		int max = a[0][mid];
		int row = 0;
		for (int k = 0; k < i; k++) {
			if (a[k][mid] > max) {
				max = a[k][mid];
				row = k;
			}
		}
		return row;
	}
}

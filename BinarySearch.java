package mylearning;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = new int[] {1,3,5,7,8,9,10,12,23,56,57,78,89,99,100,123,134,156,178,179,184,193,201,204,206,212,215,220,225,230,236,239,240,245,247,249,250,252,255,257,259,260,263,269,270,276};
		//						 0 1 2 3 4 5 6  7  8  9  10 11 12 13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29 30  31   32  33  34  35  36  37  38  39  40  41  42  43  44  45			
		
		//int[] array = new int[] {2,5,8,12,16,23,38,56,72,91};
		
		
		int val = 276;
		
		int index = new BinarySearch().binarySort(array, val);
		
		if(index > -1) {
			System.out.println("Value found @ index : "+index + " : "+array[index]);
		}else {
			System.out.println("Given value not found in array !!!");
		}
		
		System.out.println(new BinarySearch().binarySearch(array, 0, array.length - 1, val)); 
		
		System.out.println(" OWN ::: "+new BinarySearch().binarySearchRecursion(array, 0, array.length - 1, val)); 
		
	}
	
	
	
	
	public int binarySearchRecursion(int[] array, int l, int r, int val) {
		
		if(l<=r) {
			int mid = (r-l)/2 + r;
			
			if(array[mid] == val) return mid;
			
			if(array[mid] == val) return mid;
			if(array[mid] < val) l = mid+1;
			else if(array[mid] > val) r = mid-1;
			
			return binarySearchRecursion(array, l, r, val);
		}
		return -1;
		
	}
	
	
	
	
	
	
	public int binarySearch(int arr[], int l, int r, int x) 
    { 
		System.out.println("Reached :: ");
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
	
	public int binarySort(int[] array, int val) {
		int index = -1;
		int first=0, middle=(array.length)/2, last = array.length-1;
		int itr = 0;
		
		while(last >= first) {
			System.out.println("ITR : "+ ++itr);
			
			if(val == array[middle]) return middle;
			if(val == array[first]) return first;
			if(val == array[last]) return last;
			
			if(val > array[middle]) first = middle+1;
			
			else last = middle-1;
			
   			middle = ((last - first)/2) + first;
		}
		return index;
	}
}

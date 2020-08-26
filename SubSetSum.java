package mylearning;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

	// DP storing values in list to match with other value and to get the sum set.
	List<Integer> lSet = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		int set[] = {3, 34, 4, 12, 5, 2, 8, 1,2,7}; 
        int sum = 9; 
        
        SubSetSum obj = new SubSetSum();
        int noOfSubsetSums = obj.getSubsets(set, sum, 0);
        
        System.out.println("No. of subset sum : "+noOfSubsetSums);
        
        
	}
	
	public Integer getSubsets(int[] set, int sum, int i) {
		
		if(i >= set.length) return 0;
		
		int diff = sum-set[i];
		if(lSet.contains(diff)) {
			lSet.remove(lSet.indexOf(diff));
			//System.out.println("Matches ::: "+ diff + ": "+set[i]);
			return getSubsets(set, sum, (i+1)) + 1; 
		}else {
			lSet.add(set[i]);
			return getSubsets(set, sum, (i+1)); 
		}
		
		
	}
}

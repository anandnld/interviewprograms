package mylearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySubset {

	static int qq = 0;
	
	public static void main(String[] args) {
		
		int[] num = new int[]{1,2,3};
		
		List<List<Integer>> list = new ArraySubset().subsets(num);
		
		List<List<Integer>> list1 = new ArraySubset().subsets_bfs(num);
		
		List<Integer> tmp = new ArrayList<Integer>();
		List<List<Integer>> ls = new ArrayList<>();
		
		new ArraySubset().subsets_dfs(num,0,tmp, ls);
		
		
		System.out.println("DFS length :"+qq);
		
		System.out.println(list);
		System.out.println(list1);
		
		System.out.println(ls);
		

		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<>();
        
		int all_set = 1 << nums.length;
		
		//System.out.print("QWER::: "+all_set);
        
		int jj =0;
		
		for(int i = 0; i < all_set-1; i++){

			ArrayList<Integer> item = new ArrayList<Integer>();
            
			for(int j = 0; j < nums.length; j++){
            
				//System.out.println(jj++);
				jj++;
				
				if((i& (1 << j))==0){
					//System.out.print((i& (1 << j)) +":"+j +" --- ");
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
		System.out.println("BIT JJ : "+jj);
		return result;
    }
	
	public List<List<Integer>> subsets_bfs(int[] nums) {

		List<List<Integer>> fin = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return fin;
		
		fin.add(new ArrayList<>());
		int jj = 0;
		int size = 0;
		
		for (int n : nums) {
			size = fin.size();
			for (int m = 0; m < size; m++) {
				jj++;
				List set = new ArrayList<>(fin.get(m));
				set.add(n);
				fin.add(set);
			}
		}
		
		System.out.println("BFS JJ : " + jj);
		return fin;
	}
	
	private void subsets_dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> fin){
		qq++;
	    //System.out.println(temp);
	    fin.add(new ArrayList<>(temp));
	    for(int i = index; i<nums.length; i++){
	        temp.add(nums[i]);
	        //System.out.println(temp);
	        subsets_dfs(nums, i+1, temp, fin);
	        temp.remove(temp.size()-1);
	    }
	}
}

package mylearning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyPro {

	// {1,2,4,5,7,1,2,3,7,8,1}
	
	// {2,2,3,4,5,7,7,8}
	
	// {3,4,5,8,2,2,7,7,1,1,1}
	
	public static void main(String[] args) {
		
		int arr[] = new int[] {8,2,4,5,7,2,3,7};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
		
		arr = new int[arr.length];
		
		Iterator<Integer> itr = (Iterator<Integer>) map.keySet();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println("OUTPUT: :::: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] +", ");
		}
	}

}

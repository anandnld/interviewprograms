package mylearning;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

 

public class StoneWeight {

	class Reverse implements Comparator<Integer>
	{
		public int compare(Integer arg0, Integer arg1) 
		{
			return arg1 - arg0;
		}
	}
	
	public static void main(String[] args) {
		
		StoneWeight obj = new StoneWeight();
		int[] val = new int[] {2,7,4,1,8,1};
		int weight = obj.lastStoneWeight(val);
		System.out.println("WEIGHT : "+weight);
		
	}
	
	public int lastStoneWeight(int[] stones) {
        int weight = 0;
        if(stones == null || stones.length == 0) return weight;
        if(stones.length == 1) return stones[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1) {
        	
        	int tmp = pq.remove();
            
        	if(pq.peek() > tmp) weight = pq.remove() - tmp;
        	else
        	weight = tmp - pq.remove();
            if(weight != 0) pq.add(weight);
            
        }
        if(pq.size() > 0) return pq.remove();
        return weight;
     }
}

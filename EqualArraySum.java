package mylearning;

import java.util.ArrayList;
import java.util.List;

public class EqualArraySum {

	public static void main(String[] args) {
		
	}
	
	public boolean getEqualArraySum(int[] array){
		
		List<Integer[]> list = new ArrayList<Integer[]>();

		if(array == null || array.length <= 0) return false;
		
		int sum = 0;
		for (int val : array) {
			sum = sum + val;
		}
		
		if((sum % 2) > 0) {
			System.out.println("Equal sum array not possible !!!");
			return false;
		}
		
		
		
		return true;
	}
}

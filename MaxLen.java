package mylearning;

import java.util.HashSet;

public class MaxLen {

	public static void main(String[] args) {
		
		//ORIGINAL STRING    ::: suncityapartments
		//LONGEST SUB STRING ::: suncityap
		
		String str = "suncityapartments";
		
		HashSet<Character> set = new HashSet<Character>();
		
		int j =0;
		int maxLength = 0;
		int i=0;
		
		while(j<str.length()) {
			//System.out.println("JJJ : "+set);
			if(!set.contains(str.charAt(j))) {
				set.add(str.charAt(j));
				j++;
				//System.out.println("j-i is "+ (j-i));
				System.out.println("set.size()-1 is "+ (set.size()));

				//maxLength = Math.max(maxLength, set.size()-1);
				//maxLength = Math.max(maxLength, set.size()-1);
				maxLength = Math.max(maxLength, set.size());


			}else {
				set.remove(str.charAt(j));
				System.out.println("i is "+ i);
				//i++;
			}
		}
		System.out.println("Max length : "+maxLength);
	}
}

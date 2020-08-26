package mylearning;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public static void main(String[] args) {
		
		String input = "++---++--++++";
		
		FlipGame obj = new FlipGame();
		List<String> output = obj.generatePossibleNextMoves(input);
		System.out.println("OUTPUT: "+output);
		
		
	}
	
	public List<String> generatePossibleNextMoves(String input){
		List<String> list =  new ArrayList<>();
		
		for(int i=0;i<input.length()-1;i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				String change = "++";
				if(input.charAt(i) == '+') {
					change = "--";
				}
				list.add((input.substring(0, i) + change + input.substring(i+1, input.length()-1)));
				}
			}
		
		
		return list;
	}
}

package com.prog;

public class ReverseLineByWords {

	public static void main(String[] args) {
		
		String str = "Hello Java Discover";
		
		String finalStr = new ReverseLineByWords().reverseLine(str);
		
		System.out.println(finalStr);
		
	}
	
	public String reverseLine(String str){
		String word = "";
		int i = 0;
		for(;i<str.length();i++){
			if(str.charAt(i) == ' ') {
				word = word + " ";
				break;
			}else{
				word = word + str.charAt(i);
			}
		}

		if(i < str.length()) 
			return reverseLine(str.substring(i+1)) + word;
		
		return (word + " ");
	}
}

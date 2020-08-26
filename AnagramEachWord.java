package mylearning;

import java.util.Arrays;

public class AnagramEachWord {

	public static void main(String[] args) {
		
		String s1 = "LISTEN";
		String s2 = "SILENT";
		AnagramEachWord obj = new AnagramEachWord();
		
		boolean result = obj.isBothWordsAreAnagramByEach(s1,s2);
		if(result) {
			System.out.println(String.format("Both %s and %s are Anagram each other",s1,s2));
		}else {
			System.out.println(String.format("Both %s and %s are NOT Anagram each other",s1,s2));
		}
	}
	
	public boolean isBothWordsAreAnagramByEach(String s1, String s2) {
		
		if(s1 == null || s2 == null || (s1.length() != s2.length())) return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		/*
		for(int i=0;i<s1.length();i++) {
			for(int j=i+1;j<s1.length();j++) {
				if(c1[i] > c1[j]) {
					char t = c1[i];
					c1[i] = c1[j];
					c1[j] = t;
				}
			}
		}
		
		for(int i=0;i<s2.length();i++) {
			for(int j=i+1;j<s2.length();j++) {
				if(c2[i] > c2[j]) {
					char t = c2[i];
					c2[i] = c2[j];
					c2[j] = t;
				}
			}
		}
		*/
		
		System.out.println(String.valueOf(c1));
		System.out.println(String.valueOf(c2));
		
		if(String.valueOf(c1).equals(String.valueOf(c2))) return true;		
		return false;
	}
}

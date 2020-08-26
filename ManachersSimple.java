package com.prog;

import java.util.Arrays;

public class ManachersSimple {
    
	
	public static void main(String[] args) {
		String str = findLongestPalindrome("qqw");
		
		System.out.println(str);
	}
	
    public static String findLongestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";
        
        char[] s2 = addBoundaries(s.toCharArray());
        System.out.print("VAL : ");
        for (char c : s2) {
			System.out.print(c);
		}
        System.out.println("\n");
        int cnt = 0;
        int[] p = new int[s2.length]; 
        //int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i<s2.length; i++) {
        	cnt++;

        	if(s2[i] == '|') p[i] = 0;
        	else{
        		m = i-1; n = i+1;
        		while (m>=0 && n<s2.length && s2[m]==s2[n]) {
        			cnt++;
                    p[i]++; m--; n++;
                }
        	}
        }
        System.out.println("CNT ::: "+cnt);
        int len = 0; int c = 0;
        for (int i = 1; i<s2.length; i++) {
            if (len<p[i]) {
                len = p[i]; c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
        return String.valueOf(removeBoundaries(ss));
    }
 
    private static char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }    
}
package com.prog;

public class Manacher {
    private int[]  p;  // p[i] = length of longest palindromic substring of t, centered at i
    private String s;  // original string
    private char[] t;  // transformed string

    
    public Manacher(String s, String vaal) {
        this.s = s;
        preprocess();
        p = new int[t.length];
        
        int center = 0, right = 0;
        
        for (int i = 1; i < t.length-1; i++) {
            
        	int mirror = 2*center - i;
        	
        	//System.out.println(i + " : "+mirror + " : " + center + " : "+right + " : ");	

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
            		p[i]++;
            }
            
            System.out.println(p[i]);

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }
    
    
    public Manacher(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];
        
        int center = 0, right = 0;
        
        System.out.println("Transformed string L: "+t.toString());
        
        for (int pp : p) {
			System.out.println("PPP: "+pp);
		}
        System.out.println();
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;
            
            System.out.println("CEN ::: "+t[i] + " : "+ center +" : "+right + " : "+mirror);

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
                System.out.println("INSIDE IF : ::::::::::::::::::::::::::: " + (right-i) + " : "+ p[mirror]);
           
            }
    		System.out.println("QWERTTTT ::: "+ (t[i + (1 + p[i])]) + " : "+(t[i - (1 + p[i])]) + " : "+p[i]);

            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
            		p[i]++;
            		System.out.println("reached::::::::");
            	}

 
            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

        }
        for (int pp : p) {
			System.out.println("PPP: "+pp);
		}
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    private void preprocess() {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }

    
    // longest palindromic substring
    public String longestPalindromicSubstring() {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i]	 > length) {
                length = p[i];
                center = i;
            }
        }
        System.out.println("LENGTH ::::: "+length + " : "+center);

        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    // longest palindromic substring centered at index i/2
    public void  printMy() {
    	
    	for (int i = 0; i < 2*s.length(); i++) {
    		//System.out.println(i +  ": " + manacher.longestPalindromicSubstring(i));
    	
	        int length = p[i + 2];
	        int center = i + 2;
	        String str =  s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
	        System.out.println("FINAL STR ::: "+str);
    	}
    }

    // test client
    public static void main(String[] args) {
        String s = "mamrrm";
        Manacher manacher = new Manacher(s,"");
       // System.out.println("LP :: "+manacher.longestPalindromicSubstring());
        
        
        manacher.printMy();
        
        
         
    }
}


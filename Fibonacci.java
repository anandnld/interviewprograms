package com.prog;

import java.util.HashMap;

public class Fibonacci {
	
	static int i = 0;
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		int n = 5;
		int val = fibo(n);
		System.out.println("No. of recursive calls : "+i);
		System.out.println(n +"th Fibonacci number : "+val);
		
	}
	
	public static int fibo(int n) {
		
		if(map.containsKey(n)) 
			return map.get(n);
		
		System.out.println("CALL ::: "+ (++i) + " - n: "+n);
		if(n<=2) {
			map.put(n, 1);
			return 1;
		}
		else {
			int f = fibo(n-1) + fibo(n-2);
			map.put(n, f);
			return f;
		}
	}
}

package com.prog;

import java.util.TreeSet;

public class Permutation {

	public static void main(String[] args) {
		TreeSet<String> combination = new TreeSet<String>();
		System.out.println("Hwllo !!! ");
		String str = "cab";
		permutation("", str, combination);
		printAllCombination(combination);
	}

	private static void permutation(String prefix, String str, TreeSet<String> combination) {
		System.out.println(prefix + " : "+str);
		int len = str.length();
		if (len == 0) {
			combination.add(prefix);
		} else {
			for (int i = 0; i < len; i++) {

				String p = prefix + str.charAt(i);
				String s = str.substring(0, i) + str.substring(i + 1, len);
				//String s = str.substring(i + 1, len);
				permutation(p, s, combination);
			}
		}
	}

	private static void printAllCombination(TreeSet<String> combination) {
		int index = 0;
		for (String string : combination) {
			System.out.println(++index + "\t : '" + string+"'");
		}
	}
}

package com.prog;

public class CharacterOccurrance {

	public static void main(String[] args) {
		String str = "Java Discover~";

		CharacterOccurrance obj = new CharacterOccurrance();
		int[] occurrance = obj.findCharOccurrance(str);
		obj.printOccurrance(occurrance);
	}

	public int[] findCharOccurrance(String str) {
		int[] occurrance = new int[95];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			occurrance[index - 32]++;
		}
		return occurrance;
	}

	public void printOccurrance(int[] occurrance) {
		System.out.println("Character : Occurrance");
		for (int i = 0; i < occurrance.length; i++) {
			if (occurrance[i] > 0) {
				char ch = (char) (i + 32);
				System.out.println(ch + " \t  : " + occurrance[i]);
			}
		}
	}
}

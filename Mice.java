package com.prog;

import java.util.ArrayList;
import java.util.Collections;

public class Mice {

	public int assignHole(ArrayList<Integer> mice, ArrayList<Integer> holes) {
		if (mice.size() != holes.size())
			return -1;

		/* Sort the lists */
		Collections.sort(mice);
		Collections.sort(holes);
		
		System.out.println(mice);
		System.out.println(holes);
		
		int size = mice.size();

		/* finding max difference between ith mice and hole */
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (max < Math.abs(mice.get(i) - holes.get(i))) {
				max = Math.abs(mice.get(i) - holes.get(i));
			}
			System.out.println(max);
		}
		return Math.abs(max);
	}

	/* Driver Function to test other functions */
	public static void main(String[] args) {
		Mice gfg = new Mice();
		ArrayList<Integer> mice = new ArrayList<Integer>();
		mice.add(4);
		mice.add(-4);
		mice.add(2);
		ArrayList<Integer> holes = new ArrayList<Integer>();
		holes.add(4);
		holes.add(0);
		holes.add(5);
		System.out.println("The last mouse gets into " + "the hole in time: " + gfg.assignHole(mice, holes));
	}
}

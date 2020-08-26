package mylearning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FruitsCombination {

	public static void main(String[] args) {

		int amount = 4;

		int[] price = { 1, 2, 3, 4};
		int[] quantity = { 1, 2, 3, 4};

		int[] bag = new int[] { 0, 0, 0, 0};

		Set<String> set = new HashSet<>();
		new FruitsCombination().getCombinations(price, quantity, amount, bag, set);

		System.out.println("Combination : " + set.size());

	}

	public void getCombinations(int[] price, int[] quantity, int amount, int[] bag, Set<String> set) {

		int tot = 0;
		for (int i = 0; i < bag.length; i++) {
			tot = tot + bag[i] * price[i];
		}
		if (tot == amount) {
			System.out.println(Arrays.toString(bag));
			set.add(Arrays.toString(bag));
		}
		for (int i = 0; i < price.length && bag[i] < quantity[i]; i++) {

			bag[i]++;
			getCombinations(price, quantity, amount, bag, set);
			bag[i]--;
		}
	}

}

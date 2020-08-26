package com.prog;

public class CoinChange {

	public static void main(String[] args) {
		
		int amount = 10;
		
		int coins[] = new int[] {5,10};
		
		CoinChange obj = new CoinChange();
		
		int noOfCoinChanges = obj.coinCombination(amount, coins);
		System.out.println("No. of coin Changes : "+noOfCoinChanges);
	}
	
	public int coinCombination(int amount, int[] coins) {
		
		int arr[] = new int[amount+1];
		
		arr[0] = 1;
		
		for(int j = 0;j<coins.length;j++) {
			
			int coin = coins[j];
			
			for(int i=1;i<amount+1;i++) {
				if(i>=coin)
					arr[i] = arr[i] + arr[i-coin];
			}
			
			System.out.print("\nUsing coin : "+coin +" -> ");
			
			for(int i=0;i<amount+1;i++) {
				System.out.print(arr[i]+", ");
			}
		}
		System.out.println();
		return arr[amount];
	}
}

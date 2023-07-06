package main.java.com.saranya.binaryTrees;

public class BuyAndSellStock {

	public static void main(String[] args) {
		BestTimeBuySellStock();
	}

	private static void BestTimeBuySellStock() {
		int prices[] = {7,1,5,6,0};
		solution1(prices);
		solution2(prices);
	}

	private static void solution2(int[] prices) {
		int buy = prices[0]; 
		int profit = 0;
		for(int i=1; i<prices.length; i++) {
			if(buy >  prices[i]) {
				buy = prices[i];
			} else if (prices[i]-buy > profit) {
				profit = prices[i] - buy;
			}
		}
		System.out.println("Maximum Profit from Solution 2 is "+profit);
	}

	private static void solution1(int[] prices) {
		int buy = prices[0]; 
		int profit = 0;
		for(int i=1; i<prices.length; i++) {
			int currentProfit = prices[i] - buy;
			if(currentProfit > profit) {
				profit = currentProfit;
			}
			buy = Math.min(buy, prices[i]);
		}
		System.out.println("Maximum Profit from Solution 1 is "+profit);
	}
}

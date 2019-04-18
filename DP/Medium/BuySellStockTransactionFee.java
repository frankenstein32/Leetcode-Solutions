import java.util.*;

public class BuySellStockTransactionFee{

	public static void main(String[] args){

		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		System.out.println(maxProfit(prices, fee));	
	}

	public static int maxProfit(int[] prices, int fee){

		if(prices.length < 2){
			return 0;
		}

		int profit = 0;
		int min = prices[0];

		for(int i = 0;i < prices.length;i++){

			if(prices[i] < min){
				min = prices[i];
			}else if(prices[i] > min + fee){

				profit += prices[i] - min - fee;
				min = prices[i] - min;
			}
		}

		return profit;
	}

	
	
}
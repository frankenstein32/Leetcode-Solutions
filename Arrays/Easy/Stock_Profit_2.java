import java.util.*;

public class Stock_Profit_2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(maxProfit(arr));
		System.out.println(profit_eff(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

 	public static int maxProfit(int[] prices){

 		return profit(prices,0);
 	}

	public static int profit(int[] prices,int s){

		if(s >= prices.length){
			return 0;
		}

		int max = 0;
		for(int start = s; start < prices.length;start++){
			int maxProfit = 0;

			for(int i = start + 1;i < prices.length;i++){

				if(prices[i] > prices[start]){
					int profit = profit(prices,i + 1) + prices[i] - prices[start];

					if(profit > maxProfit){
						maxProfit = profit;
					}
				}	
			}
			if(max < maxProfit ){
				max = maxProfit;
			}	
		}

		return max;
		
	}

	public static int profit_eff(int[] prices){

		int valley = prices[0];
		int peak = prices[0];
		int profit = 0;
		int i = 0;

		while(i < prices.length - 1){

			while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
				i++;
			}

			valley = prices[i];
			while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
				i++;
			}
			peak = prices[i];
			profit += peak - valley;
		}

		return profit;
 		
		
	}
	public static int profit_eff2(int[] prices){

		int profit = 0;
		int i = 1;

		while(i < prices.length - 1){

			if(prices[i] > prices[i - 1]){
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
 		
		
	}

}
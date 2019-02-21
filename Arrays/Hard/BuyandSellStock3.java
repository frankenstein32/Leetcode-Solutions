import java.util.*;

public class BuyandSellStock3{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3,3,5,0,0,3,1,4};
		int target = 2;
		System.out.println(maxProfit(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maxProfit(int[] prices){

	 	if(prices == null || prices.length < 2){
	 		return 0;
	 	}

	 	int[] Profit_left = new int[prices.length];
	 	int[] Profit_right = new int[prices.length];

	 	int min = prices[0];
	 	for(int i = 1; i < prices.length;i++){

	 		Profit_left[i] = Math.max(prices[i] - min,Profit_left[i - 1]);
	 		min = Math.min(prices[i],min);
	 	}

	 	int max = prices[prices.length - 1];
	 	for(int i = prices.length - 2;i >= 0;i--){

	 		Profit_right[i] = Math.max(max - prices[i],Profit_right[i + 1]);
	 		max = Math.max(prices[i],max);
	 	}

	 	int res = 0;
	 	for(int i = 0;i < prices.length;i++){

	 		res = Math.max(res,Profit_right[i] + Profit_left[i]);
	 	}

	 	return res;
	 }

	
}
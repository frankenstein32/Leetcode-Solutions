import java.util.*;

public class Stock{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(profit(arr));
		System.out.println(profit_eff(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int profit(int[] prices){

		int[] min = new int[prices.length];
		int[] max = new int[prices.length];

		min[0] = prices[0];
		for(int i = 1;i < min.length;i++){

			min[i] = Math.min(min[i - 1],prices[i]);
		}

		max[max.length - 1] = prices[prices.length - 1];

		for(int i = prices.length - 2;i >= 0;i--){

			max[i] = Math.max(prices[i],max[i + 1]);
		}

		int sum = Integer.MIN_VALUE;
		for(int i = 0;i < prices.length;i++){

			sum = Math.max(sum,max[i] - min[i]);
		}

		return sum;
 		
		
	}

	public static int profit_eff(int[] prices){

		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for(int i = 0; i < prices.length;i++){

			if(prices[i] < minPrice){
				minPrice = prices[i];
			}else if(prices[i] - minPrice > maxProfit){

				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;
 		
		
	}

}
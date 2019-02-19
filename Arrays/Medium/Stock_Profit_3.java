import java.util.*;

public class Stock_Profit_3{
	
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


	public static int profit_eff2(int[] prices, int fee){

		int n = prices.length;

		if(n < 2)
			return 0;

		int ans = 0
		int minimum = prices[0];

		for(int price : prices){

			if(price < minimum){
				minimum = price;
			}else if(price > minimum + fee){

				ans += price - minimum - fee;
				minimum = price - fee;
			}
		}

		return ans;
 		
		
	}

}
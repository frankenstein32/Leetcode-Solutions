import java.util.*;

public class IntegerBreak{

	public static void main(String[] args){

		int n = 5;
		System.out.println(Break(n));
		
	}

	public static int Break(int n){

		System.out.println(helperBU_EFF(n));
		System.out.println(helperBU(n));
		System.out.println(helperTD(n - 1, n, new int[n][n + 1	]));
		return helper(n - 1, n, "");
	}

	public static int helper(int weight, int capacity, String ans){

		if(capacity == 0){
			return 1;
		}

		if(weight == 0){
			
			return 1;
		}
		
		int inc = 0, exc = 0;
		if(capacity >= weight){
			inc = helper(weight, capacity - weight, ans + weight + " ") * weight;
		}

		exc = helper(weight - 1, capacity,ans );

		return Math.max(inc, exc);
	}

	public static int helperTD(int weight, int capacity,int[][] strg){


		if(capacity == 0){
			return 1;
		}

		if(weight == 0){
			
			return 1;
		}

		if(strg[weight][capacity] != 0){
			return strg[weight][capacity];
		}
		
		int inc = 0, exc = 0;
		if(capacity >= weight){
			inc = helperTD(weight, capacity - weight,strg) * weight;
		}

		exc = helperTD(weight - 1, capacity ,strg);

		strg[weight][capacity] = Math.max(inc, exc);

		return Math.max(inc, exc);
	}

	public static int helperBU(int n){

		int[][] strg = new int[n][n + 1];


		for(int weight = 0;weight < n; weight++){
			for(int capacity = 0;capacity <= n;capacity++){

				if(capacity == 0){
					strg[weight][capacity] = 1;
					continue;
				}

				if(weight == 0){
					strg[weight][capacity] = 0;
					continue;
				}

				int inc = 0, exc = 0;
				if(capacity >= weight){

					inc = strg[weight][capacity - weight] * weight;
				}

				exc = strg[weight - 1][capacity];

				strg[weight][capacity] = Math.max(inc, exc);
			}
		}

		display(strg);
		return strg[n - 1][n];
	}

	public static int helperBU_EFF(int n){

		int[] strg = new int[n + 1];


		for(int weight = 0;weight < n; weight++){
			for(int capacity = 0;capacity <= n;capacity++){

				if(capacity == 0){
					strg[capacity] = 1;
					continue;
				}

				if(weight == 0){
					strg[capacity] = 0;
					continue;
				}

				int inc = 0, exc = 0;
				if(capacity >= weight){

					inc = strg[capacity - weight] * weight;
				}

				exc = strg[capacity];

				strg[capacity] = Math.max(inc, exc);
			}
		}

		display(strg);
		return strg[n];
	}


	public static void display(int[][] strg){


		for(int[] arr : strg){

			for(int val : arr){
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

	public static void display(int[] arr){

			for(int val : arr){
				System.out.print(val+" ");
			}
			System.out.println();
	}
}
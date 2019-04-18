import java.util.*;

public class PerfectSquare{

	public static void main(String[] args){

		int n = 13;
		System.out.println(numSquares(n));
		
	}

	public static int numSquares(int n){

		int[] strg = new int[n + 1];
		Arrays.fill(strg, -1);
		System.out.println(helperBU(n));
		System.out.println(helperTD(n, strg));
		return helper(n);
	}

	public static int helper(int n){

		if(n == 0){
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		for(int i = 1; i * i <= n;i++){

			if(n - i * i >= 0){
				ans = Math.min(ans, helper(n - 	(i * i)));
			}

		}

		return ans + 1;
	}

	public static int helperTD(int n, int[] strg){

		if(n == 0){
			return 0;
		}

		if(strg[n] != -1){
			return strg[n];
		}

		int ans = Integer.MAX_VALUE;
		for(int i = 1; i * i <= n;i++){

			if(n - i * i >= 0){
				ans = Math.min(ans, helperTD(n - 	(i * i), strg));
			}

		}

		strg[n] = ans + 1;

		return ans + 1;
	}

	public static int helperBU(int n){

		int[] strg = new int[n + 1];

		for(int i = 1;i <= n;i++){

			if(i == 1){
				strg[i] = 1;
				continue;
			}

			int ans = Integer.MAX_VALUE;
			for(int num = 1; num * num <= i;num++){

				ans = Math.min(ans, strg[i - num * num]);
			}

			strg[i] = ans + 1;

		}

		return strg[n];
	}

	

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

}
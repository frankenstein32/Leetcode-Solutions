import java.util.*;

public class ClimbingStairs{

	public static void main(String[] args){

		System.out.println(climb(4));
		
	}

	public static int climb(int n){

		System.out.println(helperBU(n));
		// System.out.println(zhelperTD(n,0,new int[n]));
		return helper(n, 0);
	}

	public static int helper(int n, int cnt){


		if(cnt == n){
			return 0;
		}

		if(cnt > n){

			return -1;
		}

		int step1 = helper(n, cnt + 1);
		if(step1 <= 0){

			step1 += 1;
		}

		int step2 = helper(n, cnt + 2);
		if(step2 <= 0){
			step2 += 1;
		}

		return step1 + step2;
	}

	public static int helperTD(int n, int cnt, int[] strg){


		if(cnt == n){
			return 0;
		}

		if(cnt > n){

			return -1;
		}


		if(strg[cnt] != 0){
			return strg[cnt];
		}

		int step1 = helperTD(n, cnt + 1, strg);
		if(step1 <= 0){

			step1 += 1;
		}

		int step2 = helperTD(n, cnt + 2, strg);
		if(step2 <= 0){
			step2 += 1;
		}

		strg[cnt] = step1 + step2;

		return strg[cnt];

	}

	public static int helperBU(int n){

		int[] strg = new int[n + 2];
		strg[n + 1] = -1;
		strg[n] = 0;

		for(int i = n - 1;i >= 0;i--){

			int step1 = strg[i + 1];
			int step2 = strg[i + 2];
			if(step1 <= 0){
				step1 += 1; 
			}

			if(step2 <= 0){
				step2 += 1;
			}

			strg[i] = step1 + step2;
		}

		return strg[0];


	}
}
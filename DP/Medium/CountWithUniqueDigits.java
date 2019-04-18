import java.util.*;

public class CountWithUniqueDigits{

	public static void main(String[] args){

		int n = 3;
		System.out.println(count(n));
		
	}

	public static int count(int n){

		if(n > 10){
			return 0;
		}

		int ans = 0;

		int[] strg = new int[n + 1];
		for(int i = 2;i <= n;i++){

			ans += helperTD(i, strg);

		}	
		System.out.println(helperBU_EFF(n));
		System.out.println(helperBU(n));
		return ans + 10;
	}

	public static int helper(int n){

		if(n ==  1){
			return 9;
		}

		int fnm1 = helper(n -  1);
		return  fnm1 * (10 - n + 1);
	}

	public static int helperTD(int n,int[] strg){

		if(n ==  1){
			return 9;
		}

		if(strg[n] != 0){
			return strg[n];
		}

		strg[n] = helperTD(n -  1, strg) * (10 - n + 1);
		return  strg[n];
	}

	public static int helperBU(int n){

		int[] strg = new int[n + 1];

		int ans = 10;
		for(int i = 1;i <= n;i++){

			if(i == 1){

				strg[i] = 9;
				continue;
			}

			strg[i] = strg[i - 1] * (10 - i + 1);
			ans += strg[i];
		}

		return ans;
	}

	public static int helperBU_EFF(int n){

		int strg = 9;
		int ans = 10;
		for(int i = 2;i <= n;i++){

			strg = strg * (10 - i + 1);
			ans += strg;
		}

		return ans;
	}

	

	
}
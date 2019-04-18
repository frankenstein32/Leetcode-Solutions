import java.util.*;

public class UglyNumber2{

	public static void main(String[] args){

		int n = 4;
		System.out.println(isUgly2(n));
		
	}

	public static int isUgly2(int n){


		int i = 1;
		int count = 1;
		while(count <= n){

			if(helper(i))
				count++;

			i++;

		}

		return i - 1;

	}

	public static boolean helper(int num){

		if(num <= 0){
			return false;
		}
		
		if(num == 1){
			return true;
		}

		while(num % 2 == 0){
			num /= 2;
		}

		while(num % 3 == 0){
			num /= 3;
		}

		while(num % 5 == 0){
			num /= 5;
		}
		
		return num == 1;
	}

	public static int helperBU(int n){

		long[] strg = new long[n + 1];
		strg[0] = 1;
		int j = 0, k = 0, l = 0;

		for(int i = 1; i < n;i++){

			long mult2 = strg[j] * 2;
			long mult3 = strg[k] * 3;
			long mult5 = strg[l] * 5;

			long ans = Math.min(mult2, mult3, mult3);

			if(ans == mult2){
				strg[i] = mult2;
				j++;
			}else if(ans == mult3){
				strg[i] = mult3;
				k++;
			}else{
				strg[i] = mult5;
				l++;
			}
		}


	}



}
import java.util.*;

public class CountBits{

	public static void main(String[] args){

		int[] nums = {2,7,9,3,1};
		System.out.println(robbed(nums));
		
	}

	public static int count(int n){


		int cnt = 0;
		while(n != 0){

			int rem = n % 2;
			cnt += (rem == 1 ? rem : 0);
			n /= 2;
		}

		return cnt;
	}

	public static int[] CountBit(int n){

		int[] arr = new int[n];

		for(int i = 1;i < n;i++){

			arr[i] = count(i);
		}
		return arr;
	}

	public static int[] CountBit_eff(int n){

		int pow = 1;
		int[] ret = new int[n + 1];

		for(int i = 1, t = 0;i <= num; i++, t++){

			if(pow == i){

				pow *= 2;
				t = 0;
			}

			ret[t] = ret[t] + 1;
		}

		return ret;
	}
}
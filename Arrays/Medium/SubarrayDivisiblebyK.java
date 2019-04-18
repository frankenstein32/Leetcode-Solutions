import java.util.*;

public class SubarrayDivisiblebyK{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";

	}

    public static int subarray(int[] arr, int k){

        int n = arr.length;
        int[] p = new int[n + 1];

        for(int i = 0;i < n;i++){

            p[i + 1] = p[i] + arr[i];
        }

        int[] count = new int[k];

        for(int x : p){

            count[ (x % k + k) % k]++;
        }

        int ans = 0;
        for(int v : count){

            ans += v * (v - 1)/ 2;
        }

        return ans;

    }
}
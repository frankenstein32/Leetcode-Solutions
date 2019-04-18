import java.util.*;

public class SumSubarrayMinimums{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";

	}

    public static int SumSubarrayMin(int[] A){

        int n = A.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int mod = 1_000_000_007;

        Stack<int[]> stack = new Stack<>(), stack2 = new Stack<>();

        for(int i = 0;i < A.length;i++){

            int count = 1;

            while(!stack.isEmpty() && stack.peek()[0] > A[i]){

                count += stack.pop()[1];
            }

            stack.push(new int[]{ A[i], count});
            left[i] = count;
        }

        for(int i = A.length - 1;i >= 0;i--){

            int count = 1;

            while(!stack.isEmpty() && stack2.peek()[0] > A[i]){
                count += stack2.pop()[1];
            }

            stack2.push(new int[]{ A[i], count});
            right[i] = count;
        }

        int res = 0;
        for(int i = 0;i < n;i++){

            res += (A[i] * left[i] * right[i]) % mod;
        }


        return res;
    }
}
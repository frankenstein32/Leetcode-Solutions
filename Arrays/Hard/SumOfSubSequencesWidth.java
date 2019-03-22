import java.util.*;

public class SumOfSubSequencesWidth{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		String s = "catsanddog";
		List<String> Wordbreak = new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog" }));
		System.out.println(breakIt(s, Wordbreak));

	}

	public static int width(int[] A){

        Arrays.sort(A);
        long[] pow = new long[A.length];
        pow[0] = 1;
        int mod = 1_000_000_007;

        for(int i = 1;i < pow.length;i++){

            pow[i] = pow[i - 1] * 2 % mod; 
        }

        long ans = 0;

        for(int i = 0;i < A.length;i++){

            ans = ( ans + (pow[i] - pow[A.length - i - 1]) * A[i]) % mod;
        }

        return (int)ans;

    }
}
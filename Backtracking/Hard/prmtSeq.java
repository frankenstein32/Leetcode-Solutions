import java.util.*;

public class prmtSeq{

	public static void main(String[] args){


		// String s = "a*";
		// String p = "aa";
		int n = 3;
		System.out.println(prmt(n,1));

	}

	public static String prmt(int n, int k){
	
		List<Integer> numbers = new ArrayList<>();
		int[] fact = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		int sum = 1;
		fact[0] = 1;

		for(int i = 1;i <= n;i++){

			sum *= i;
			fact[i] = sum;
		}

		for(int i = 1;i <= n;i++){
			numbers.add(i);
		}

		k--;

		for(int i = 1;i <= n;i++){

			int idx = k/(fact[n - i]);
			sb.append(String.valuesOf(numbers.get(idx)));
			numbers.remove(idx);

			k -= (idx)*fact[n - i];
		}

		return String.valuesOf(sb);
	}


	
}
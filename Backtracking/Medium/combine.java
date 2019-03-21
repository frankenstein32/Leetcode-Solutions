import java.util.*;

public class combine{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		int n = 3;
		System.out.println(comb(n,1));

	}

	public static String comb(int n, int k){
	
		List<List<Integer>> combs = new ArrayList<>();
		dfs(n, k);

		return combs;
	}

	public static void dfs(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k){

		if(k == 0){
			combs.add(new ArrayList<>(comb));
		}else{

			for(int i = start;i <= n;i++){

				comb.add(i);
				dfs(combs, comb, i + 1, n, k - 1);
				comb.remove(comb.size() - 1);
			}
		}
	}
}
import java.util.*;

public class wordBreak2{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		String s = "catsanddog";
		List<String> Wordbreak = new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog" }));
		System.out.println(breakIt(s, Wordbreak));

	}

	public static List<String> breakIt(String s, List<String> wordDict){

		
		// DFS
		 dfs(s, 0, wordDict, new StringBuilder());
		 return ans;

	}

	static List<String> ans = new ArrayList<>();

	public static void dfs(String s, int idx, List<String> dict, StringBuilder t){

		if(idx == s.length()){
			ans.add(t.toString());
			return;
		}

		for(int i = idx;i <= s.length();i++){

			String temp = s.substring(idx, i);
			StringBuilder sb = new StringBuilder(temp);

			if(dict.contains(temp)){

				dfs(s, i, dict, sb);
			}
		}
	}
}
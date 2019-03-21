import java.util.*;

public class AdditiveNumber{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		String s = "catsanddog";
		List<String> Wordbreak = new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog" }));
		System.out.println(breakIt(s, Wordbreak));

	}

	public static List<String> breakIt(String s, List<String> wordDict){

		
		// DFS
		 dfs(s, wordDict);
		 return ans;

	}

	public static void dfs(String s, Set<String> dict){

		List<String> words = new ArrayList<>();

		int len = s.length();

		for(int i = len - 1; i >= 0;i--){

			String last = s.substring(i,len);

			if(dict.contains(last)){
				words.add(last);
			}else{

				String remain = s.substring(0, i);
				List<String> remain = dfs(remain, dict);

				if(remain != null){

					for(String item : remain){

						words.add(item + " " + last);
					}
				}

			}
		}

		return words;

	}
}
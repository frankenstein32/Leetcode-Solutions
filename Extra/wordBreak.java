import java.util.*;

public class wordBreak{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		int n = 3;
		System.out.println(breakIt(n, new Set<>()));

	}

	public static boolean breakIt(String s, Set<String> dict){

		
		// DFS
		Set<Integer> set = new Set<>();
		return dfs(s, 0, dict, set);

	}

	public static boolean dfs(String s, int idx, Set<String> dict, Set<Integer> set){

		if(idx == s.length()){
			return true;
		}

		if(set.contains(idx)){
			return false;
		}

		for(int i = idx;i <= s.length();i++){

			String t = s.substring(idx, i);

			if(dict.contains(t)){

				if(dfs(s,i,dict,set)){
					return true;
				}else{
					set.add(i);
				}
			}
		}

		set.add(idx);
		return false;
	}
}
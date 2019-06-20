import java.util.*;

class LetterCasePermutation {

	public List<String> letterCasePermutation(String str){

		List<String> ans = new ArrayList<>();


		return dfs(str, 0, ans);

	}

	public List<String> dfs(char[] str, int vidx, List<String> ans){

		ans.add(String.valueOf(str));

		if(vidx >= str.length()){
			return ans;
		}

		for(int i = vidx;i < str.length();i++){

			if(Character.isAlphabetic(str[i])){

				str[i] ^= 32;
				dfs(str, i + 1, ans);
				str[i] ^= 32;
			}
		}

		return ans;
	}
}


import java.util.*;

public class CommonCharacters{
	

	public List<Integer> commonChars(String[] A){

		int[] count = new int[26];

		Arrays.fill(count, Integer.MAX_VALUE);

		for(String s : A){

			int[] tempCnt = new int[26];
			for(int i = 0;i < s.length();i++){
				++tempCnt[s.charAt(i) - 'a'];
			}

			for(int i = 0;i < 26;i++){
				count[i] = Math.min(count[i], tempCnt[i]);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for(char ch = 'a'; c <= 'z';c++){

			while(count[c - 'a']-- > 0){
				ans.add(ch);
			}
		}

		return ans;
	}

}
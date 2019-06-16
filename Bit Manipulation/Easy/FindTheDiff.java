import java.util.*;

class FindTheDiff {

	public char findTheDifference(String s, String t){

		if(s.length() == 0 & t.length() == 0){
			return '~';
		}

		int ans = 0;

		for(int i = 0;i < s.length();i++){

			ans = ans ^ s.charAt(i);
		}

		for(int i = 0;i < t.length();i++){
			ans = ans ^ t.charAt(i);
		}

		return ans;
	}

	public char findTheDiff_elegant(String s, String t){

		int n = t.length();
		char c = t.charAt(n - 1);

		for(int i = 0;i < n - 1;i++){

			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}

		return c;
	}
}


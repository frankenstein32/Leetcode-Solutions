import java.util.*;

public class wildCardMatching{

	public static void main(String[] args){


		String s = "acdcb";
		String p = "a*c?b";
		System.out.println(isMatch(s,p));
		System.out.println(isMatch_dp(s,p));

	}

	public static boolean isMatch(String src, String pat){

		if(src.length() == 0 && pat.length() == 0){
			return true;
		}

		if(src.length() != 0 && pat.length() == 0){
			return false;
		}

		if(src.length() == 0 && pat.length() != 0){

			for(int i = 0;i < pat.length();i++){

				if(pat.charAt(i) != '*'){
					return false;
				}
			}

			return true;
		}

		String srcRos = src.substring(1);
		String patRos = pat.substring(1);

		if(pat.charAt(0) == '*'){

			boolean rr1 = isMatch(src, patRos);
			boolean rr2 = isMatch(srcRos, pat);

			return rr1 || rr2;
		}else if( pat.charAt(0) == '?' || pat.charAt(0) == src.charAt(0)){

			return isMatch(srcRos, patRos);
		}

		return false;

	}

	public static boolean isMatch_dp(String src, String pat){

		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];

		for(int i = src.length();i >= 0;i--){

			for(int j = pat.length();j >= 0;j--){

				if(i == src.length() && j == pat.length()){
					strg[i][j] = true;
					continue;
				}

				if(i != src.length() && j == pat.length()){

					strg[i][j] = false;
					continue;
				}

				if(i == src.length() && j != pat.length()){

					strg[i][j] = true;
					for(int k = j;k < pat.length();k++){
						if(pat.charAt(k) != '*'){
							strg[i][j] = false;
							break;
						}
					}
					
					continue;
				}

				if(pat.charAt(j) == '*'){
					strg[i][j] = strg[i + 1][j] || strg[i][j + 1];
				}else if(pat.charAt(j) == '?' || pat.charAt(j) == src.charAt(i)){
					strg[i][j] = strg[i + 1][j + 1];
				}else{
					strg[i][j] = false;
				}

			}
		}

		return strg[0][0];



	}
}
import java.util.*;

public class RegularExpressionMatching{

	public static void main(String[] args){


		String s = "a*";
		String p = "aa";
		System.out.println(isMatch(s,p));

	}

	public static boolean isMatch(String s, String p){

		return isMatch(s,0,p,0);
	}

	public static boolean isMatch(String s, int pos1, String p, int pos2){


		if(pos1 == s.length() && pos2 == p.length()){
			return true;
		}

		if(pos2 == p.length()){
			return false;
		}

		char pchar = p.charAt(pos2);

		if(pos2  + 1 < p.length() && p.charAt(pos2 + 1) == '*'){

			if(isMatch(s,pos1,p,pos2 + 2)) return true;

			while(pos1 < s.length() && (pchar == '.' || pchar == s.charAt(pos1))){

				if(isMatch(s, ++pos1,p,pos2 + 2))
				return true;
			}

		}else if(pos1 != s.length() && (pchar == '.' || s.charAt(pos1) == pchar)){

			return isMatch(s,pos1 + 1,p,pos2 + 1);

		}
			return false;
		
	}

	
}
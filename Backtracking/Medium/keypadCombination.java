import java.util.*;

public class keypadCombination{

	public static void main(String[] args){


		String s = "a*";
		String p = "aa";
		System.out.println(isMatch(s,p));

	}

	public static boolean letterCombinations(digits){

		if(digits.length() == 0){

			List<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
	
		List<String> mr = new ArrayList<>();

		char ch = digits.charAt(0);
		String ros = digits.substring(1);
		String code = getcode(ch);
		for(int i = 0;i < code.length();i++){

			List<String> rr = letterCombinations(ros);

			for(String val : rr){
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;
		

	}

	public static String getcode(char ch){


		if(ch == '2'){
			return "abc";
		}else if(ch == '3'){

			return "def";
		}else if(ch == '4'){

			return "ghi";
		}else if(ch == '5'){
			return "jkl";
		}else if(ch == '6'){
			return "mno";
		}else if(ch == '7'){
			return "pqrs";
		}else if(ch == '8'){
			return "tuv";
		}else if(ch == '9'){
			return "wxyz";
		}

		return "";
	}

	public static List<String> combinations(String digits){

		List<String> res = new ArrayList<>();
        
                
      if(digits.length() >= 1){
		dfs(digits, 0, res, new StringBuilder());
        
	}
        return res;
    }

	public static void dfs(String digits, int vidx, List<String> res, StringBuilder curr){

		if(vidx == digits.length()){

			res.add(curr.toString());
			return;
		}
		
			String code = getcode(digits.charAt(vidx));

			for(char val : code.toCharArray()){

				curr.append(val);
				dfs(digits, vidx + 1, res,curr);
				curr.deleteCharAt(curr.length() - 1);
			}
    }

	
}
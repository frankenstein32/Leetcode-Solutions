import java.util.*;

public class GenerateParenthesis{

	public static void main(String[] args){


		String s = "a*";
		String p = "aa";
		System.out.println(isMatch(s,p));

	}

	public static List<String> generate(int n){

		return helper(n,0,0);

	}

	public static List<String> helper(int n, int open,int close){


		if(open == n && close == n){

			List<String> br = new ArrayList<>();

			br.add("");
			return br;
		}

		if(close > open || open > n || close > n){
			returnn new ArrayList<>();
		}

		List<String> mr = new  ArrayList<>();

		List<String> rr = helper(n,open + 1,close);

		for(String val : rr){
			mr.add("("+val);
		}

		List<String> rr2 = helper(n,open, close + 1);

		for(String val : rr2){
			mr.add(")"+val);
		}

		return mr;
	}

	public static void dfs(int n, int open,int close,List<String> res,String ans){

		if(open == n && close == n){
			res.add(ans);
			return;
		}

		if(close > open || open > n || close > n){
			return;
		}
		
		dfs(n, open + 1,close,res,ans + "(");
		dfs(n, open,close + 1,res,ans + ")");
	}
}
import java.util.*;

public class DecodeWays{

	public static void main(String[] args){

		String s1 = "226";
		System.out.println(numDecdoing(s1));
		
	}

	public static int numDecdoing(String s){

		int[] strg  = new int[s.length() + 1];
		Arrays.fill(strg, -1);
		System.out.println(helperBU(s));
		 return helperTD(s, 0, strg);
	}


	public static int helper(String s, int p){

		if(p == s.length()){
			return 1;
		}

		if(s.charAt(p) == '0'){
			return 0;
		}

		int res = helper(s, p + 1);

		if(p < s.length() - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7'))){

			res += helper(s, p + 2);
		}

		return res;

		
	}

	public static int helperTD(String s, int p, int[] strg){


		if(p == s.length()){
			return 1;
		}

		if(s.charAt(p) == '0'){
			return 0;
		}

		if(strg[p] != -1){
			return strg[p];
		}

		int res = helperTD(s, p + 1, strg);

		if(p < s.length() - 1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p + 1) < '7'))){

			res += helperTD(s, p + 2, strg);
		}

		strg[p] = res;

		return res;


	}

	public static int helperBU(String s){


		int[] strg = new int[s.length() + 2];

		for(int row = s.length();row >= 0;row--){


			if(row == s.length()){
				strg[row] = 1;
				continue;
			}


			int res = strg[row + 1];

			if(s.charAt(row) == '1' || (s.charAt(row) == '2' && s.charAt(row + 1) < '7')){

				res += strg[row + 2];
			}

			strg[row] = res;

		}

		display(strg);

		return strg[0];
	}


	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

	
}
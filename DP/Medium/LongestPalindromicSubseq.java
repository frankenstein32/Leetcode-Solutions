import java.util.*;

public class LongestPalindromicSubseq{

	public static void main(String[] args){

		String str = "bbbabaaaa";
		System.out.println(longestLength(str));
		
	}

	public static int longestLength(String str){

		int[][] strg = new int[str.length() + 1][str.length() + 1];

		for(int[] val : strg)
			Arrays.fill(val, -1);

		System.out.println(helperBU_EFF(str));
		System.out.println(helperBU(str));
		System.out.println(helperTD(str, 0, str.length() - 1,strg));
		return helper(str, 0, str.length() - 1);
	}

	public static int helper(String str, int si, int ei){

		if(si > ei){
			return 0;
		}

		if(si == ei){
			return 1;
		}


		if(str.charAt(si) == str.charAt(ei)){

			return helper(str, si + 1, ei - 1) + 2;
		}

		return Math.max(helper(str, si + 1, ei), helper(str, si, ei - 1));

	}

	public static int helperTD(String str, int si, int ei, int[][] strg){


		if(si > ei){
			return 0;
		}

		if(si == ei){
			return 1;
		}

		if(strg[si][ei] != -1){
			return strg[si][ei];
		}


		if(str.charAt(si) == str.charAt(ei)){

			return strg[si][ei] = helperTD(str, si + 1, ei - 1,strg) + 2;
		}

		return strg[si][ei] = Math.max(helperTD(str, si + 1, ei,strg), helperTD(str, si, ei - 1,strg));

	}

	public static int helperBU(String str){


		int[][] strg = new int[str.length()][str.length()];

		for(int slide = 0;slide < str.length();slide++){

			for(int si = 0; si < str.length() - slide;si++){

				int ei = si+ slide;

				if(si == ei){
					strg[si][ei] = 1;
					continue;
				}


				if(str.charAt(si) == str.charAt(ei)){

					strg[si][ei] = strg[si + 1][ei - 1] + 2;
					continue;
				}

				strg[si][ei] = Math.max(strg[si + 1][ei], strg[si][ei - 1]);
			}
		}

		display(strg);
		return strg[0][str.length() - 1];
	}

	public static int helperBU_EFF(String str){

		int[] strg = new int[str.length()];
		for(int si = strg.length - 1;si >= 0;si--){

			int save = 1;
			for(int ei = si; ei < strg.length;ei++){

				if(si == ei){

					int temp = save;
					save = strg[ei];
					strg[ei] = temp;

					continue;
				}

				if(str.charAt(si) == str.charAt(ei)){

					int temp = save;
					save = strg[ei];
					strg[ei] = temp + 2;
					continue;
				}

				int temp = save;
				save = strg[ei];
				strg[ei] = Math.max(strg[ei], strg[ei - 1]);
			}
			// display(strg);
		}

		return strg[strg.length - 1];

	}


	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
	
	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

}
import java.util.*;

public class EditDistance{

	public static void main(String[] args){

		String s1 = "horse";
		String s2 = "ros";
		System.out.println(minDistance(s1, s2));
		
	}

	public static int minDistance(String s1, String s2){


		System.out.println(helperBU_Eff(s1, s2));
		System.out.println(helperBU(s1, s2));
		System.out.println(helperTD(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		return helper(s1, s2);
	}

	public static int helper(String s1, String s2){

		if(s1.length() == 0 || s2.length() == 0){

			return Math.max(s1.length(), s2.length());
		}

		if(s1.charAt(0) == s2.charAt(0)){

			return helper(s1.substring(1),s2.substring(1));

		}else{

			int insert = helper(s1, s2.substring(1));
			int delete = helper(s1.substring(1), s2);
			int replace = helper(s1.substring(1), s2.substring(1));

			return Math.min(insert, Math.min(delete, replace)) + 1;
		}


	}

	public static int helperTD(String s1, String s2, int[][] strg){

		if(s1.length() == 0 || s2.length() == 0){

			return Math.max(s1.length(), s2.length());
		}

		int n = s1.length();
		int m = s2.length();

		if(strg[n][m] != 0){
			return strg[n][m];
		}

		if(s1.charAt(0) == s2.charAt(0)){

			strg[n][m] = helperTD(s1.substring(1),s2.substring(1), strg);
			return strg[n][m];

		}else{

			int insert = helperTD(s1, s2.substring(1), strg);
			int delete = helperTD(s1.substring(1), s2, strg);
			int replace = helperTD(s1.substring(1), s2.substring(1), strg);

			strg[n][m] = Math.min(insert, Math.min(delete, replace)) + 1;
			return strg[n][m];
		}
	}

	public static int helperBU(String s1, String s2){


		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for(int i = s1.length();i >= 0;i--){

			for(int j = s2.length();j >= 0;j--){


				if(i == s1.length()){

					strg[i][j] = s2.length() - j;
					continue;
				}

				if(j == s2.length()){
					strg[i][j] = s1.length() - i;
					continue;
				}

				if(s1.charAt(i) == s2.charAt(j)){

					strg[i][j] = strg[i + 1][j + 1];
				}else{

					int insert = strg[i][j + 1];
					int delete = strg[i + 1][j];
					int replace = strg[i + 1][j + 1];

					strg[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;

				}
			}
		}

		display(strg);

		return strg[0][0];
	}

	public static int helperBU_Eff(String s1, String s2){


		int[] strg = new int[s2.length() + 1];

		for(int i = s1.length();i >= 0;i--){

			int save = 0;
			for(int j = s2.length();j >= 0;j--){


				if(i == s1.length()){

					strg[j] = s2.length() - j;
					continue;
				}

				if(j == s2.length()){

					save = strg[j];
					strg[j] = s1.length() - i;
					continue;
				}

				if(s1.charAt(i) == s2.charAt(j)){

					int temp = save;
					save = strg[j];
					strg[j] = temp;
				}else{

					int insert = strg[j + 1];
					int delete = strg[j];
					int replace = save;
					save = strg[j];
					strg[j] = Math.min(insert, Math.min(delete, replace)) + 1;

				}
			}
		}

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
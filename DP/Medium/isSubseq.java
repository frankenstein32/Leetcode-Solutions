import java.util.*;

public class isSubseq{

	public static void main(String[] args){

		// Main
		String s = "axc";
		String t = "ahbgdc";
		System.out.println(isSub(t, s));
	}

	public static boolean isSub(String s1, String s2){

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for(int[] arr : strg)
			Arrays.fill(arr, -1);

		System.out.println(helperBU_EFF(s1, s2));
		System.out.println(helperBU(s1, s2));
		System.out.println(helperTD(s1, s2, strg));
		return helper(s1, s2);
	}

	public static boolean helper(String s1, String s2){

		if(s1.length() == 0 && s2.length() != 0){
			return false;
		}

		if(s2.length() == 0){
			return true;
		}


		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if(ch1 == ch2){
			return helper(ros1, ros2);
		}else{

			return helper(ros1, s2);
		}
	}

	public static int helperTD(String s1, String s2, int[][] strg){

		if(s1.length() == 0 && s2.length() != 0){
			return 0;
		}

		if(s2.length() == 0){
			return 1;
		}

		if(strg[s1.length()][s2.length()] != -1){
			return strg[s1.length()][s2.length()];
		}


		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if(ch1 == ch2){
			return strg[s1.length()][s2.length()] = helperTD(ros1, ros2, strg);
		}else{

			return strg[s1.length()][s2.length()] = helperTD(ros1, s2, strg);
		}
	}

	public static boolean helperBU(String s1, String s2){


		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for(int i = s1.length();i >= 0;i--){

			for(int j = s2.length();j >= 0;j--){

				if(i == s1.length() && j != s2.length()){
					strg[i][j] = 0;
					continue;
				}

				if(j == s2.length()){
					strg[i][j] = 1;
					continue;
				}

				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(j);

				if(ch1 == ch2){
					strg[i][j] = strg[i + 1][j + 1];
				}else{

					strg[i][j] = strg[i + 1][j];
				}
			}
		}

		display(strg);

		return (strg[0][0] == 1 ? true : false);
	}

	public static boolean helperBU_EFF(String s1, String s2){


		int[] strg = new int[s2.length() + 1];

		for(int i = s1.length();i >= 0;i--){

			int save = 1;
			for(int j = s2.length();j >= 0;j--){

				if(i == s1.length() && j != s2.length()){
					save = strg[j];
					strg[j] = 0;
					continue;
				}

				if(j == s2.length()){
					save = strg[j];
					strg[j] = 1;
					continue;
				}

				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(j);

				if(ch1 == ch2){
					int temp = save;
					save = strg[j];
					strg[j] = temp;
				}else{

					save = strg[j];
					strg[j] = strg[j];
				}
			}
			display(strg);	
		}

		return (strg[0] == 1 ? true : false);
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

			for(int item : arr){
				System.out.print(item+" ");
			

		}
		System.out.println();
	}

	

	
}
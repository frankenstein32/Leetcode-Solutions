import java.util.*;

public class MinimumAscii{

	public static void main(String[] args){

		String s1 = "delete";
		String s2 = "leet";
		System.out.println(minDeletedSum(s1, s2));
		
	}

	public static int minDeletedSum(String s1, String s2){
		
		System.out.println(helperBU_Eff(s1, s2));
		return helperBU(s1,s2);
	}

	public static int helper(String s1, String s2){

		if(s1.length() == 0 || s2.length() == 0){

			int sum = 0;

			for(int i = 0;i < s1.length();i++){

				sum += s1.charAt(i);
			}

			for(int i = 0;i < s2.length();i++){
				sum += s2.charAt(i);
			}

			return sum;
			
		}


		if(s1.charAt(0) == s2.charAt(0)){

			return helper(s1.substring(1),s2.substring(1));
		}else{

			int firstPart = helper(s1.substring(1),s2) + s1.charAt(0);
			int secondPart = helper(s1, s2.substring(1)) + s2.charAt(0);

			return Math.min(firstPart, secondPart);
		}

	}

	public static int helperTD(String s1, String s2, int[][] strg){

		if(s1.length() == 0 || s2.length() == 0){

			int sum = 0;

			for(int i = 0;i < s1.length();i++){

				sum += s1.charAt(i);
			}

			for(int i = 0;i < s2.length();i++){
				sum += s2.charAt(i);
			}

			return sum;
			
		}

		if(strg[s1.length()][s2.length()] != 0){
			return strg[s1.length()][s2.length()];
		}


		if(s1.charAt(0) == s2.charAt(0)){

			strg[s1.length()][s2.length()] = helperTD(s1.substring(1),s2.substring(1), strg);
			return strg[s1.length()][s2.length()];
		}else{

			int firstPart = helperTD(s1.substring(1),s2, strg) + s1.charAt(0);
			int secondPart = helperTD(s1, s2.substring(1), strg) + s2.charAt(0);

			strg[s1.length()][s2.length()] = Math.min(firstPart, secondPart);
			return strg[s1.length()][s2.length()];
		}

	}

	public static int helperBU(String s1, String s2){


		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		System.out.println(strg.length +" "+strg[0].length);
		for(int i = s1.length();i >= 0;i--){

			for(int j = s2.length();j >= 0;j--){

				if(i == s1.length() || j == s2.length()){

					int sum = 0;

					for(int k = i;k < s1.length();k++){

						sum += s1.charAt(k);
					}

					for(int k = j;k < s2.length();k++){
						sum += s2.charAt(k);
					}

					strg[i][j] = sum;
					continue;
				}

				if(s1.charAt(i) == s2.charAt(j)){

					strg[i][j] = strg[i + 1][j + 1];
				}else{

					int firstPart =  strg[i + 1][j] + s1.charAt(i);
					int secondPart = strg[i][j + 1] + s2.charAt(j);

					strg[i][j] = Math.min(firstPart, secondPart);
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

				if(i == s1.length() || j == s2.length()){

					int sum = 0;

					for(int k = i;k < s1.length();k++){

						sum += s1.charAt(k);
					}

					for(int k = j;k < s2.length();k++){
						sum += s2.charAt(k);
					}

					save = strg[j];
					strg[j] = sum;
					continue;
				}

				if(s1.charAt(i) == s2.charAt(j)){

					int temp = save;
					save = strg[j];
					strg[j] = temp;
				}else{

					int firstPart =  strg[j] + s1.charAt(i);
					int secondPart = strg[j + 1] + s2.charAt(j);

					save = strg[j];
					strg[j] = Math.min(firstPart, secondPart);
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
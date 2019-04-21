import java.util.*;

public class LongestValidParenthesis{

	public static void main(String[] args){

		String s = "())";
		System.out.println(find(s));
		
	}

	public static int find(String s){

		int ans = 0;

		int[] strg = new int[s.length()];

		Arrays.fill(strg, -1);
		for(int i = 0;i < s.length();i++){

			if(s.charAt(i) == ')')
				ans = Math.max(ans, helperTD(s, i, strg));
		}

		System.out.println(helperBU(s));
		return ans;
	}

	public static int helper(String s, int vidx){

		if(vidx < 1){
			return 0;
		}

		char ch = s.charAt(vidx);

		int ans = 0;

		if(ch == '('){
			ans = 0;
		}else{


			if(s.charAt(vidx - 1) == '('){
				ans =  helper(s, vidx - 2) + 2;
			}else{

				int len = helper(s, vidx - 1);

				if(s.charAt(vidx - len - 1) == '('){

					ans = len + helper(s, vidx - len - 2) + 2;
				}
			}
		}

		return ans;

		
	}

	public static int helperTD(String s, int vidx,int[] strg){

		if(vidx < 1){
			return 0;
		}

		if(strg[vidx] != -1){
			return strg[vidx];
		}

		char ch = s.charAt(vidx);

		int ans = 0;

		if(ch == '('){
			ans = 0;
		}else{


			if(s.charAt(vidx - 1) == '('){
				ans =  helperTD(s, vidx - 2, strg) + 2;
			}else{

				int len = helperTD(s, vidx - 1, strg);

				if(vidx - len - 1 >= 0 && s.charAt(vidx - len - 1) == '('){

					ans = len + helperTD(s, vidx - len - 2, strg) + 2;
				}
			}
		}

		return strg[vidx] = ans;
	}

	public static int helperBU(String s){


		int[] strg = new int[s.length()];
		int max = 0;
		for(int i = 1;i < s.length();i++){

			char ch = s.charAt(i);

			if(ch == '('){
				strg[i] = 0;
				continue;
			}


			if(s.charAt(i - 1) == '('){

				strg[i] = (i >= 2 ? strg[i - 2] : 0) + 2;
			}else{

				int len = strg[i - 1];

				if(i - len > 0 && s.charAt(i - len - 1) == '('){
					strg[i] = strg[i - 1] + (i - len >= 2 ? strg[i - len - 2] : 0) + 2;
				}
			}

			max = Math.max(max, strg[i]);
		}

		return max;


	}

	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}
	

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

}
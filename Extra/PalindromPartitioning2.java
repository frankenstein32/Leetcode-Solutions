import java.util.*;

public class PalindromPartitioning2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2};
		int target = 2;
		String str = "coder";
		System.out.println(caculate(str));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static void display2(int[][] nums){


 		for(int[] arr : nums){

 			for(int val : arr){
 				System.out.print(val+" ");
 			}
 			System.out.println();
 		}
 	}

 	public static int caculate(String str){
			
		System.out.println(helperBU(str));
		System.out.println(helperTD(str,0,str.length() - 1,new int[str.length() + 1][str.length() + 1]));
		return helper(str,0, str.length() - 1);
	}

	public static int helper(String str, int si, int ei){

		String self = str.substring(si,ei + 1);

		if(isPalindrome(self)){
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		for(int i = si;i < ei;i++){


			int left = helper(str,si,i);
			int right = helper(str,i + 1,ei);

			ans = Math.min(ans,left + right);
		}

		return ans + 1;
	}
	
	public static int helperTD(String str, int si, int ei,int[][] strg){

		String self = str.substring(si,ei + 1);

		if(isPalindrome(self)){
			return 0;
		}

		if(strg[si][ei] != 0){
			return strg[si][ei];
		}

		int ans = Integer.MAX_VALUE;
		for(int i = si;i < ei;i++){


			int left = helperTD(str,si,i,strg);
			int right = helperTD(str,i + 1,ei,strg);

			ans = Math.min(ans,left + right);
		}

		strg[si][ei] = ans + 1;
		return ans + 1;
	}

	public static int helperBU(String str){

		int n = str.length();

		int[][] strg = new int[n][n];

		for(int slide = 1;slide <= n;slide++){

		 	for(int si = 0; si <= n - slide - 1;si++){

		 		int ei =  slide + si;
		 		int ans = Integer.MAX_VALUE;

		 		if(isPalindrome(str.substring(si,ei + 1))){
		 			continue;
		 		}
		 		for(int i = si;i < ei;i++){

		 			int left = strg[si][i];
		 			int right = strg[i + 1][ei];

		 			ans = Math.min(ans,left + right);	
		 		}

		 		strg[si][ei] = ans + 1;
		 	}
		}

		display2(strg);
		return strg[0][n - 1];
	}

	public static boolean isPalindrome(String str){

		int lo = 0;
		int hi = str.length() - 1;

		while(lo < hi){

			if(str.charAt(lo) != str.charAt(hi))
				return false;

			lo++;
			hi--;
		}

		return true;
	}
}
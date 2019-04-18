import java.util.*;

public class OnesAndZeros{

	public static void main(String[] args){

		// Main
		String[] strs = {"10", "0001", "111001", "1", "0"};
		System.out.println(calc(strs, 4, 3));

		
	} public static int calc(String[] strs, int m, int n){
		int[][][] strg = new int[strs.length + 1][m + 1][n + 1];

		for(int[][] val : strg){

			for(int[] arr : val)
				Arrays.fill(arr, -1);
		}
		
		System.out.println(helperBU_EFF(m,n,strs));
		System.out.println(helperBU(m,n,strs));
		System.out.println(helperTD(m, n, 0, strs, strg));
		return helper(m,n,0,strs);
	}

	public static int helper(int m, int n, int i,String[] strs){

		if(i == strs.length){
			return 0;
		}

		int[] ans = fill(strs[i]);

		int inc = 0;
		if(ans[0] <= m && ans[1] <= n)
			inc = helper(m - ans[0],n - ans[1], i + 1,strs) + 1;

		int exc = helper(m,n, i + 1,strs);

		return Math.max(inc, exc);

	}

	public static int helperTD(int m, int n, int i,String[] strs, int[][][] strg){

		if(i == strs.length){
			return 0;
		}

		if(strg[i][m][n] != -1){
			return strg[i][m][n];
		}

		int[] ans = fill(strs[i]);

		int inc = 0;
		if(ans[0] <= m && ans[1] <= n)
			inc = helperTD(m - ans[0],n - ans[1], i + 1,strs, strg) + 1;

		int exc = helperTD(m,n, i + 1,strs, strg);

		strg[i][m][n] = Math.max(inc, exc);
		return Math.max(inc, exc);

	}

	public static int helperBU(int m, int n, String[] strs){

		int l = strs.length;
		int[][][] strg = new int[l + 1][m + 1][n + 1];

		for(int i = l - 1;i >= 0;i--){

			int[] ans;
			ans = fill(strs[i]);

			for(int j = 0;j <= m;j++){
				for(int k = 0;k <= n;k++){

					if(i == l - 1){

						if(j >= ans[0] && k >= ans[1])
							strg[i][j][k] = 1;

						continue; 
					}

					int inc = 0, exc = 0;

					if(ans[0] <= j && ans[1] <= k){

						inc = strg[i + 1][j - ans[0]][k - ans[1]] + 1;
					}

					exc = strg[i + 1][j][k];

					strg[i][j][k] = Math.max(exc,inc);

				}
			}
		}

		// display(strg);
		return strg[0][m][n];
	}

	public static int helperBU_EFF(int m, int n, String[] strs){
		int l = strs.length;
		int[][] strg = new int[m + 1][n + 1];

		for(int i = l - 1;i >= 0;i--){

			int[] ans;
			ans = fill(strs[i]);

			for(int j = m;j >= 0;j--){
				for(int k = n;k >= 0;k--){

					if(i == l - 1){

						if(j >= ans[0] && k >= ans[1])
							strg[j][k] = 1;

						continue; 
					}

					int inc = 0, exc = 0;

					if(ans[0] <= j && ans[1] <= k){

						inc = strg[j - ans[0]][k - ans[1]] + 1;
					}

					exc = strg[j][k];

					strg[j][k] = Math.max(exc,inc);

				}
			}
			// display(strg);
		}

		
		return strg[m][n];
	}

	public static int[] fill(String str){

		int[] res = new int[2];

		for(int i = 0;i < str.length();i++){

			if(str.charAt(i) == '0'){
				res[0]++;
			}else{
				res[1]++;
			}
		}

		return res;
	}

	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}

		System.out.println("**********");
	}



	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(i + ":"+j+":"+k+":value -> "+value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}

	

	
}
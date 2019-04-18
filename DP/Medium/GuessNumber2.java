import java.util.*;

public class GuessNumber2{

	public static void main(String[] args){

		// Main
		System.out.println(find(5));

		
	}

	public static int find(int n){

		
		int[][] strg = new int[n + 1][n + 1];

		for(int[] arr : strg){

			Arrays.fill(arr, -1);
		}

		System.out.println(helperBU(n));
		System.out.println(helperTD(1,n,strg));
		return helper(1, n);
	}

	public static int helper(int si, int ei){

		if(si >= ei){
			return 0;
		}

		int res = Integer.MAX_VALUE;
		for(int i = si;i <= ei;i++){

			int ans = i + Math.max(helper(si, i - 1), helper(i + 1, ei));
			res = Math.min(res, ans);	

		}
		
		return res;
	}

	public static int helperTD(int si, int ei,int[][] strg){

		if(si >= ei){
			return 0;
		}	

		if(strg[si][ei] != -1){
			return strg[si][ei];
		}

		int res = Integer.MAX_VALUE;
		for(int i = si;i <= ei;i++){

			int ans = i + Math.max(helperTD(si, i - 1, strg), helperTD(i + 1, ei, strg));
			res = Math.min(res, ans);	

		}

		strg[si][ei] = res;
		return res;

	}

	public static int helperBU(int n){


		int[][] strg = new int[n][n + 1];


		for(int slide = 1;slide <= n;slide++){

			for(int si = 0;si <= n - slide;si++){

				int ei = si + slide;


				int res = Integer.MAX_VALUE;
				for(int i = si;i <= ei;i++){


					int prev = 0, next = 0;
					if(i - 1 >= 0){

						prev = strg[si][i - 1];
					}

					if(i + 1 < strg.length){
						next = strg[i + 1][ei];
					}

					int temp = i + Math.max(prev, next);
					res = Math.min(res, temp);
				}

				strg[si][ei] = res;
			}

		}

		display(strg);
		return strg[0][n];
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
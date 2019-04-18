import java.util.*;

public class CountBinarySearchTree{

	public static void main(String[] args){

		int n = 4;
		System.out.println(count(n));
		
	}

	public static int count(int n){

		int[] arr = new int[n];

		for(int i = 0;i < n;i++){
			arr[i] = i + 1;
		}

		int[][] strg = new int[n + 1][n + 1];

		for(int[] val : strg){

			Arrays.fill(val, -1);
		}

		System.out.println(helperBU(arr));
		System.out.println(helperBU_EFF(n));
		// System.out.println(helperTD(arr, 0, arr.length - 1, strg));
		// display(strg);
		return helper(arr, 0, arr.length - 1);
	}

	public static int helper(int[] arr,int si, int ei){

		if(si > ei){
			return 1;
		}

		if(si == ei || si + 1 == ei){
			return ei - si + 1;
		}

		
		int ans = 0;
		for(int i = si;i <= ei;i++){

			int part1 = helper(arr, si, i - 1);
			int part2= helper(arr, i + 1, ei);

			ans += part1 * part2;
		}

		return ans;


	}

	public static int helperTD(int[] arr,int si, int ei, int[][] strg){

		if(si > ei){
			return 1;
		}

		if(si == ei || si + 1 == ei){
			return ei - si + 1;
		}

		if(strg[si][ei] != -1){
			return strg[si][ei];
		}

		
		int ans = 0;
		for(int i = si;i <= ei;i++){

			int part1 = helperTD(arr, si, i - 1, strg);
			int part2= helperTD(arr, i + 1, ei, strg);

			ans += part1 * part2;
		}

		strg[si][ei] = ans;

		return ans;


	}

	public static int helperBU(int[] arr){

		int[][] strg = new int[arr.length][arr.length];

		for(int[] val : strg){
			Arrays.fill(val, 1);
		}

		for(int slide = 0;slide < arr.length;slide++){

			for(int si = 0; si < arr.length - slide;si++){

				int ei = si + slide;

				if(si == ei || si + 1 == ei){
					strg[si][ei] = ei - si + 1;
					continue;
				}

				int ans = 0;
				for(int i = si;i <= ei;i++){

					int part1 = 1, part2 = 1;
					
					if(i - 1 >= 0)
						part1 = strg[si][i - 1];

					if(i + 1 < strg.length)
						part2 = strg[i + 1][ei];

					ans += part1 * part2;
				}

				strg[si][ei] = ans;

			}
		}

		display(strg);
		return strg[0][strg.length - 1];
	}

	// F(3, 7) = G(2) + G(4)
	// G(4) = F(0, 4) + F(1, 4) + F(2, 4) + F(3, 4) + F(4,4) 
	
	public static int helperBU_EFF(int n){

		int[] strg = new int[n + 1];

		strg[0] = strg[1] = 1;

		for(int i = 2;i <= n;i++){

			for(int j = 1;j <= i;j++){

				strg[i] += strg[j - 1] * strg[i - j];
			}
		}

		return strg[n];
		
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
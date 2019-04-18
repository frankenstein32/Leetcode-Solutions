import java.util.*;

public class BuyingFruits{

	public static void main(String[] args){

		int[][] arr = {{1, 50, 50}, {50, 50, 50},{1, 50, 50}};
		System.out.println(minMoney(arr));
	}

	public static int minMoney(int[][] arr){

		int ans = Integer.MAX_VALUE;	
		int[][] strg = new int[arr.length + 1][arr.length + 1];

			for(int j = 0; j < arr[0].length;j++)
				ans = Math.min(helperTD(arr,0, j,strg), ans);

		return ans;
	}

	public static int helper(int[][] arr, int cr, int cc){

		if(cc < 0 || cc >= arr[0].length || cr >= arr.length){
			return 100000;
		}

		if(cr == arr.length - 1){
			return arr[cr][cc];
		}


		int part1 = helper(arr, cr + 1, cc - 1);
		int part2 = helper(arr, cr + 1, cc + 1);

		return Math.min(part1, part2) + arr[cr][cc];
	}

	public static int helperTD(int[][] arr, int cr, int cc, int[][] strg){

		if(cc < 0 || cc >= arr[0].length || cr >= arr.length){
			return 100000;
		}

		if(cr == arr.length - 1){
			return arr[cr][cc];
		}

		if(strg[cr][cc] != 0){
			return strg[cr][cc];
		}

		int part1 = helperTD(arr, cr + 1, cc - 1, strg);
		int part2 = helperTD(arr, cr + 1, cc + 1, strg);

		return strg[cr][cc] = Math.min(part1, part2) + arr[cr][cc];
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
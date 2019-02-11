import java.util.*;

public class MaxPathSum{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[][] arr = { {1,3,1},
					  {1,5,1},
					  {4,2,1}};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;

		System.out.println(minPathSum(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static void display2(int[][] arr){

 		System.out.print("[");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print("[");
 			for(int j = 0;j < arr[0].length;j++)
 			System.out.print(arr[i][j] +" ");
 		System.out.print("]");
 		
 		}
 		System.out.println("]");
 	}

	public static int minPathSum(int[][] arr){
	
		return helperBU(arr);

			
	}

	public static int helper(int[][] arr, int cr, int cc){

		if(cr >= arr.length || cc >= arr[0].length)
			return Integer.MAX_VALUE;

		if(cr == arr.length - 1 && cc == arr[0].length - 1)
			return arr[cr][cc];


		int left = helper(arr,cr + 1,cc);
		int right = helper(arr,cr,cc + 1);

		return Math.min(left,right) + arr[cr][cc];
	}	

	public static int helperTD(int[][] arr, int cr, int cc,int[][] strg){

		if(cr >= arr.length || cc >= arr[0].length)
			return Integer.MAX_VALUE;

		if(cr == arr.length - 1 && cc == arr[0].length - 1)
			return arr[cr][cc];

		if(strg[cr][cc] != 0)
			return strg[cr][cc];


		int left = helperTD(arr,cr + 1,cc,strg);
		int right = helperTD(arr,cr,cc + 1,strg);

		int ans = Math.min(left,right) + arr[cr][cc];
		strg[cr][cc] = ans;
		return ans;
	}	

	public static int helperBU(int[][] arr){

		int er = arr.length;
		int ec = arr[0].length;

		int[][] strg = new int[er + 1][ec + 1];

		// strg[er - 1][ec - 1] = arr[er - 1][ec - 1];

		for(int i = er;i >= 0;i--){

			for(int j = ec; j >= 0;j--){


				if(i == er - 1 && j == ec - 1){
					strg[i][j] = arr[i][j];
					continue;
				}
				if(i == er || j == ec){
					strg[i][j] = Integer.MAX_VALUE;
					continue;
				}

				int left = strg[i + 1][j];
				int right = strg[i][j + 1];

				int ans = Math.min(left,right) + arr[i][j];
				strg[i][j] = ans;
			}
		}

		return strg[0][0];
	}
}
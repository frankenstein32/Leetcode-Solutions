import java.util.*;

public class Unique_Path2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[][] arr = { {0,0,0},
					  {0,1,0},
					  {0,0,0}};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;

		System.out.println(uniquePathsWithObstacles(arr));
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

	public static int uniquePathsWithObstacles(int[][] arr){
	
		System.out.println(helperTD(arr,0,0,new int[arr.length][arr[0].length]));
		System.out.println(helperBU(arr));
		return 0;

			
	}

	public static int helper(int[][] arr, int cr, int cc){

		if(cr >= arr.length || cc >= arr[0].length || arr[cr][cc] == 1)
			return 0;

		if(cr == arr.length - 1 && cc == arr[0].length - 1){
			return 1;
		}


		int cnt = 0;
		
		cnt += helper(arr,cr + 1,cc);
		cnt += helper(arr,cr,cc + 1);	

		return cnt;	


	}

	public static int helperTD(int[][] arr, int cr, int cc,int[][] strg){

		if(cr >= arr.length || cc >= arr[0].length || arr[cr][cc] == 1)
			return 0;

		if(cr == arr.length - 1 && cc == arr[0].length - 1){
			return 1;
		}

		if(strg[cr][cc] != 0)
			return strg[cr][cc];

		int cnt = 0;
		
		cnt += helperTD(arr,cr + 1,cc,strg);
		cnt += helperTD(arr,cr,cc + 1,strg);	

		strg[cr][cc] = cnt;
		return cnt;	


	}

	public static int helperBU(int[][] arr){

		int er = arr.length;
		int ec = arr[0].length;

		 int[][] strg = new int[er + 1][ec + 1];

		 for(int row = er - 1; row >= 0;row--){

		 	for(int col = ec - 1;col >= 0;col--){

		 		if(arr[row][col] == 1){
		 			continue;
		 		}
		 		if(row == er - 1 && col == ec - 1){
		 			strg[row][col] = 1;
		 			continue;
		 		}

		 		int cnt = 0;
		 		cnt += strg[row + 1][col];
		 		cnt += strg[row][col + 1];

		 		strg[row][col] = cnt;

		 	}
		 }

		 // display2(strg);
		 return strg[0][0];


	}
	
	
}
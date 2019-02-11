import java.util.*;

public class Unique_Path{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 2, 1, 0, 4};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		System.out.println(uniquePaths(3,4));
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

	public static int uniquePaths(int m,int n){
	
		// System.out.println(helper(1,1,n,m));
		System.out.println(helperTD(1,1,n,m,new int[n + 1][m + 1]));
		System.out.println(helperBU(n,m));
		return 0;

			
	}

	public static int helper(int cr,int cc,int er,int ec){

		if(cr == er && cc == ec){
			return 1;
		}

		if(cr > er || cc > ec)
			return 0;


		int cnt = 0;
		cnt += helper(cr,cc + 1,er,ec);
		cnt += helper(cr + 1,cc,er,ec);

		return cnt;


	}
	public static int helperTD(int cr,int cc,int er,int ec,int[][] strg){

		if(cr == er && cc == ec){
			return 1;
		}

		if(cr > er || cc > ec)
			return 0;

		if(strg[cr][cc] != 0)
			return strg[cr][cc];

		int cnt = 0;
		cnt += helperTD(cr,cc + 1,er,ec,strg);
		cnt += helperTD(cr + 1,cc,er,ec,strg);


		strg[cr][cc] = cnt;
		return cnt;


	}

	public static int helperBU(int er, int ec){

		 int[][] strg = new int[er + 2][ec + 2];

		 for(int row = er; row >= 1;row--){

		 	for(int col = ec;col >= 1;col--){


		 		if(row == er && col == ec){
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
		 return strg[1][1];


	}

	
}
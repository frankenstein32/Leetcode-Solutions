import java.util.*;

public class WordSearch{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		display2(print(3));

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

 	public static int[][] print(int n){

 		int[][] mat = new int[n][n];
 		int count = 1;

 		int minRow = 0;
 		int maxRow = n - 1;
 		int minCol = 0;
 		int maxCol = n - 1;

 		while(count <= n * n){

 			for(int col = minCol;col <= maxCol && count <= n * n;col++){

 				mat[minRow][col] = count;
 				count++;
 			}

 			minRow++;

 			for(int row = minRow;row <= maxRow && count <= n * n;row++){
 				mat[row][maxCol] = count;
 				count++;
 			}

 			maxCol--;

 			for(int col =  maxCol;col >= minCol && count <= n * n;col--){
 				mat[maxRow][col] = count;
 				count++;
 			}

 			maxRow--;

 			for(int row = maxRow;row >= minRow && count <= n * n; row--){

 				mat[row][minCol] = count;
 				count++;
 			}
 			minCol++;


 		}

 		return mat;
 	} 
}

import java.util.*;

public class  Toeplitz_Matrix{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] matrix = {{11,74,0,93},{40,11,74,7}};
		int k = 4;
		// display2(arr);
		
		System.out.println(isToeplitzMatrix(matrix));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static boolean isToeplitzMatrix(int[][] matrix){

		
		for(int row = matrix.length - 1;row >= 0;row--){

			int col = 0;
			int temp = row;
			while(temp + 1< matrix.length && col + 1 < matrix[0].length){

				if(matrix[temp][col] != matrix[temp + 1][col + 1]){
					return false;
				}

				temp += 1;
				col += 1;
			}
		}

		for(int col = 0;col < matrix[0].length;col++){

			int row = 0;
			int temp = col;
			while(temp + 1< matrix[0].length && row + 1 < matrix.length){

				if(matrix[row][temp] != matrix[row + 1][temp + 1]){
					return false;
				}

				temp += 1;
				row += 1;
			}
		}

		return true;
		
	}
	public static boolean isToeplitzMatrix_eff(int[][] matrix){

		
		for(int row = 0;row < matrix.length;row++){
			for(int col = 0; col < matrix[0].length;col++){

				if(row > 0 && col > 0 && matrix[row - 1][col - 1] != matrix[row][col]){
					return false;
				}
			}
		}
		return true;
		
	}
	
		
}

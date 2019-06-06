import java.util.*;

public class searchMatrix2{


	public static void main(String[] args){


		int[][] nums = {{},{}};
		int k = 1;

		System.out.println(search(nums));

	}

	public static boolean search(int[][] matrix, int item){

		
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1){

			return false;
		}	

		int row = 0;
		int col = matrix[row].length;

		while(row < matrix.length && col >= 0){

			if(matrix[row][col] < item){
				row++;
			}else if(matrix[row][col] < item){
				col--;
			}else{
				return true;
			}
		}

		return false;


	}

}
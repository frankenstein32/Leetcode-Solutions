import java.util.*;

public class MinFallingPath{

	public static void main(String[] args){

		int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(MinSum(nums));
		
	}

	public static void display(int[][] piles){

		for(int[] pile : piles){

			for(int stone : pile){
				System.out.print(stone +"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int MinSum(int[][] matrix) {

		// int ans = Integer.MAX_VALUE;

		// int[][] strg = new int[matrix.length][matrix[0].length];
		// for (int col = 0; col < matrix[0].length; col++) {

		// 	ans = Math.min(ans, helperTD(matrix, 0, col,strg));
		// }
		// return ans;

		return helperBU_Eff(matrix);
	}

	public static int helper(int[][] matrix, int row, int col) {

		if (row >= matrix.length || col >= matrix[0].length || col < 0) {
			return Integer.MAX_VALUE;
		}

		if (row == matrix.length - 1) {
			return matrix[row][col];
		}

		int res = 0;

		int prev = 0, curr = 0, next = 0;
		prev = helper(matrix, row + 1, col - 1);
		curr = helper(matrix, row + 1, col);
		next = helper(matrix, row + 1, col + 1);
		res = Math.min(prev, Math.min(curr, next)) + matrix[row][col];

		return res;
	}
	
	public static int helperTD(int[][] matrix, int row, int col, int[][] strg){

		if (row >= matrix.length || col >= matrix[0].length || col < 0) {
			return Integer.MAX_VALUE;
		}

		if (row == matrix.length - 1) {
			return matrix[row][col];
		}

		if(strg[row][col] != 0){
			return strg[row][col];
		}

		int res = 0;

		int prev = 0, curr = 0, next = 0;
		prev = helperTD(matrix, row + 1, col - 1,strg);
		curr = helperTD(matrix, row + 1, col,strg);
		next = helperTD(matrix, row + 1, col + 1,strg);
		res = Math.min(prev, Math.min(curr, next)) + matrix[row][col];

		strg[row][col] = res;
		return res;

	}

	public static int helperBU(int[][] matrix){

		int[][] strg = new int[matrix.length][matrix[0].length];

		int res = Integer.MAX_VALUE;

		for(int row = matrix.length - 1;row >= 0;row--){

			for(int col = matrix[0].length - 1; col >= 0;col--){

				if(row == matrix.length - 1){
					strg[row][col] = matrix[row][col];
					continue;
				}

				int ans = Integer.MAX_VALUE;
				if(col - 1  >= 0){
					ans = Math.min(ans, strg[row + 1][col - 1]);
				}

				ans = Math.min(ans, strg[row + 1][col]);

				if(col + 1 < matrix[0].length){
					ans = Math.min(ans, strg[row + 1][col + 1]);
				}

				strg[row][col] = ans + matrix[row][col];
				
			}
		}

		for(int col = 0; col < matrix[0].length;col++){

			res = Math.min(res, strg[0][col]);
		}
		return res;

	}

	public static int helperBU_Eff(int[][] matrix){


		int[] strg = new int[matrix[0].length];

		for(int row = matrix.length - 1; row >= 0; row--){

			int temp = strg[matrix[0].length - 1];
			for(int col = matrix[0].length - 1; col >= 0;col--){

				if(row == matrix.length - 1){
					strg[col] = matrix[row][col];
					continue;
				}

				int prev = Integer.MAX_VALUE;
				int curr = Integer.MAX_VALUE;
				int next = temp;

				if(col - 1 >= 0){

					prev = strg[col - 1];
				}

				curr = strg[col];

				if(col < strg.length){
					next = temp;
					temp = strg[col];
				}

			
				strg[col] = Math.min(curr, Math.min(next,prev)) + matrix[row][col];
			}


		}

		int res = Integer.MAX_VALUE;

		for(int col = 0;col < matrix[0].length;col++){

			res = Math.min(res, strg[col]);
		}


		return res;
	}

	public static void display2(int[] arr){


		for(int val : arr){
			System.out.print(val + " ");
		}

		System.out.println();
	}


}
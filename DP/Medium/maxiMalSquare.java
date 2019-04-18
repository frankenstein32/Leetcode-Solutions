import java.util.*;

public class maxiMalSquare{

	public static void main(String[] args){

		String s1 = "123";

		char[][] mat = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maxLen(mat));
		
	}

	public static int maxLen(char[][] mat){

		 return helper(mat, 0, 0);
	}

	public static int helper(char[][] mat, int row, int col){

		if(row < 0 || row >= mat.length8 || col < 0 || col >= mat[0].length){
			return Integer.MAX_VALUE;
		}

		int maxLen = 0;

		for(int i = row; i < mat.length;i++){

			for(int j = col; j < mat[0].length;j++){

				if(mat[i][j] == '1'){

					int upper = helper(mat, i - 1,j);
					int diag = helper(mat, i - 1,j - 1);
					int lower = helper(mat, i,j - 1);

					int ans = Math.min(upper, Math.min(diag, lower));

					if(ans != Integer.MAX_VALUE){
						ans = ans + 1;
					}

					maxLen = Math.max(maxLen, ans);
				}
			}
		}
		
		return maxLen;
			
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
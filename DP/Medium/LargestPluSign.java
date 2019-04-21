import java.util.*;

public class LargestPluSign{

	public static void main(String[] args){

		int N = 5;
		int[][] mines = {{3, 0}, {3, 3}};
		System.out.println(largestplus(N, mines));
	}

	public static int largestplus(int N, int[][] mines){

		int[][] board = new int[N][N];

		for(int[] val : board)
			Arrays.fill(val, N);

		for(int i = 0;i < mines.length;i++){
			board[mines[i][0]][mines[i][1]] = 0;
		}

		for(int i = 0;i < N;i++){
			for(int j = 0,k = N - 1,l = 0, r = 0, u = 0, d = 0; j < N;j++, k--){
				board[i][j] = Math.min(board[i][j], l = (board[i][j] == 0 ? 0 : l + 1));
				board[i][k] = Math.min(board[i][k], r = (board[i][k] == 0 ? 0 : r + 1));
				board[k][i] = Math.min(board[k][i], u = (board[k][i] == 0 ? 0 : u + 1));
				board[j][i] = Math.min(board[j][i], d = (board[j][i] == 0 ? 0 : d + 1));
			}
		}

		int max = 0;
		for(int i = 0;i < board.length;i++){
			for(int j = 0;j < board[0].length;j++){

				max = Math.max(board[i][j], max);
			}
		}

		return max;
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
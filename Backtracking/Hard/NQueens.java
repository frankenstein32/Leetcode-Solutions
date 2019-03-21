import java.util.*;

public class NQueens{

	public static void main(String[] args){


		int n = 4;
		System.out.println(NQueens(n));

	}

	public static List<List<String>> NQueens(int n){

	 char[][] board = new char[n][n];

		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){

				board[i][j] = '.';
			}
		}
    
        ans = new ArrayList<>();
		NQueens(board,0,0,n,0);


		return ans;
	}

	static List<List<String>> ans = new ArrayList<>();

	public static void NQueens(char[][] board, int row, int col, int tq, int psf){

		if(psf == tq){

			List<String> res = new ArrayList<>();
			for(int i = 0;i < board.length;i++){

				StringBuilder sb = new StringBuilder();
				for(int j = 0;j < board[0].length;j++){

					sb.append(board[i][j]);
				}
				res.add(sb.toString());
			}
            
            return;
        }

		if(col == board[0].length){

			NQueens(board, row + 1, 0, tq, psf);
			return;
		}

		if(row == board.length){
			return;
		}

		if(isItSafe(board,row, col)){

			board[row][col] = 'Q';
			NQueens(board, row, col + 1, tq, psf + 1);
			board[row][col] = '.';
		}

		NQueens(board, row, col + 1, tq, psf);

		}

	public static boolean isItSafe(char[][] board, int row, int col){

		int r, c;
		
		// Left
		r = row;
		c = col - 1;
		while(c >= 0){

			if(board[r][c] == 'Q'){
				return false;
			}
			c--;
		}

		//Up
		r = row - 1;
		c = col;
		while(r >= 0){

			if(board[r][c] == 'Q'){
				return false;
			}
			r--;
		}

		//Diagonal Left
		r = row - 1;
		c = col - 1;
		while(r >= 0 && c >= 0){

			if(board[r][c] == 'Q'){
				return false;
			}

			r--;
			c--;
		}

		//Diagonal right
		r = row - 1;
		c = col + 1;
		while(r >= 0 && c < board[0].length){

			if(board[r][c] == 'Q'){
				return false;
			}

			r--;
			c++;
		}

		return true;

	}
}
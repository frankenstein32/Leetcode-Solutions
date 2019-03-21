import java.util.*;

public class SudokuSolver{

	public static void main(String[] args){


		String s = "a*";
		String p = "aa";
		System.out.println(isMatch(s,p));

	}

	public static void solveSudoku(char[][] board){


				System.out.println(solve(board,0,0));
	}

	public static boolean solve(char[][] board, int row,int col){

        if(row == board.length){
			return true;
		}
        
		if(col == board[0].length){

			boolean rr = solve(board,row + 1, 0);
            
            if(rr)
                return true;
		}

		
        if(board[row][col] != '.'){

			boolean rr = solve(board, row + 1,0);
            
            if(rr) return rr;
		}



		for(int digit = 1;digit <= 9;digit++){

			if(isItSafe(board,row,col, digit)){

				board[row][col] = (char)(digit + 48);
				boolean rr = solve(board,row + 1,col);

				if(rr) return rr;

				board[row][col] = '.';
			}

		}
        
        return false;
	}

	public static boolean isItSafe(char[][] board,int row,int col, int digit){

		return isItSafeRow(board,row,digit) && isItSafeCol(board,col,digit)
			   && isItSafeBlock(board,row,col,digit);

	}

	public static boolean isItSafeRow(char[][] board,int row, int digit){

		for(int i = 0;i < board[0].length;i++){

			if(board[row][i] - '0' == digit){
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(char[][] board, int col, int digit){

		for(int i = 0;i < board.length;i++){

			if(board[i][col] - '0' == digit){
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeBlock(char[][] board, int row, int col, int digit){

		int rs = row - row % 3;
		int cs = col - col % 3;

		for(int r = rs; r < rs + 3;r++){

			for(int c = cs; c < cs + 3;c++){

				if(board[r][c] - '0' == digit){
					return false;
				}
			}
		}

		return true;
	}
}
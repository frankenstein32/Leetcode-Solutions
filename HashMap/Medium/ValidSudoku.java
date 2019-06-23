import java.util.*;

public class ValidSudoku{

    public boolean isValidSudoku(char[][] board){

      

      for(int i = 0;i < 9;i++){

        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> diag = new HashSet<>();

        for(int j = 0;j < 9;j++){

          if(board[i][j] != '.' && !row.add(board[i][j])){
            return false;
          }

          if(board[j][i] != '.' && !col.add(board[j][i])){
            return false;
          }

          int rowIndex = 3 * (i / 3);
          int colIndex = 3 * (i % 3);

          if(board[rowIndex + j / 3][colIndex + j % 3] != '.' && !diag.add(board[rowIndex + j / 3][colIndex + j % 3] )){
            return false;
          }
        }
      }

      return true;
    }
}



	
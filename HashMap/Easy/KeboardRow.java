import java.util.*;

class KeboardRow{

   public int islandPerimeter(int[][] grid){

    int sum = 0;
    if(grid == null || grid.length == 0 || grid[0].length == 0)
      return sum;

    for(int i = 0;i < grid.length;i++){
      for (int j = 0; j < grid[0].length ; j++) {
          
          if(grid[i][j] == 0)
            continue;

          if(i == 0 || grid[i - 1][j] == 0) sum++;
          if(i == grid.length || grid[i + 1][j] == 0) sum++;
          if(j == 0 || grid[i][j - 1] == 0) sum++;
          if(j == grid[0].length || grid[i][j + 1] == 0) sum++; 
      }
    }

    return sum;
   }
}



	
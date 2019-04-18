import java.util.*;

public class MaxAreaCovered{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        char[][] arr ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        int k = 4;
        // display2(arr);
        
        System.out.println(exist(arr,word))       ;

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

   public static int maxAreaLand(int[][] grid){

        

        int ans = 0;

        for(int r = 0; r < grid.length;r++){

            int[][] seen = new int[grid.length][grid[0].length];
            for(int c = 0; c < grid[0].length;j++){

                ans = Math.max(ans, maxArea(grid, r ,c, seen));
            }
        }

        return ans;
   }

   public static int maxArea(int[][] grid, int cr, int cc,boolean[][] visited){


        if  (cr < 0 || cr >= grid.length || cc < 0 || cc >= grid[0].length 
            || visited[cr][cc] || grid[cr][cc] == 0){
            return 0;
        }
        visited[cr][cc] = true;
        int ans = maxArea(cr + 1, cc) + maxArea(cr, cc + 1) + maxArea(cr + 1, cc + 1) +
                    maxArea(cr - 1, cc) + maxArea(cr,cc - 1) + maxArea(cr - 1, cc - 1) + 1;
        visited[cr][cc] = false;

        return ans;

   }
} 


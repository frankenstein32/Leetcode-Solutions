import java.util.*;

public class MaxiMumTriangle{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        char[][] charray = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};

        System.out.println(maxArea(matrix));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

     public static int maxArea(char[][] matrix) {


      if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        return 0;
      }

      int m = matrix.length;
      int n = matrix[0].length;
      int area = 0;
      int[] h = new int[n];

      for(int row = 0;row < m;row++){

        for(int col = 0; col < n;col++){

          if(matrix[row][col] == '1'){
            h[col]++;
          }else{
            h[col] = 0;
          }

          int height = h[col];

          for(int j = col - 1; j >= 0;j--){

            if(h[j] == 0){
              break;
            } 

            height = Math.min(height,h[j]);
            int width = col - j + 1;

            area = Math.max(area, height * width);
          }

          area = Math.max(area, h[col]);
        }
      }


      return area;

    }

    
}
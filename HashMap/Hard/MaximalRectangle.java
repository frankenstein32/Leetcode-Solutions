import java.util.*;

public class MaximalRectangle{
    
    public int maximalRectangle(int[][] matrix){

    	if(matrix == null || matrix.length || matrix[0].length == 0){
    		return 0;
    	}

    	int area = 0;
    	int m = matrix.length;
    	int n = matrix[0].length;

    	int[] height = new int[n];

    	for(int row = 0;row < m;row++){

    		for(int col = 0;col < n;col++){

    			if(matrix[row][col] == 1){
    				h[col]++;
    			}else{
    				h[col] = 0;
    			}

    			int height = h[col];

    			for(int j = col - 1; j >= 0;j--){

    				if(h[j] == 0){
    					break;
    				}

    				height = Math.min(height, h[j]);
    				int width = col - j + 1;
    				area = Math.max(area, height * width);
    			}

    			area = Math.max(area, h[col]);
    		}
    	}

    	return area;
    }
}
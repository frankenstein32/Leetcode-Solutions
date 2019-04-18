class NumMatrix {

	int[][] strg;

    public NumMatrix(int[][] matrix) {

    	strg = new int[matrix.length][matrix[0].length];

    	for(int row = 0; row < matrix.length;row++){

    		for(int col = 0;col < matrix[0].length;col++){
                
                if(col == 0){
                    this.strg[row][col] = matrix[row][col];
                    continue;
                }

    			this.strg[row][col] = strg[row][col - 1] + matrix[row][col];

    		}
    	}
    }

    public NumMatrix2(int[][] matrix) {

    	strg = new int[matrix.length][matrix[0].length];

    	for(int row = 0; row < matrix.length;row++){

    		for(int col = 0;col < matrix[0].length;col++){
                
    			this.strg[row][col] = strg[row + 1][col] + strg[row][col + 1] + matrix[row][col] - strg[row][col];

    		}
    	}
    }

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        	
       return strg[row2 + 1][col2 + 1] - strg[row1][col2 + 1] - strg[row2 + 1][col1] + strg[row1][col1];
   
    }	
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        	
        int sum = 0;

        for(int row = row1; row <= row2;row++){
            
            if(col1 - 1 >= 0){
                sum += strg[row][col2] - strg[row][col1 - 1];

            }else{
                 sum += strg[row][col2] ;
            }
        }

        return sum;
   
    }	

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
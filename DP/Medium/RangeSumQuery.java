class NumMatrix {

	int[][] strg;

    public NumMatrix(int[][] matrix) {

    	strg = new int[matrix.length][matrix[0].length];

    	for(int row = 0; row < matrix.length;row++){

    		for(int col = 1;col < matrix[0].length;col++){

    			this.strg[row][col] = matrix[row][col - 1] + matrix[row][col];

    		}
    	}
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        	
        int sum = 0;

        for(int row = row1; row <= row2;row++){

        	sum += strg[row][col2] - strg[row][col1];
        }

        return sum;
    }	

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
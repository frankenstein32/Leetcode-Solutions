import java.util.*;

class DeleteColsToMakeSorted{

	public int minDeletionSize(String[] A){

		int res = 0;

		for(int col = 0;col < A[0].length();col++){
			for(int row = 0;row < A.length;j++){
				if(A[row].get(col) > A[row].get(col + 1)){
						res++;
				}	
			}
		}


		return res;


	}
}



	
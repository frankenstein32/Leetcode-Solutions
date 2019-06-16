import java.util.*;

public class FlipColumns{
	

	public int maxEqualRowsAfterFlips(int[][] matrix){


		int ans = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		for(int i = 0;i < matrix.length;i++){

			int count = 0;
			int[] flip = new int[n];
			for(int j = 0; j < matrix[0].length;j++){

				flip[j] = 1 - matrix[i][j];
			}

			for(int k = 0;k < matrix.length;k++){

				if(Arrays.equals(matrix[k],matrix[i]) || Arrays.equals(matrix[k],flip)){
					count++;
				}
			}

			ans = Math.max(count, ans);
		}

		return ans;
	}

	public int AnotherApproach(int[][] matrix){

		Map<String, Integer> map = new HashMap<>();
		int res = 0;

		for(int[] row : matrix){

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			for(int i : row){
				sb1.append(i);
				sb1.append(1 - i);
			}

			String str1 = sb1.toString();
			String str2 = sb2.toString();

			map.put(str1, map.getOrDefault(str1, 0) + 1);
			map.put(str2, map.getOrDefault(str2, 0) + 1);
		}

		for(int val : map.values()){
			res = Math.max(val);
		}

		return res;
	}
}
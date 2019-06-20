import java.util.*;

class K_Negotiations{

	
	public int largestSumAfterKNegotiations(int[] A, int k){

		Arrays.sort(A);
		int minPos = Integer.MAX_VALUE;
		int sum = 0;
		int cnt = 0;

		for(int num : A){

			if(num < 0 && ++cnt <= k){
				
				num = -num;
			}

			sum += num;
			minPos = Math.min(minPos, num);
		}

		if(cnt > k || k - cnt % 2 == 0){

			return sum;
		}else{

			return sum - minPos * 2;
		}


	}
}



	
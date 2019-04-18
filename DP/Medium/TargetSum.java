import java.util.*;

public class TargetSum{

	public static void main(String[] args){

		// Main
		int[] arr = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(findWays(arr, target));

		
	}

	public static int findWays(int[] arr, int target){

		int sum = 0;
		for(int val : arr)
			sum += val;

		int[][] strg = new int[arr.length][2*sum + target + 1];

		for(int[] val : strg){
			Arrays.fill(val, -1);
		}

		// System.out.println(target +" "+sum+"\n");

		System.out.println(helperBU(arr, target));
		System.out.println(helperTD(arr, 0, target + sum, strg , sum));
		return helper(arr, 0, target);
	}

	public static int helper(int[] arr, int vidx, int target){

		int ans = 0;

		if( vidx == arr.length){

			if(target == 0){
				return 1;
			}
			return 0;
		}
			
		ans += helper(arr, vidx + 1, target - arr[vidx]);
		ans += helper(arr, vidx + 1, target + arr[vidx]);

		return ans;
	}

	public static int helperTD(int[] arr, int vidx, int target, int[][] strg , int sum){

		int ans = 0;

		if( vidx == arr.length){

			if(target == sum){
				return 1;
			}
			return 0;
		}

		// System.out.println(vidx +" "+target);
		if(strg[vidx][target] != -1){
			return strg[vidx][target];
		}
		ans += helperTD(arr, vidx + 1, target - arr[vidx], strg , sum);
		ans += helperTD(arr, vidx + 1, target + arr[vidx], strg ,sum);

		return strg[vidx][target] = ans;
		// return ans;
	}

	public static int helperBU(int[] arr, int target){

		int sum = 0;
		for(int val : arr)
			sum += val;

		int[][] strg = new int[arr.length + 1][2 * sum + target + 1];

		for(int row = 0;row < strg.length;row++){

			for(int col = ;col < 2 * sum + target + 1 ;col++){

				if(row == strg.length){

					if(col == sum){
						strg[row][col] = 1;
					}

					continue;
				}

				strg[row][col] = strg[row + 1][col - arr[row]] + strg[row + 1][col + arr[row]];

			}

		}

		display(strg);
		return strg[0][sum  + target];
	}

	public int helperBU_EFF(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        	if(s>sum || s<-sum) return 0;
        		int[] dp = new int[2*sum+1];
        	
        	dp[sum] = 1;
        	
        	for(int i = 0; i<nums.length; i++){
            	int[] next = new int[2*sum+1];
            	for(int k = 0; k<2*sum+1; k++){
                	if(dp[k]!=0){
                    	next[k + nums[i]] += dp[k];
                    	next[k - nums[i]] += dp[k];
               		 }
            	}
            	
            	dp = next;
        	}
        
        return dp[sum+s];
    }


	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

	

	
}
import java.util.*;

public class PartitionEqualSubsetSum{

	public static void main(String[] args){

		// Main
		int[] nums = {1, 2, 5};
		System.out.println(partitionSum(nums));

		
	}

	public static boolean partitionSum(int[] nums){

		int sum = 0;
		for(int i = 0;i < nums.length;i++)
			sum += nums[i];

		 if((sum) % 2 == 1){
	       return false;
	    }

	    	int[][] strg =  new int[nums.length + 1][sum + 1];

		for(int[] val : strg){

			Arrays.fill(val, -1);	
		}

		System.out.println(helperBU_EFF(nums));
		System.out.println(helperBU(nums));
	    System.out.println(helperTD2(nums, nums.length - 1, sum/2,strg));
		System.out.println(helper2(nums, nums.length - 1, sum/2));
		return helper(nums, 0, 0, 0);
	}

	public static boolean helper(int[] nums, int vidx, int sum1, int sum2){

		if(vidx == nums.length){

			if(sum1 == sum2){
				return true;
			}else{
				return false;
			}
		}

		return helper(nums, vidx + 1, sum1 + nums[vidx],sum2) || helper(nums, vidx + 1, sum1, sum2 + nums[vidx]);
	}

	public static boolean helper2(int[] nums, int vidx, int totSum){

		if(totSum == 0){
			return true;
		}

		if(vidx <= 0 || vidx == nums.length){
			return false;
		}


		for(int i = vidx;i > 0;i--){

			boolean inc = helper2(nums, i - 1,totSum - nums[i]);
			boolean exc = helper2(nums, i - 1, totSum);

			if(inc || exc){
				return true;
			}
		}

		return false;

	}

	public static boolean helperTD2(int[] nums, int vidx, int totSum, int[][] strg){


		if(totSum == 0){
			return true;
		}

		if(vidx <= 0 || vidx == nums.length){
			return false;
		}

		if(strg[vidx][totSum] != -1){
			return (strg[vidx][totSum] == 1? true : false);
		}
		
		for(int i = vidx;i > 0;i--){

			boolean inc = false;
			
			if(totSum >= nums[i])
				inc = helperTD2(nums, i - 1,totSum - nums[i],strg);
			boolean exc = helperTD2(nums, i - 1, totSum, strg);

			if(inc || exc){
				strg[vidx][totSum] = 1;
				return true;
			}
		}

		strg[vidx][totSum] = 0;
		return false;
	}

	public static boolean helperBU(int[] nums){

		int sum = 0;
		for(int val : nums){
			sum += val;
		}

		if((sum) % 2 == 1){
	       return false;
	    }

		int[][] strg = new int[nums.length][sum/2 + 1];

		
		for(int row = 0;row < strg.length;row++){

			for(int col = 0; col < strg[0].length;col++){

				if(col == 0){
					strg[row][col] = 1;
					continue;
				}


				if(row == 0){

					strg[row][col] = 0;
					continue;
				}

				int inc = 0, exc = 0;

				if(col >= nums[row - 1]){
					inc = strg[row - 1][col - nums[row - 1]];
				}

				exc = strg[row - 1][col];

				strg[row][col] = (inc == 1 || exc == 1 ? 1 : 0);
			}

		}		

		display(strg);
		return (strg[strg.length - 1][sum/2] == 1 ? true : false);
	}

	public static boolean helperBU_EFF(int[] nums){

		int sum = 0;
		for(int val : nums){
			sum += val;
		}

		if((sum) % 2 == 1){
	       return false;
	    }

		int[] strg = new int[sum/2 + 1];

		
		for(int row = 0;row < nums.length;row++){
			for(int col = sum/2; col > 0;col--){

				if(col == 0){
					strg[col] = 1;
					continue;
				}

				if(row == 0){
					continue;
				}

				int inc = 0, exc = 0;

				if(col >= nums[row]){
					inc = strg[col - nums[row]];
				}

				exc = strg[col];
				strg[col] = (inc == 1 || exc == 1 ? 1 : 0);
			}	
			for(int val : strg){
				System.out.print(val+" " );
			}
			
			System.out.println();

		}		

		for(int val : strg){
			System.out.print(val+" " );
		}
		System.out.println();
		return (strg[sum/2] == 1 ? true : false);

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
import java.util.*;

public class HouseRobber{

	public static void main(String[] args){

		int[] nums = {2,7,9,3,1};
		System.out.println(robbed(nums));
		
	}

	public static int robbed(int[] nums){

		System.out.println(helperBU(nums));
		System.out.println(helperTD(nums, 0, new int[nums.length]));
		return helper(nums, 0);
	}

	public static int helper(int[] nums, int vidx){


		if(vidx >= nums.length){
			return 0;
		}

		if(vidx + 1 == nums.length){
			return nums[vidx];
		}

		int house1 = helper(nums, vidx + 2) + nums[vidx];
		int house2 = helper(nums, vidx + 3) + nums[vidx + 1];

		int ans = Math.max(house1, house2);
		return ans;
	}

	public static int helperTD(int[] nums, int vidx, int[] strg){


		if(vidx >= nums.length){
			return 0;
		}

		if(vidx + 1 == nums.length){
			return nums[vidx];
		}

		if(strg[vidx] != 0){
			return strg[vidx];
		}

		int house1 = helperTD(nums, vidx + 2, strg) + nums[vidx];
		int house2 = helperTD(nums, vidx + 3, strg) + nums[vidx + 1];

		int ans = Math.max(house1, house2);
		strg[vidx] = ans;
		return ans;


	}

	public static int helperBU(int[] nums){

		int n = nums.length;
		int[] strg = new int[n + 2];

		for(int i = n - 1;i >= 0;i--){

			if(i == n - 1){
				strg[i] = nums[i];
				continue;
			}

			strg[i] = Math.max(strg[i + 2] + nums[i], strg[i + 3] + nums[i + 1]);
		}

		return strg[0];
	}
}
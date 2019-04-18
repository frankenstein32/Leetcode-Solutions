import java.util.*;

public class HouseRobber2{

	public static void main(String[] args){

		int[] nums = {1, 2};
		System.out.println(robbed(nums));
		
	}

	public static int robbed(int[] nums){

		if(nums.length == 1){
            return nums[0];
        }

		int startFromFirst = helperTD(nums, 0, nums.length - 2, new int[nums.length + 1]);
		int startFromSecond = helperTD(nums, 1, nums.length - 1, new int[nums.length + 1]);

		System.out.println(helperBU(nums));
		return Math.max(startFromFirst, startFromSecond);
	}

	public static int helper(int[] nums, int vidx, int ei){


		if(vidx > ei){
			return 0;
		}

		if(vidx == ei){
			return nums[vidx];
		}

		int house1 = helper(nums, vidx + 2, ei) + nums[vidx];
		int house2 = helper(nums, vidx + 3, ei) + nums[vidx + 1];

		int ans = Math.max(house1, house2);
		return ans;
	}

	public static int helperTD(int[] nums, int vidx, int ei, int[] strg){


		if(vidx > ei){
			return 0;
		}

		if(vidx == ei){
			return nums[vidx];
		}

		if(strg[vidx] != 0){
			return strg[vidx];
		}

		int house1 = helperTD(nums, vidx + 2, ei, strg) + nums[vidx];
		int house2 = helperTD(nums, vidx + 3, ei, strg) + nums[vidx + 1];

		int ans = Math.max(house1, house2);
		strg[vidx] = ans;
		return ans;
	} 

	public static int helperBU(int[] nums){


		int[] strg1 = new int[nums.length + 1];
		int[] strg2 = new int[nums.length + 2];

		for(int i = nums.length - 2;i >= 0;i--){

			if(i == nums.length - 2){
				strg1[i] = nums[i];
				continue;
			}

			strg1[i] = Math.max(strg1[i + 2] + nums[i], strg1[i + 3] + nums[i + 1]);

		}


		for(int i = nums.length - 1;i >= 1;i--){

			if(i == nums.length - 1){
				strg2[i] = nums[i];
				continue;
			}

			strg2[i] = Math.max(strg2[i + 2] + nums[i], strg2[i + 3] + nums[i + 1]);

		}

		display(strg1);
		display(strg2);
		return Math.max(strg1[0], strg2[1]);


	}

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

}
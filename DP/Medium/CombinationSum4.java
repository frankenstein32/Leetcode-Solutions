import java.util.*;

public class CombinationSum4{

	public static void main(String[] args){

		int[] nums = {1, 2, 3};
		System.out.println(comb(nums,4));
		
	}

	public static int comb(int[] nums, int item){

		int[] strg = new int[item + 1];

		Arrays.fill(strg, -1);
		System.out.println(helperBU(nums, item));
		System.out.println(helperTD(nums, item, strg));
		return helper(nums,item);
	}

	public static int helper(int[] nums, int item){

		if(item == 0){
			return 1;
		}

		int res = 0;
		for(int i = 0;i < nums.length;i++){

			if(item >= nums[i]){
				res += helper(nums, item - nums[i]);
			}
		}

		return res;
	}

	public static int helperTD(int[] nums, int item, int[] strg){

		if(item == 0){
			return 1;
		}

		if(strg[item] != -1){
			return strg[item];
		}

		int res = 0;
		for(int i = 0;i < nums.length;i++){

			if(item >= nums[i]){
				res += helperTD(nums, item - nums[i], strg);
			}
		}

		strg[item] = res;

		return res;

	}

	public static int helperBU(int[] nums, int target){

		int[] strg = new int[target + 1];

		for(int item = 0;item <= target;item++){

			if(item == 0){
				strg[item] = 1;
				continue;
			}

			int res = 0;
			for(int i = 0;i < nums.length;i++){

				if(item >= nums[i])
					res += strg[item - nums[i]];
			}
			strg[item] = res;
			
		}

		return strg[target];

	}
	
}	
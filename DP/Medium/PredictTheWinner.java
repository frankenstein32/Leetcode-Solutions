import java.util.*;

public class PredictTheWinner{

	public static void main(String[] args){

		// Main
		int[] arr = {1, 5, 2};
		int target = 3;
		System.out.println(predict(arr));

		
	}

	public static boolean predict(int[] nums){

		int n = nums.length;
		int[][] strg = new int[n + 1][n + 1];

		for(int[] arr : strg){

			Arrays.fill(arr, Integer.MAX_VALUE);
		}

		System.out.println(helperBU_EFF(nums) >= 0);
		System.out.println(helperBU(nums) >= 0);
		System.out.println(helperTD(nums, 0, nums.length - 1, true, strg) >= 0);
		return helper(nums, 0, nums.length - 1, true) >= 0;
	}

	public static int helper(int[] nums, int si, int ei, boolean turn){

		if(si > ei){
			return 0;
		}

		if(turn){

			int fpart = helper(nums, si + 1, ei, !turn) + nums[si];
			int spart = helper(nums, si, ei - 1, !turn) + nums[ei];

			return Math.max(fpart, spart);
		}else{

			int fpart = helper(nums, si + 1, ei, !turn) - nums[si];
			int spart = helper(nums, si, ei - 1, !turn) - nums[ei];

			return Math.min(fpart, spart);
		}
	}	

	public static int helperTD(int[] nums, int si, int ei, boolean turn, int[][] strg){

		if(si > ei){
			return 0;
		}

		if(strg[si][ei] != Integer.MAX_VALUE){

			return strg[si][ei];
		}

		if(turn){

			int fpart = helperTD(nums, si + 1, ei, !turn, strg) + nums[si];
			int spart = helperTD(nums, si, ei - 1, !turn, strg) + nums[ei];

			return strg[si][ei] = Math.max(fpart, spart);
		}else{

			int fpart = helperTD(nums, si + 1, ei, !turn, strg) - nums[si];
			int spart = helperTD(nums, si, ei - 1, !turn, strg) - nums[ei];

			return strg[si][ei] = Math.min(fpart, spart);
		}
	}	

	public static int helperBU(int[] nums){


		int[][] strg = new int[nums.length][nums.length];

		boolean turn = true;
		if(nums.length % 2 == 0){
			turn = false;
		}

		for(int slide = 0;slide < nums.length;slide++){

			for(int si = 0;si < nums.length - slide;si++){

				int ei = si + slide;

				if(si == ei){

					if(turn){
						strg[si][ei] = nums[si];

					}else{
						strg[si][ei] = -nums[si];
					}
					continue;
				}

				if(turn){

					strg[si][ei] = Math.max(strg[si + 1][ei] + nums[si], strg[si][ei - 1] + nums[ei]);

				}else{

					strg[si][ei] = Math.min(strg[si + 1][ei] - nums[si], strg[si][ei - 1] - nums[ei]);
				}	

		
			}

					turn = !turn;	
		}

		display(strg);
		return strg[0][strg[0].length - 1];

	}

	public static int helperBU_EFF(int[] nums){

		int[] strg = new int[nums.length];

		

		for(int si = nums.length - 1;si >= 0; si--){

			boolean turn = true;
			if(nums.length % 2 == 0){
				turn = false;
			}

			for(int ei = si; ei < nums.length;ei++){

				if(si == ei){

					if(turn){
						strg[ei] = nums[ei];

					}else{
						strg[ei] = -nums[ei];
					}
					turn = !turn;
					continue;
				}

				if(turn){

					strg[ei] = Math.max(strg[ei] + nums[si], strg[ei - 1] + nums[ei]);
				}else{

					strg[ei] = Math.min(strg[ei] - nums[si], strg[ei - 1] - nums[ei]);
				}

				turn = !turn;
			}
			
			display(strg);
		}

		return strg[strg.length - 1];
	}

	public static void display(int[] arr){

		for(int val : arr)
			System.out.print(val+" ");

		System.out.println();
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
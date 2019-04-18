import java.util.*;

public class DeleteEarn{

	public static void main(String[] args){

		int[] nums = {2, 3, 4};
		System.out.println(Earn(nums));
		
	}

	public static int Earn(int[] nums){

		int[] strg = new int[10001];
		Arrays.fill(strg, -1);

		int[] arr = new int[10001];

		for(int num : nums){
			arr[num] += num;
		}

		System.out.println(helperBU_EFF(arr));
		System.out.println(helperBU(arr));
		return helperTD(arr, 0,strg);
		// return helper(arr, 0);

	}

	public static int helper(int[] nums, int vidx){

		if(vidx >= nums.length){
			return 0;
		}

		int inc = helper(nums, vidx + 2) + nums[vidx];
		int exc = helper(nums, vidx + 1);

		return Math.max(inc, exc);
	}

	public static int helperTD(int[] nums, int vidx, int[] strg){

		if(vidx >= nums.length){
			return 0;
		}

		if(strg[vidx] != -1){
			return strg[vidx];
		}

		int inc = helperTD(nums, vidx + 2, strg) + nums[vidx];
		int exc = helperTD(nums, vidx + 1, strg);

		return strg[vidx] = Math.max(inc, exc);
	}

	public static int helperBU(int[] nums){


		int[] strg = new int[nums.length + 2];

		int max = Integer.MIN_VALUE;
		for(int i = strg.length - 1;i >= 0;i--){

			if(i >= nums.length){
				strg[i] = 0;
				continue;
			}

			strg[i] = Math.max(strg[i + 2] + nums[i], strg[i + 1]);
			max =  Math.max(strg[i], max);
		}

		// display(strg);
		return max;
	}

	public static int helperBU_EFF(int[] nums){


		int[] strg = new int[3];
		int n = nums.length;
		int max = Integer.MIN_VALUE;


		for(int i = n - 2;i >= 0;i--){

			strg[0] = Math.max(strg[2] + nums[i], strg[1]);
			strg[2] = strg[1];
			strg[1] = strg[0];
			max =  Math.max(strg[0], max);
		}

		// display(strg);
		return max;
	}

	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}
	

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
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
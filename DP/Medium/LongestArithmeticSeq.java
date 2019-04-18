import java.util.*;

public class LongestArithmeticSeq{

	public static void main(String[] args){

		int[] nums = {25,78,45,27,75,10,90,77,60,8,43,5,55,47,57,17,8,63,18,69,63,87,35,19,78,42,25,27,24,23,88,56,14,42,16,64,8,62,48,76,66,75,59,43,16,11,15,41,20,34,69,69,58,42,22,27,79,81,63,59,57,51,11,48,89,29,30,79,40,87,17,24,16,82,18,9,86,9,90,74,17,21,8,18,24,62,8,31,84,56,70,59,55,22,44,31,11,82,80,38};
		int k = 3;
		System.out.println(maxLen(nums));
		
	}

	public static int maxLen(int[] A){

		// System.out.println(helper2(A, 0, 0));
		int[][][] strg = new int[10001][A.length][A.length + 1];
		System.out.println(helper_TD(A, -1, 0, 0, strg));
		return helper(A, -1, 0,0);
	}

	public static int helper(int[] nums, int prev, int curr, int diff){

		if(curr == nums.length){
			return 0;
		}

		int inc = 0, exc = 0;

		if(prev < 0){
			inc = helper(nums, curr, curr + 1, Integer.MAX_VALUE) + 1;
		}else if(diff == Integer.MAX_VALUE || nums[curr] - nums[prev] == diff){
			inc = helper(nums, curr, curr + 1, nums[curr] - nums[prev]) + 1;
		}	

		exc = helper(nums, prev, curr + 1, diff);

		return Math.max(inc, exc);
	}

	public static int helper_TD(int[] nums, int prev, int curr, int diff, int[][][] strg){

		if(curr == nums.length){
			return 0;
		}

		if(strg[diff][curr][prev + 1] != 0){
			return strg[diff][curr][prev];
		}

		int inc = 0, exc = 0;

		if(prev < 0){
			inc = helper_TD(nums, curr, curr + 1, 10000, strg) + 1;
		}else if(diff == 10000 || nums[curr] - nums[prev] == diff){
			inc = helper_TD(nums, curr, curr + 1, nums[curr] - nums[prev], strg) + 1;
		}	

		exc = helper_TD(nums, prev, curr + 1, diff, strg);


		return strg[diff][curr][prev + 1] = Math.max(inc, exc);
	}


	public static void display(double[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					double value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}
	

	public static void display(double[] arr){


			for(double ele : arr){
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
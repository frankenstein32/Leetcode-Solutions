import java.util.*;

public class LongestIncreasingSubSeq{

	public static void main(String[] args){

		int[] arr = {10,9,2,5,3};
		System.out.println(LengthOfLIS(arr));
		
	}

	public static int LengthOfLIS(int[] nums){

		int[][] strg = new int[nums.length + 1][nums.length];

		for(int[] val : strg){

			Arrays.fill(val, -1);
		}

		System.out.println(helperBU_EFF(nums));
		System.out.println("*********");
		System.out.println(helperBU(nums));
		System.out.println(helperTD(nums, -1, 0, strg));
		return helper(nums, -1, 0);
	}

	public static int helper(int[] nums, int prevIdx, int currPos){

		if(currPos == nums.length){
			return 0;
		}

		int inc = 0, exc = 0;
		if(prevIdx < 0 || nums[currPos] > nums[prevIdx]){
			inc = helper(nums, currPos, currPos + 1) + 1;	
		}

		exc = helper(nums, prevIdx, currPos + 1);

		return Math.max(inc, exc);

	}

	public static int helperTD(int[] nums, int prevIdx, int currPos,int[][] strg){


		if(currPos == nums.length){
			return 0;
		}

		if(strg[prevIdx + 1][currPos] != -1){
			return strg[prevIdx + 1][currPos];
		}

		int inc = 0, exc = 0;
		if(prevIdx < 0 || nums[currPos] > nums[prevIdx]){
			inc = helperTD(nums, currPos, currPos + 1, strg) + 1;	
		}

		exc = helperTD(nums, prevIdx, currPos + 1, strg);

		strg[prevIdx + 1][currPos] = Math.max(inc, exc);
		return Math.max(inc, exc);
	}

	public static int helperBU(int[] nums){

		int n = nums.length;
		int[][] strg = new int[n][n + 1];

		int ans = 0;
		for(int slide = 1; slide < n;slide++){

			for(int i = 0;i <= slide;i++){

				int si = n - slide - 1;
				int ei = si + slide - i;

				int inc = 0, exc = 0;

				if(si > ei){
					continue;
				}
				if(ei == si || nums[ei] > nums[si]){

					inc = strg[ei][ei + 1] + 1;
				}

				exc = strg[si][ei + 1];

				strg[si][ei] = Math.max(inc, exc);
				ans = Math.max(ans, strg[si][ei]);
			}
		}

		display(strg);
		return ans;
	}

	public static int helperBU_EFF(int[] nums){

		int[] strg = new int[nums.length + 1];

		for(int si = nums.length - 2; si >= 0;si--){
			int save = strg[nums.length - 1];
			for(int ei = nums.length - 1; ei >= si;ei--){
				int inc = 0, exc = 0;
				if(si > ei){
					continue;
				}
				if(ei == si || nums[ei] > nums[si]){
					inc = save + 1;
				}
				exc = strg[ei + 1] ;
				save = strg[ei];
				strg[ei] = Math.max(inc, exc);
			}
			display(strg);
		}
		return strg[0];
	}

	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
	
	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

}
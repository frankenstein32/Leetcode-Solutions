import java.util.*;

public class MaximalSquare{

	public static void main(String[] args){

		char[][] arr = {{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
		System.out.println(maxsquare(arr));
		
	}

	
	public static int maxsquare(char[][] nums) {

		int ans = 0;

		int[][] strg = new int[nums.length + 1][nums[0].length + 1];

		for(int[] val : strg){

			Arrays.fill(val, -1);
		}


		for (int row = 0; row < nums.length; row++) {
			for (int col = 0; col < nums[0].length; col++) {

				if (nums[row][col] == '1') {
					int newLength = helperTD(nums, row, col, strg);
					ans = Math.max(ans, newLength);
				}
			}
		}

		System.out.println(helperBU(nums));
		System.out.println("******************");
		System.out.println(helperBUSE(nums));
		return ans * ans;

	}

	public static int helper(char[][] nums, int row, int col) {

		if (row < 0 || row >= nums.length || col < 0 || col >= nums[0].length || nums[row][col] == '0') {
			return 0;
		}

		int ans = 0;

		int Upper = helper(nums, row - 1, col);
		int Left = helper(nums, row, col - 1);
		int UpperLeft = helper(nums, row - 1, col - 1);

		ans = Math.min(Upper, Math.min(Left, UpperLeft)) + 1;

		return ans ;

	}
	
	public static int helperTD(char[][] nums, int row, int col, int[][] strg) {
		
		if (row < 0 || row >= nums.length || col < 0 || col >= nums[0].length || nums[row][col] == '0') {
			return 0;
		}

		if(strg[row][col] != -1){

			return strg[row][col];
		}

		int ans = 0;

		int Upper = helperTD(nums, row - 1, col, strg);
		int Left = helperTD(nums, row, col - 1, strg);
		int UpperLeft = helperTD(nums, row - 1, col - 1, strg);

		ans = Math.min(Upper, Math.min(Left, UpperLeft)) + 1;
		strg[row][col] = ans;
		return ans ;
	}

	public static int helperBU(char[][] arr){

		int[][] strg = new int[arr.length][arr[0].length];

		int maxLen = 0;
		for(int i = 0;i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){

				if(i == 0 || j == 0){
					strg[i][j] = arr[i][j] - 48;
					continue;
				}

				if(arr[i][j] == '1'){
					strg[i][j] = Math.min(strg[i - 1][j], Math.min(strg[i][j - 1], strg[i - 1][j - 1])) + 1;

					maxLen = Math.max(maxLen, strg[i][j]);
				}
			}
		}	

		display(strg);
		return maxLen * maxLen;
	}

	public static int helperBUSE(char[][] arr){


		int[] strg = new int[arr[0].length];

		int maxLen = 0;

		for(int i = 0;i < arr.length;i++){
			
			int temp = arr[i][0];
			for(int j = 0;j < arr[0].length;j++){

				if(i == 0 || j == 0){

					temp = strg[j];
					strg[j] = arr[i][j] - 48;
					maxLen = Math.max(maxLen, strg[j]);
					continue;
				}

				if(arr[i][j] == '1'){

					int ans = Math.min(strg[j], Math.min(strg[j - 1], temp)) + 1;
					temp = strg[j];
					strg[j] = ans;

					maxLen = Math.max(maxLen, strg[j]);
				}

				
			}
			display(strg);
		}

		return maxLen * maxLen;
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
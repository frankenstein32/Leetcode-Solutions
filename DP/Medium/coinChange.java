import java.util.*;

public class coinChange{

	public static void main(String[] args){

		int[] nums = {1, 2, 5};
		int amount = 11;
		System.out.println(coins(nums, amount));
		
	}

	public static int coins(int[] nums, int amount){

		int[][] strg = new int[nums.length + 1][amount + 1];
        
        for(int[] arr : strg){

        	 Arrays.fill(arr,-1);
        }
       
        	int ans = helper(nums, 0, amount);

		return ( ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static int helper(int[] nums, int vidx, int amount){

		if(vidx == nums.length || amount < 0){
			return Integer.MAX_VALUE;
		}

		if(amount == 0){
			return 1;
		}

		
		int inc = helper(nums, vidx, amount - nums[vidx]);

		if(inc != Integer.MAX_VALUE){
			inc += 1;
		}
		int exc = helper(nums, vidx + 1, amount);

		return Math.min(inc, exc);


	}

	public static int helperTD(int[] nums, int vidx, int amount, int[][] strg){


		if(vidx == nums.length || amount < 0){
			return Integer.MAX_VALUE;
		}

		if(amount == 0){
			return 0;
		}

		if(strg[vidx][amount] != -1){
			return strg[vidx][amount];
		}

		
		int inc = helperTD(nums, vidx, amount - nums[vidx], strg);

		if(inc != Integer.MAX_VALUE){
			inc += 1;
		}
		int exc = helperTD(nums, vidx + 1, amount, strg);

		strg[vidx][amount] = Math.min(inc, exc);

		return strg[vidx][amount];


	}

	public static int coinChangeBU(int[] nums, int amount){


		int[][] strg = new int[nums.length + 1][amount + 1];


		for(int row = nums.length;row >= 0;row--){

			for(int col = amount;col >= 0;col--){

				if(row == nums.length){

					strg[row][col] = Integer.MAX_VALUE;
					continue;
				}


			}
		}

		return 0;
	}


	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

}
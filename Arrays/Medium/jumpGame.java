import java.util.*;

public class jumpGame{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 2, 1, 0, 4};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		System.out.println(canJump(arr));
		System.out.println(canJump_BU(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean canJump(int[] nums){
			
			return helper(nums,0);

	}

	public static boolean helper(int[] arr, int vidx){


		if(vidx >= arr.length){
			return true;
		}

		for(int step = 1;step <= arr[vidx];step++){

			boolean rr = helper(arr,vidx + step);

			if(rr)
				return true;
		}

		return false;

	}

	public static boolean canJump_BU(int[] nums){

		boolean[] strg = new boolean[nums.length];

		strg[nums.length - 1] = true;

		for(int i = nums.length - 2;i >= 0;i--){

			int steps = nums[i];

			for(int j = 1; j <= steps;j++){

				if(i + j < strg.length && strg[i + j]){
					strg[i] = true;
				}
			}
		}

		return strg[0];
	}

	
}
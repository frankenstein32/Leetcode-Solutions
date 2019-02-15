import java.util.*;

public class MaxCircularSum{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5,-3,5};
		int target = 2;
		System.out.println(maxSubarraySumCircular(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maxSubarraySumCircular(int[] nums) {

	 	
	 	int[] dummy = new int[2 * nums.length];

	 	for(int i = 0; i < dummy.length;i++){
	 		
	 		int idx = i % nums.length;
	 		dummy[i] = nums[idx];
	 	}



	 	int maxSum = Integer.MIN_VALUE;

	 	for(int i = 0;i < nums.length;i++){

	 		int ssf = 0;

	 		for(int j = i; j < nums.length + i;j++){

	 			ssf += dummy[j];
	 			// System.out.println(ssf);
	 			if(ssf > maxSum){
	 				// System.out.println(ssf);
	 				maxSum = ssf;
	 			}

	 		}
	 	}

	 	return maxSum;
	}

	public static int maxSubarraySumCircular2(int[] nums) {

		int flag = 0;
		int min = Integer.MAX_VALUE;
		for(int num : nums){

			if(num > 0)
				flag = 1;
			min = Math.min(min,num);
		}

		if(flag == 0)
			return min;


		int max_kadane = kadane(nums);

		int max_wrap = 0;

		for(int i = 0;i < nums.length;i++){

			max_wrap += nums[i];
			nums[i] = -nums[i];
		}


		max_wrap = max_wrap + kadane(nums);

		return max_wrap > max_kadane ? max_wrap : max_kadane;
	 	
	 	
	}

	public static int kadane(int[] arr){


		int Maxsum = Integer.MIN_VALUE;
		int ssf = 0;
		for(int i = 0;i < arr.length;i++){

			ssf += arr[i];

			if(ssf < 0){
				ssf = 0;
			}else if(ssf > maxSum){
				maxSum = ssf;
			}
		}

		return maxSum;
	}
}
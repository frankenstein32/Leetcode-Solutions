import java.util.*;

public class Maximum_Subarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		// int val = scn.nextInt();

		System.out.println(maxSum(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int maxSum(int[] nums){

		int sum = Integer.MIN_VALUE;
		int curr_sum = 0;
		int si = 0;
		for(int ei = 0;ei < nums.length;ei++){

			curr_sum += nums[ei];

			if(curr_sum < 0){
				curr_sum = 0;
				si = ei + 1;
			}

			if( curr_sum > sum){
				sum = curr_sum;
			}

		}


		return sum;

	}
}
import java.util.*;

public class Max_Avg_subarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1,12,-5,-6,50,3};
		int k = 4;
		// display2(arr);
		
		System.out.println(findMaxAverage(arr,k));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int product(int[] nums){

		
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[0]*nums[1]*nums[n - 1], nums[n - 1]*nums[n - 2]*nums[n - 3]);
	}

	public static double findMaxAverage(int[] nums,int k){

	
		double res = 0;
		int n = nums.length;
		for(int i = 0;i < k;i++){

			res += nums[i];

		}

		double curr_sum = res;
		for(int i = k;i < n;i++){

			curr_sum += nums[i] - nums[i - k];
			
			res = Math.max(curr_sum,res);
		}

		return res/k;
	}

	


	
		
}

import java.util.*;

public class MaxProduct{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {-1,-2,-3,};
		// display2(arr);
		
		System.out.println(product_Eff(arr));
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

	public static int product_Eff(int[] nums){

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;


		for(int val : nums){


			if(val < min1){
				min2 = min1;
				min1 = val;
			}else if(val < min2){
				min2 = val;
			}

			if(max1 <= val){
				max3 = max2;
				max2 = max1;
				max1 = val;
			}else if(max2 <= val){

				max3 = max2;
				max2 = val;
			}else if (max3 <= val){

				max3 = val;
			}
		}

		return Math.max(min1*min2*max1 , max1*max2*max3);
	}

	


	
		
}

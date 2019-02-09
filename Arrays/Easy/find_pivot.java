import java.util.*;

public class  find_pivot{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1, 2, 3};
		int k = 4;
		// display2(arr);
		
		System.out.println(pivotIndex(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int pivotIndex(int[] nums){

		if(nums.length < 1)
			return -1;
		
		int left = nums[0];
		int right = 0;
		for(int i = 0;i < nums.length;i++){
			right += nums[i];
		}
		// System.out.println(left +" "+right);
		for(int i = 0;i < nums.length;i++){

			right = right - nums[i];

			// System.out.println(left +" "+right);
			if(left == right){
				return i;
			}

			left += nums[i];
		}

		return -1;
	}


	
		
}

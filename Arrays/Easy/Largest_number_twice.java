import java.util.*;

public class  Largest_number_twice{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1, 2, 3, 4};
		int k = 4;
		// display2(arr);
		
		System.out.println(dominantIndex(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int dominantIndex(int[] nums){

		int max_idx= 0;
		for(int i = 0;i < nums.length;i++){

			if(nums[max_idx] < nums[i]){

				max_idx = i;
			}
		}

		for(int i = 0;i < nums.length;i++){
			
			if(nums[i] != nums[max_idx] && 2*nums[i] > nums[max_idx]){
				return -1;
			}
		}
		return max_idx;
		
	}
		
}

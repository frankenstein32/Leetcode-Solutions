import java.util.*;

public class  Non_decreasing_Array{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {4, 4, 1};
		int k = 4;
		// display2(arr);
		
		System.out.println(checkPossibility(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static boolean checkPossibility(int[] nums){

		int p = -1;

		for(int i = 0;i < nums.length - 1;i++){

			if(nums[i] > nums[i + 1]){

				if(p != -1){
					return false;
				}

				p = i;
			}

		}

		if(p == -1 || p == 0 || p == nums.length - 2 || nums[p - 1] <= nums[p + 1]|| nums[p] <= nums[p + 2]){
			return true;
		}

		return false;
		
	}


	
		
}

import java.util.*;

public class PartitionArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,0,2,3,4};
		int target = 2;
		System.out.println(partitionDisjoint(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int partitionDisjoint(int[] nums) {

	 	int[] left = new int[nums.length];
	 	int[] right = new int[nums.length];

	 	left[0] = nums[0];
	 	for(int i = 1;i < nums.length;i++){

	 		left[i] = Math.max(left[i - 1],nums[i]);
	 	}	

	 	right[nums.length - 1] = nums[nums.length - 1];

	 	for(int i = nums.length - 2;i >= 0;i--){
	 		right[i] = Math.min(right[i + 1],nums[i]);
	 	}

	 	for(int i = 1;i < nums.length;i++){


	 		if(left[i - 1] <= right[i]){
	 			return i;
	 		}
	 	}

	 	return -1;
	}


}
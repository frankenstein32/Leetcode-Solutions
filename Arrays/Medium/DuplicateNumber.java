import java.util.*;

public class DuplicateNumber{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 1, 3, 4, 2};
		int target = 7;
		System.out.println(findDuplicate(arr));
		display(arr);
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int findDuplicate(int[] nums) {
	    
	  for(int i = 0;i < nums.length;i++){

	  		int val = Math.abs(nums[i]);

	  		if(nums[val - 1] < 0){
	  			return val;
	  		}else{
	  			nums[val - 1] = -nums[val - 1];
	  		}
	  }


	  return -1;
	}

	
}
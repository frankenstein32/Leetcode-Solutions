import java.util.*;

public class ProductOfArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,2,3,4};
		int target = 7;
		display(productExceptSelf(arr));
		display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int[] productExceptSelf(int[] nums) {
	    

	    int[] left = new int[nums.length];
	    int[] right = new int[nums.length];

	    left[0] = 1;
	    right[right.length - 1] = 1;

	    for(int i = 0;i < nums.length - 1;i++){

	    	left[i + 1] = left[i] * nums[i];
	    }

	    for(int j = nums.length - 1;j > 0;j--){

	    	right[j - 1] = right[j] * nums[j];
	    }

	    for(int i = 0;i < nums.length;i++){

	    	nums[i] = left[i] * right[i]; 
	    }

	    return nums;
	}

	 public static int[] productExceptSelf_Eff(int[] nums) {
	    
	    int[] right = new int[nums.length];
	    right[right.length - 1] = 1;

	    for(int j = nums.length - 1;j > 0;j--){

	    	right[j - 1] = right[j] * nums[j];
	    }
	    display(right);
	    int left = 1;
	    for(int i = 0;i < nums.length;i++){

	    	right[i] = left * right[i]; 
	    	left = left * nums[i];
	    }

	    return right;
	}
	
}
import java.util.*;

public class MaxSwap{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5, 4, 0, 3, 1, 6, 2};
		int target = 2;
		System.out.println(triangleNumber(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int triangleNumber(int[] nums) {

	 	Arrays.sort(nums);
	 	int count = 0;

	 	for(int i = 0; i < nums.length - 2;i++){

	 		 int k = i + 2;
	 		 for(int j = i + 1;j < nums.length - 1 && nums[i] != 0;j++){

	 		 	while(k < nums.length && nums[i] + nums[j] > nums[k]){
	 		 		
	 		 		k++;
	 		 	}
	 		 	count += k - j + 1;
	 		}
	 	}

	 	return count;
		
	}

	
}
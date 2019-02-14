import java.util.*;

public class ValidTriangle{
	
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

	 	for(int i = 0; i < nums.length;i++){

	 		 int k = i + 2;
	 		 for(int j = i + 1;j < nums.length;j++){

	 		 	while(k < nums.length && nums[i] + nums[j] > nums[k]){
	 		 		
	 		 		k++;
	 		 	}
	 		 	count += k - j + 1;
	 		}
	 	}

	 	return count;
		
	}

	
}
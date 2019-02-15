import java.util.*;

public class TurbulentSubarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {6,0,8,2,1,5};
		int target = 2;
		String str = "00110";
		System.out.println(maxWidthRamp(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(Integer[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maxTurbulenceSize(int[] nums) {

	 
	 	int count = 1;
	 	int maxCount = 0;
	 	boolean up = true;
	 	boolean down = true;

	 	for(int i = 1;i < nums.length;i++){

		 	if(nums[i] < nums[i - 1] && up){

		 		up = false;
		 		down = true;
		 		count++;

		 		if(count > maxCount){
		 			maxCount = count;
		 		}

		 	}else if(nums[i] > nums[i - 1] && down){
		 		up = true;
		 		down = false;

		 		count++;
		 		if(count > maxCount){
		 			maxCount = count;
		 		}

		 	}else{

		 		count = 2;
		 		
		 		if(nums[i - 1] > nums[i]){

		 			up = false;
		 			down = true;
		 		}else if(nums[i] > nums[i - 1]){
		 			up = true;
		 			down = false;
		 		}else{
		 			count = 1;
		 			up = true;
		 			down = true;
		 		}

		 	}
		}
	 }
}
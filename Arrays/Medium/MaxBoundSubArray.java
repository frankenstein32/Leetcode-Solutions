import java.util.*;

public class MaxBoundSubArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,0,2,3,4};
		int target = 2;
		System.out.println(count(arr,2,4));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int count(int[] nums,int L, int R) {

	 	
	 	int mins = 0;
	 	int maxIndex = 0;
	 	int res = 0;

	 	for(int i = 0;i < nums.length;i++){

	 		if(nums[i] < L){
	 			mins++;
	 		}else{
	 			mins = 0;
	 		}

	 		if(nums[i] > R){

	 			maxIndex = i;
	 		}

	 		res += (i - maxIndex - mins);

	 	}

	 	return res;
	}

	
}
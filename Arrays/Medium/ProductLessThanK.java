import java.util.*;

public class ProductLessThanK{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1, 2};
		int target = 2;
		System.out.println(numSubarrayProductLessThanK(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int numSubarrayProductLessThanK(int[] nums, int k) {

	 	
	 	if(k <= 1)
	 		return 0;

	 	int prod = 1, ans = 0, left = 0;

	 	for(int right = 0;right < nums.length;right++){

	 		prod *= nums[right];

	 		while(prod >= k){
	 			prod /= nums[left++];
	 		}

	 		ans += right - left + 1;
	 	}

	 	return ans;

	 }
}
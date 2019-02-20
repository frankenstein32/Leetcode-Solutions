import java.util.*;

public class MinInRotatedSortedArray2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5, 4, 0, 3, 1, 6, 2};
		int target = 2;
		System.out.println(findMin(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int findMin(int[] nums) {

		int N = nums.length;
		int lo = 0;
		int hi = N - 1;
		int rmax = nums[hi];


		while(lo < hi){


			int mid = (lo + hi)/2;

			if(nums[mid] > nums[hi]){
				lo = mid + 1;
			}else if(nums[mid] < nums[hi]){
				hi = mid - 1;
			}else{

				if(nums[hi - 1] == nums[hi]){
					hi--;
				}else{

					lo = mid + 1;
				}
			}


		}

		return nums[lo];
	}

	
}
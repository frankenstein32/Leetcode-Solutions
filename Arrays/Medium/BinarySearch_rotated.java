import java.util.*;

public class BinarySearch_rotated{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 0, -1, 0, -2, 2};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 0;
		System.out.println(search(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int search(int[] nums, int target){

		int lo = 0;
		int hi = nums.length - 1;

		while(lo < hi){

			int mid = (lo + hi)/2;

			if(nums[mid] == target)
				return mid;

			if(nums[lo] <= nums[mid]){

				if(target > nums[lo] && target < nums[mid]){
					hi = mid - 1;
				}else{
					lo = mid + 1;
				}
			}else{

				if(target > nums[mid] && target > nums[hi]){
					lo = mid + 1;
				}else{
					hi = mid - 1;
				}
			}
		}

		return -1;
		

	}

	
}
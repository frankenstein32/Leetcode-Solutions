import java.util.*;

public class RotatedSorted2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 1};
		int target = 1;
		System.out.println(find(arr,target));
		// display(arr);
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean find(int[] nums, int target){

		int lo = 0;
		int hi = nums.length - 1;

		while(lo <= hi){

			int mid = (lo + hi)/2;
			// System.out.println(lo+" "+hi);
			if(nums[mid] == target){
				return true;
			}

			if(nums[lo] < nums[mid]){

				if(nums[lo] <= target && nums[mid] > target){
					hi = mid - 1;
				}else{
					lo = mid + 1;
				}
			}else if(nums[lo] > nums[mid]){

				if(nums[hi] >= target && nums[mid] < target){
					lo = mid + 1;
				}else{
					hi = mid - 1;
				}
			}else{
				lo++;
			}

			// System.out.println(lo+" "+hi);
		}

		return false;

	}


	
}
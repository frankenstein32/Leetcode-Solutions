import java.util.*;

public class KthSmallestPairDistance{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 3, 1};
		int k = 1;
		System.out.println(smallestDistancePair(arr,k));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int smallestDistancePair(int[] nums,int k){


		Arrays.sort(nums);
		int lo = 0;
		int hi = nums[nums.length - 1] - nums[0];

		while(lo < hi){

			int mid = (lo + hi)/2;

			if(countPairs(nums,mid) >= k){
				hi = mid;
			}else{
				lo = mid + 1;
			}
		}


		return lo;
	}

	public static int countPairs(int[] nums,int mid){


		int left = 0;
		int count = 0;
		for(int right = 0;right < nums.length;right++){

			while(nums[right] - nums[left] > mid){
				left++;
			}
			count += right - left;
		}
		return count;
	}	
}
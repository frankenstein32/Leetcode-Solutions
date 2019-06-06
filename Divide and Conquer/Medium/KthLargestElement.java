import java.util.*;

public class KthLargestElement{


	public static void main(String[] args){


		int[] nums = {1,2,5,2,3,5,2,1,1,7};
		int k = 1;

		System.out.println(findKthelement(nums, k));

	}

	public static int findKthelement(int[] nums, int k){

		return helper(nums, 0, nums.length - 1,k);
	}

	public static int helper(int[] nums, int start, int end, int k){


		if(start > end)
			return Integer.MAX_VALUE;

		int left = start;
		int pivot = nums[end];


		for(int i = start;i < end;i++){

			if(nums[i] <= pivot){

				swap(nums, left++, i);
			}
		}

		swap(nums, left, end);

		if(left == k){
			return nums[left];

		}else if(left < k){
			return helper(nums, left + 1, end,k);
		}else{
			return helper(nums, start, left - 1, k);
		}
	}

	public static int helper2(int[] nums, int k){

		int start = 0;
		int end = nums.length - 1;
		int index = nums.length - k;

		while(start < right){

			pivotIndex = partition(nums, start, end,k);

			if(pivotIndex < index){
				start = pivot + 1;
			}else if(pivotIndex > index){
				end = pivot - 1;
			}else{
				return nums[pivotIndex];
			}
		}

		return nums[start];
	}

	public static int partition(int[] nums, int start, int end){

		int pivot = start;

		while(start <= end){

			while(start <= end && nums[start] <= nums[pivot]){
				start++;
			}

			while(start <= end && nums[end] > nums[pivot]){
				end--;
			}

			if(start > end) break;

			swap(nums, start, end);
		}

		swap(nums, end, pivot);

		return end;
	}

	public static void swap(int[] nums, int a, int b){


		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}



}
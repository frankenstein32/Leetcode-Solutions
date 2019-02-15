import java.util.*;

public class GlobalLocalInv{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 0};
		int target = 2;
		System.out.println(isIdealPermutation(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static boolean isIdealPermutation(int[] nums) {

	 	int local = 0;
	 	int global = 0;

	 	int i = 0;
	 	while(i < nums.length - 1){

	 		if(nums[i] > nums[i + 1]){
	 			local++;
	 		}
	 		i++;
	 	}

	 	global = globalInv(nums);
	 	if(global == local){
	 		return true;
	 	}else{
	 		return false;
	 	}
	 	
	 	
	}

	public static int globalInv(int[] nums){


		int[] temp = new int[nums.length];
		return mergesort(nums,temp,0,nums.length - 1);
	}

	public static int mergesort(int[] nums, int[] temp,int lo, int hi){


		if(lo >= hi){
			return 0;
		}

		int mid = (lo + hi)/2;

		int invcnt = 0;
		invcnt += mergesort(nums,temp,lo,mid);
		invcnt += mergesort(nums,temp,mid + 1,hi);

		invcnt += merge(nums,temp,lo,mid,hi);

		return invcnt;
	}

	public static int merge(int[] nums, int[] temp,int lo, int mid, int hi){

		int i = lo;
		int j = mid;
		int k = lo;

		int inv_cnt = 0;

		while(i <= mid - 1 && j <= hi){


			if(nums[i] < nums[j]){
				temp[k] = nums[i];
				i++;
				k++;
			}else{
				temp[k] = nums[j];
				j++;
				k++;
			}

			inv_cnt += mid - i;


		}

		while(i <= mid - 1){
			temp[k] = nums[i];
				i++;
				k++;
		}

		while(j <= hi){
			temp[k] = nums[j];
				j++;
				k++;
		}


		for(int m = 0;m < nums.length;m++){

			nums[m] = temp[m];
		}


		return inv_cnt;


	}

	
}
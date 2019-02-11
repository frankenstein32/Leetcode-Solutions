import java.util.*;

public class First_Last_in_SortedArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5,7,7,8,8,10};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		display(searchRange(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int[] searchRange(int[] nums, int target){
		

		int lo, hi;

		int idx = Bs(nums,0,nums.length - 1,target);
		int start = idx;
		int end = idx;
		if(idx == -1){
			return new int[]{-1, -1};
		}


		lo = 0; 
		hi = idx - 1;
		
		while(true){
			int temp = Bs(nums,lo, hi,target);

			if(temp != -1){
				start = temp;
				lo = 0;
				hi = temp - 1;
			}else{
				break;
			}
		}

		lo = idx + 1;
		hi = nums.length - 1;

		while(true){
			int temp = Bs(nums,lo, hi,target);

			if(temp != -1){
				end = temp;
				lo = temp + 1;
				hi = nums.length - 1;
			}else{
				break;
			}
		}

		return new int[]{start,end};


		
	}

	public static int Bs(int[] arr, int start, int end,int item){

		int lo = start;
		int hi = end;

		while(lo <= hi){


			int mid = (lo + hi)/2;

			if(arr[mid] == item){
				return mid;
			}else if(arr[mid] > item){
				hi = mid - 1;
			}else{
				lo = mid + 1;
			}
		}
		return -1;
	}

	
}
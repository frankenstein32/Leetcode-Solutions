import java.util.*;

public class SearchInsertPosition{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int val = scn.nextInt();

		System.out.println(binarySearch(arr,val));
		display(arr);

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int binarySearch(int[] nums,int val){

		int lo = 0;
		int hi = nums.length - 1;

		while(lo <= hi){

			int mid = (lo + mid)/2;

			if(nums[mid] < val){

				lo = mid + 1;
			}else if (nums[mid] > val){
				hi = mid - 1; 
			}else{
				return mid;
			}
		}

		return lo;

	}
}
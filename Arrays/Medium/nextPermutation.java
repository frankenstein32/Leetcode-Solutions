import java.util.*;

public class nextPermutation{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 0, -1, 0, -2, 2};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 0;
		System.out.println(calc(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> calc(int[] nums){

		if(nums == null || nums.length < 2){
			return;
		}

		int p = 0;
		int q = 0;

		for(int i = nums.length - 2;i >= 0;i--){

			if(nums[i] < nums[i + 1]){
				p = i;
				break;
			}
		}


		for(int i = nums.length - 1;i >= 0;i--){

			if(nums[i] > nums[p]){
				q = i;
				break;
			}
		}

		if(p == 0 && q == 0){
			reverse(nums,p,nums.length - 1);
			return;
		}

		int temp = nums[p];
		nums[p] = nums[q];
		nums[q]  = temp;

		if(p < nums.length - 1)
			reverse(nums,p + 1,nums.length - 1);

	}

	public static void reverse(int[] nums,int si,int ei){



		for(int i = si; i <= ei;i++){

			int temp = nums[i];
			nums[i] = nums[ei - i];
			nums[ei - i] = temp;
		}

	}

}
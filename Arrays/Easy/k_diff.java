import java.util.*;

public class k_diff{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {3,1,4,1,5};
		int k = 2;
		System.out.println(pairs(arr,k));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int pairs(int[] nums,int k){

		int left = 0;
		int right = 1;
		Arrays.sort(nums);
		int cnt = 0;

		while(left < nums.length && right < nums.length){

			if(left == 0 || nums[left] != nums[left - 1]){

				int diff = nums[right] - nums[left];

				if(diff == k){
					cnt++;
					left++;
				}else if(diff > k){
					left++;
				}else{
					right++;
				}

			}else{
				left++;
			}

			if(left == right){
				right++;
			}

				
		}

		return cnt;
	}
}
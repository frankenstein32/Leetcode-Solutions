import java.util.*;

public class TwoSum2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int target = scn.nextInt();

		int[] ans = twoSum(arr,target);
		display(ans);


	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] twoSum(int[] nums, int target){

		int[] ans = new int[2];

		int i = 0;
		int j = nums.length - 1;

		while(i < j){

			if(nums[i] + nums[j] == target){
				ans[0] = i;
				ans[1] = j;
				i++;
				j--;
				break;
			}else if(nums[i] + nums[j] < target){

				i++;
			}else{
				j--;
			}
		}
		return ans;
	}
}
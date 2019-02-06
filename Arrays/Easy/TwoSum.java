import java.util.*;

public class TwoSum{
	
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

		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] ans = new int[2];

		for(int i = 0;i < nums.length;i++){

			int num = target - nums[i];

			if(hm.containsKey(nums[i])){

				ans[0] = hm.get(nums[i]);
				ans[1] = i;
				break;
			}else{

				hm.put(num,i);
			}
		}

		System.out.println(hm);

		return ans;
	}
}
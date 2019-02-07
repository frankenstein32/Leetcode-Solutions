import java.util.*;

public class Shortest_unsorted_subarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {2,6,4,8,10,9,15};
		// display2(arr);
		
		System.out.println(findUnsortedSubarray(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int findUnsortedSubarray(int[] nums){

		if(nums.length < 2){
			return 0;
		}

		int flag = 0;
		List<Integer> res = new ArrayList<>();

		for(int i = 0; i < nums.length - 1;i++){

			if(nums[i] > nums[i + 1]){
				res.add(i);
				flag = 1;
			}

			if(flag == 1 && nums[i] == nums[i + 1]){
				res.add(i);
			}
		}

		int len = 0;
		if(res.size() != 0){
			// System.out.print(res.get(0)+" ");
			// System.out.println(res.get(res.size() - 1) + 1);

			len = res.get(res.size() - 1) + 1 - res.get(0);
			return len + 1;
		}else{
			return 0;
		}

		
		
	
	}

	
		
}

import java.util.*;

public class SubarraySumK{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 1, 1};
		int target = 2;
		System.out.println(subarraySum(arr, target));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int subarraySum(int[] nums, int target) {

		 HashMap<Integer,Integer> map = new HashMap<>();

		 int sum = 0, count = 0;

		 map.put(0,1);

		 for(int i = 0;i < nums.length;i++){

		 	sum += nums[i];

		 	if(map.containsKey( sum - target)){
		 		count += map.get(sum - target);
		 	}

		 	map.put(sum,map.getOrDefault(sum,0) + 1);

		 }

		 return count;
	}

	
}
import java.util.*;

public class  Degree_Array{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={1,2,2,3,1,4,2};
		int k = 4;
		// display2(arr);
		
		System.out.println(findShortestSubArray(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int findShortestSubArray(int[] nums){

		HashMap<Integer,Integer> left = new HashMap<>();
		HashMap<Integer,Integer> right = new HashMap<>();
		HashMap<Integer,Integer> count = new HashMap<>();

		for(int i = 0;i < nums.length;i++){

			if(left.get(nums[i]) == null){
				left.put(nums[i],i);
			}

			right.put(nums[i],i);

			if(count.containsKey(nums[i])){

				int oc = count.get(nums[i]);
				int nc = oc + 1;
				count.put(nums[i],nc);
			}else{
				count.put(nums[i],1);
			}
		}

		int degree = Collections.max(count.values());
		int ans = nums.length;
		for(int key : count.keySet()){

			if(count.get(key) == degree){
				ans = Math.min(ans,right.get(key) - left.get(key) + 1);

			}
		}

		return ans;
	}


	
		
}

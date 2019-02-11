import java.util.*;

public class CombinationSum{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {2,3,5};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		System.out.println(comb(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static  List<List<Integer>> comb(int[] nums,int target){

 		return findSum(nums,0,target);
 	}

	public static List<List<Integer>> findSum(int[] nums, int vidx,int target){

		if(vidx == nums.length || target < 0){
			return new ArrayList<>();
		}

		if(target == 0){
			List<List<Integer>> br = new ArrayList<>();
			br.add(new ArrayList<>());
			return br;
		}

		
		List<List<Integer>> mr = new ArrayList<>();
		List<List<Integer>> rr1 = findSum(nums,vidx + 1,target);

		for(List<Integer> arr : rr1){
			mr.add(arr);
		}

		List<List<Integer>> rr2 = findSum(nums,vidx,target - nums[vidx]);

		for(List<Integer> arr : rr2){
			arr.add(0,nums[vidx]);
			mr.add(arr);
		}

		return mr;

	}

}
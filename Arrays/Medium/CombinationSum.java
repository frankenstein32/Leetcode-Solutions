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
		System.out.println(calculateSum(arr,target));
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

	public static List<List<Integer>> calculateSum(int[] nums,int target){

		List<List<Integer>> ans = new ArrayList<>();
		calculateSum(nums, 0, ans,new ArrayList<>(),target);
		return ans;
	}

	public static void calculateSum(int[] nums, int vidx, List<List<Integer>> ans,List<Integer> temp,int target){


		if(target == 0){
			ans.add(new ArrayList<>(temp));
			return;
		}

		for(int i = vidx; i < nums.length;i++){

			if(target >= nums[i]){

				temp.add(nums[i]);
				calculateSum(nums,i,ans,temp,target - nums[i]);
				temp.remove(temp.size() - 1);

			}
			
		}
	}

}
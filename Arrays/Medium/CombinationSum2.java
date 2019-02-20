import java.util.*;

public class CombinationSum2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {10,1,2,7,6,1,5};

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

 	public static List<List<Integer>> comb(int[] nums, int target){

 		List<List<Integer>> ans = new ArrayList<>();
 		Arrays.sort(nums);
 		comb(nums,0,target,ans,new ArrayList<>());

 		return ans;
 	}

 	public static void comb(int[] nums, int vidx, int target, List<List<Integer>> ans, List<Integer> temp){

 		if(target == 0){
 			ans.add(new ArrayList<>(temp));
 			return;
 		}

 		for(int i = vidx;i < nums.length;i++){

 			if(target >= nums[i] && (i == vidx || nums[i] != nums[i - 1])){
 				temp.add(nums[i]);
	 			comb(nums, i + 1, target - nums[i],ans,temp);
	 			temp.remove(temp.size() - 1);

 			}
 			
 		}
 	}


}
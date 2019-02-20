import java.util.*;

public class Permutation{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2};
		int target = 2;
		System.out.println(caculate(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static List<List<Integer>> caculate(int[] nums){

 		List<List<Integer>> ans = new ArrayList<>();
 		// helper(nums,ans,new ArrayList<>());
 		helperRepeat(nums,ans,new ArrayList<>(),new boolean[nums.length]);
 		return ans;
 	}

 	public static void helper(int[] nums, List<List<Integer>> ans,List<Integer> temp){


 		if(temp.size() == nums.length){
 			ans.add(new ArrayList<>(temp));
 			return; 
 		}

 		for(int i = 0;i < nums.length;i++){

 			if(temp.contains(nums[i])) continue;

 			temp.add(nums[i]);
 			helper(nums, ans,temp);
 			temp.remove(temp.size() - 1);
 		}
 	}

 	public static void helperRepeat(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] used){


 		if(temp.size() == nums.length){

 			ans.add(new ArrayList<>(temp));
 			return;

 		}

 		for(int i = 0;i < nums.length;i++){

 			if(used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]){
 				continue;
 			}

 			used[i] = true;
 			temp.add(nums[i]);
 			helperRepeat(nums, ans, temp, used);
 			temp.remove(temp.size() - 1);
 			used[i] = false;
 		}
 	}

	
}
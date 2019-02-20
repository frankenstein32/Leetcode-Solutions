import java.util.*;

public class Subset2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2};
		int target = 2;
		System.out.println(subset(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> subset(int[] nums){


		List<List<Integer>> ans = new ArrayList<>();
		helperRepeat(nums,0,ans,new ArrayList<>());
		// helper(nums, 0,ans,new ArrayList<>());

		return ans;
	}

	public static void helper(int[] nums, int vidx, List<List<Integer>> ans, List<Integer> progress){


		ans.add(new ArrayList<>(progress));

		for(int i = vidx;i < nums.length;i++){

			progress.add(nums[i]);
			helper(nums, i + 1,ans,progress);
			progress.remove(progress.size() - 1);
		}
	}

	public static void helperRepeat(int[] nums,int vidx, List<List<Integer>> ans, List<Integer> progress){

		ans.add(new ArrayList<>(progress));

		for(int i = vidx;i < nums.length;i++){

			if(i == vidx || nums[i - 1] != nums[i]){
				progress.add(nums[i]);
				helperRepeat(nums,i + 1,ans,progress);
				progress.remove(progress.size() - 1);
			}
		}
	}
	
}
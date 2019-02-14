import java.util.*;

public class AllDuplicateArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {4,3,2,7,8,2,3,1};
		int target = 7;
		System.out.println(findDuplicate(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static Set<Integer> findDuplicate(int[] nums) {

	 	Set<Integer> ans = new HashSet<>();
	    
	  for(int i = 0;i < nums.length;i++){

	  		int val = Math.abs(nums[i]);

	  		if(nums[val - 1] < 0){
	  			ans.add(val);
	  		}else{
	  			nums[val - 1] = -nums[val - 1];
	  		}
	  }


	  return ans;
	}

	
}
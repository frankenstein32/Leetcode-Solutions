import java.util.*;

public class Sum3{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = { 0, 0, 0, 0};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }

		System.out.println(threeSum(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> threeSum(int[] nums){

		if(nums == null || nums.length < 3){
			return new ArrayList<>();
		}

		List<List<Integer>> ans = new ArrayList<>();
			Arrays.sort(nums);
			

			for(int i = 0;i < nums.length - 1;i++){

				if(i > 0 && nums[i - 1] == nums[i]){
					continue;
				}

				int j = i + 1;
				int k = nums.length - 1;
				List<Integer> triplet = new ArrayList<>();
				while(j < k){

					if(nums[i] + nums[j] + nums[k] > 0){
						k--;
					}else if(nums[i] + nums[j] + nums[k] < 0 ){
						j++;
					}else{
						triplet.add(nums[i]);
						triplet.add(nums[j]);
						triplet.add(nums[k]);
		
						ans.add(triplet);
						triplet = new ArrayList<>();

						j++;
						k--;

						while(j < k && nums[j] == nums[j - 1]){
							j++;
						}

						while(j < k && nums[k] == nums[k + 1]){
							k--;
						}
					}
				}	
			}
			return ans;

	}

}
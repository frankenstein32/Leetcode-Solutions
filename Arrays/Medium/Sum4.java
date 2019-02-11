import java.util.*;

public class Sum4{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 0, -1, 0, -2, 2};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 0;
		System.out.println(fourSum(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> fourSum(int[] nums,int target){

		if(nums == null || nums.length < 3){
			return new ArrayList<>();
		}

		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
			

			for(int i = 0;i < nums.length - 1;i++){

				
				for(int j = i + 1;j < nums.length - 1;j++){


					if(j != i + 1 && nums[j - 1] == nums[j])
						continue;

					int k = j + 1;
					int l = nums.length - 1;
					ArrayList<Integer> quad = new ArrayList<>();
					while(k < l){


						int sum = nums[i] + nums[j] + nums[k] + nums[l];

						if(sum > target){
							l--;
						}else if(sum < target){
							k++;
						}else{	
							quad.add(nums[i]);
							quad.add(nums[j]);
							quad.add(nums[k]);
							quad.add(nums[l]);

							ans.add(quad);
							quad = new ArrayList<>();

							k++;
							l--;

							while(k < l && nums[k - 1] == nums[k])
								k++;

							while(k < l && nums[l + 1] == nums[l])
								l--;

						}
					}
				}
			}
			return ans;

	}

}
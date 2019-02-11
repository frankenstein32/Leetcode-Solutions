import java.util.*;

public class Sum3_closest{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = { 1, 1, 1, 0};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = -100;
		System.out.println(threeSumClosest(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int threeSumClosest(int[] nums,int target){

		if(nums == null || nums.length < 3){
			return 0;
		}

			Arrays.sort(nums);
			int res = 0;
			int min = Integer.MAX_VALUE;
			
			for(int i = 0;i < nums.length - 1;i++){

				int j = i + 1;
				int k = nums.length - 1;
				while(j < k){

					int sum = nums[i] + nums[j] + nums[k];
					int diff = Math.abs(sum - target);
					if( diff == 0)
						return sum;

					if(diff < min){
						min = diff;
						res = sum;
					}

					if(sum <= target)
						j++;
					else
						k--;
					
				}
					
			}	
			
			return res;

	}

}
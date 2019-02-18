import java.util.*;

public class TeemoAttacking{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5, 4, 0, 3, 1, 6, 2};
		int target = 2;
		System.out.println(arrayNesting(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int arrayNesting(int[] nums) {

		boolean[] visited = new boolean[nums.length];
		int res = 0;

		for(int i = 0; i < nums.length;i++){

			if(!visited[i]){
				int cnt = 0;
				int start = nums[i];

				do{

					start = nums[start];
					visited[start] = true;
					cnt++;
				}while(start != nums[i]);

				res = Math.max(cnt,res);
			}
		}

		return res;
	}

	public static int arrayNesting_eff(int[] nums) {

		int res = 0;

		for(int i = 0; i < nums.length;i++){

			if(nums[i] != Integer.MAX_VALUE){
				int cnt = 0;
				int start = nums[i];

				do{

					start = nums[start];
					nums[start] = Integer.MAX_VALUE;
					cnt++;
				}while(start != nums[i]);

				res = Math.max(cnt,res);
			}
		}

		return res;
	}

	
}
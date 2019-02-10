import java.util.*;

public class Maximize_dist{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 0, 0, 0};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }

		System.out.println(maxDistToClosest(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int maxDistToClosest(int[] nums){

		int[] leftD = new int[nums.length];
		int[] rightD = new int[nums.length];

		leftD[0] = 1;
		rightD[nums.length - 2] = 1;

		for(int i = 1;i < nums.length;i++){

			if(nums[i] == 0){
				if(nums[i - 1] == 1){
					leftD[i] = 1;
				}else{
					leftD[i] = leftD[i - 1] + 1;
				}
			}

		}

		for(int i = nums.length - 2;i >= 0;i--){

			if(nums[i] == 0){
				if(nums[i + 1] == 1){
					rightD[i] = 1;
				}else{
					rightD[i] = rightD[i + 1] + 1;
				}
			}

		}

		int max_dist = 0;
		for(int i = 0;i < nums.length;i++){

			int msf = Math.min(leftD[i],rightD[i]);
			if(msf > max_dist){
				max_dist = msf;
			}

		}

		return max_dist;



	}

}
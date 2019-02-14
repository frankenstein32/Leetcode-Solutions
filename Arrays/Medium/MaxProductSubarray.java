import java.util.*;

public class MaxProductSubarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {2, 3, -2, 4};
		int target = 8;
		System.out.println(maxProduct(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int maxProduct(int[] arr){

	  	int[] max = new int[arr.length];
		int[] min = new int[arr.length];
		int res = Integer.MIN_VALUE;
		max[0] = min[0] = arr[0];

		for(int i = 1;i < arr.length;i++){

			if(arr[i] > 0){

				max[i] = Integer.max(arr[i],max[i - 1]*arr[i]);
				min[i] = Integer.min(arr[i],min[i - 1] * arr[i]);
			}else{

				max[i] = Integer.max(arr[i],min[i - 1]*arr[i]);
				min[i] = Integer.min(arr[i],max[i - 1]* arr[i]);
			}

			res = Integer.max(res,max[i]);
		}

		return res;


	}
	
}
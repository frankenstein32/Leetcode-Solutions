import java.util.*;

public class MissingNumber{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(check(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int check(int[] nums){

		int n = nums.length;
		int orig_sum = n * (n + 1)/2;

		int curr_sum = 0;
		for(int i = 0;i < n;i++){
			curr_sum += nums[i];
		}

		return orig_sum - curr_sum;
	}

}
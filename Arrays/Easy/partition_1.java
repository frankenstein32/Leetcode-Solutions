import java.util.*;

public class partition_1{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1,4,3,2};
		System.out.println(arrayPairSum(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int arrayPairSum(int[] nums){

			
		Arrays.sort(nums);
		int sum = 0;
		for(int i = 0;i < nums.length;i += 2){

			sum += nums[i];
		}

		return sum;
	}

	public static int PairSum_eff(int[] nums){

		int[] arr = new int[20001];

		for(int val : nums){

			arr[val + 10000]++;
		}

		int sum = 0;
		boolean odd = true;
		for(int i = 0;i < arr.length;i++){

			while(arr[i] > 0){

				if(odd){
					sum += arr[i] - 10000;
				}

				odd = !odd;
				arr[i]--;
			}
		}

		return sum;

	}
}
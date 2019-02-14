import java.util.*;

public class MinSizeSubarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(arr,target));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int minSubArrayLen(int[] arr,int s){

		if(arr == null || arr.length == 0){

			return 0;
		}

		int i = 0;
		int j = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		while(j < arr.length){

			if(sum < s){
				sum += arr[j];
				j++;
			}else{
				minLen = Integer.min(minLen,j - i);

				if(i == j - 1){
					return 1;
				}

				sum -= arr[i];
				i++;

			}
		}

		while(s <= sum){
			minLen = Integer.min(minLen,j - i);

			sum -= arr[i];
			i++;
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;

	}
	
}
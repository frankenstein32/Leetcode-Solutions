import java.util.*;

public class MaxOnes{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(cnt(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int cnt(int[] nums){

		int maxCount = 0;
		int count = 0;


		for(int i = 0;i < nums.length;i++){

			if(nums[i] == 1){
				count++;
			}else{
				count = 0;
			}

			if(count > maxCount){
				maxCount = count;
			}
		}

		return maxCount;
	}
}
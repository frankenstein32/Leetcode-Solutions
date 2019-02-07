import java.util.*;

public class ThirdMax{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(find(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int find(int[] nums){

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		for(int i = 0; i < n;i++){

			max1 = Math.max(nums[i],max1);
		}	

		for(int i = 0; i < n;i++){

			if(nums[i] < max1 && nums[i] > max2)
				max2 = nums[i];
		}	

		for(int i = 0; i < n;i++){

			if(nums[i] < max2 && nums[i] > max3)
				max3 = nums[i];
		}	

		if(max2 == Integer.MIN_VALUE || max3 == Integer.MIN_VALUE){

			return max1;
		}

		return max3;



	
	}

}
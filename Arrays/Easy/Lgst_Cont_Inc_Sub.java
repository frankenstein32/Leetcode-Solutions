import java.util.*;

public class  Lgst_Cont_Inc_Sub{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {2,2,2,2,2};
		int k = 4;
		// display2(arr);
		
		System.out.println(findLengthOfLCIS(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int findLengthOfLCIS(int[] nums){

		
		int anchor = -1;
		int max = 0;
		for(int i = 0;i < nums.length;i++){

			if(i > 0 && nums[i - 1] > nums[i])
				anchor = i;

			max = Math.max(max,i - anchor + 1);
		}

		return max;
	}


	
		
}

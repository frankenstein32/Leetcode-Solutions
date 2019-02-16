import java.util.*;

public class MaxWidthRamp{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {6,0,8,2,1,5};
		int target = 2;
		String str = "00110";
		System.out.println(maxWidthRamp(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(Integer[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maxWidthRamp(int[] nums) {

	 
	 	Integer[] temp = new Integer[nums.length];

	 	for(int i = 0;i < nums.length;i++){
	 		temp[i] = i;
	 	}

	 	Arrays.sort(temp,(i, j) -> ((Integer)nums[i]).compareTo(nums[j]));

	 	int res = 0;
	 	int min = nums.length - 1;

	 	for(int i = 0;i < temp.length;i++){

	 		res = Math.max(res,temp[i] - min);
	 		min = Math.min(temp[i],min);
	 	}

	 	return res;

	 }
}
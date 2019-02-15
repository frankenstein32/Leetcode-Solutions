import java.util.*;

public class RepeatedSubarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr1 = {1,2,3,2,1};
		int[] arr2 = {3,2,1,4,7};
		int target = 2;
		String str = "00110";
		System.out.println(findLength(arr1, arr2));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(Integer[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int findLength(int[] arr1, int[] arr2){

	 	return helper(arr1,0,arr2,0);
	 }

	 public static int helper(int[] arr1, int vidx1, int[] arr2, int vidx2){

	 	if(vidx1 >= arr1.length || vidx2 >= arr2.length){
	 		return 0;
	 	}

	 	if(arr1[vidx1] == arr2[vidx2]){

	 		return helper(arr1, vidx1 + 1,arr2,vidx2 + 1) + 1;
	 	}else{

	 		int fh = helper(arr1,vidx1 + 1,arr2,vidx2);
	 		int sh = helper(arr1,vidx1,arr2,vidx2 + 1);
	 		return Math.max(fh,sh);
	 	}


	 }
}
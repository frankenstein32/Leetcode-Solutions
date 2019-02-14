import java.util.*;

public class ProductOfArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {0,2,3,4,6,8,9};
		int target = 7;
		display(productExceptSelf(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int[] productExceptSelf(int[] nums) {
	    

	    
	}
	
}
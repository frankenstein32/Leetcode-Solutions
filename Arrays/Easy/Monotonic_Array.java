import java.util.*;

public class  Monotonic_Array{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={1,2,2,3};
		int k = 4;
		// display2(arr);
		
		System.out.println(isMonotonic(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static boolean isMonotonic(int[] nums){

		boolean isInc = false;
		boolean isDec = false;

		for(int i = 1;i < nums.length;i++){

			if(nums[ i - 1] == nums[i]){
				continue;
			}else if(nums[i - 1] < nums[i] && !isDec){
				isInc = true;
			}else if(nums[i - 1] > nums[i] && !isInc){
				isDec = true;
			}else{
				return false;
			}
		}

		return true;
	}


	
		
}

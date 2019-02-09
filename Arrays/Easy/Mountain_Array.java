import java.util.*;

public class Mountain_Array{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={0, 3, 2, 1};
		int k = 4;
		
		display(validMountainArray(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] validMountainArray(int[] nums){

		if(nums.length < 3){
			return false;
		}

		int N = nums.length;
		int i = 0;

		while(i + 1 < N && nums[i] < nums[i + 1]){
			j++;
		}

		if(i == 0 || i == N - 1){
			return false;
		}

		while(i + 1 < N && nums[i] > nums[i + 1]){
			i++;
		}

		return i == N - 1;
	}


	
		
}
	
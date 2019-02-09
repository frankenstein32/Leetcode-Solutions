import java.util.*;

public class SquaresOfSorted{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={3, 1, 2, 4};
		int k = 4;
		
		display(sortedSquares(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] sortedSquares(int[] nums){

		for(int i = 0;i < nums.length;i++){

			nums[i] *= nums[i];
		}
		Arrays.sort(nums);
		
		return nums; 

	}

	public static int[] sortedSquares_eff(int[] nums){


		int j = 0;
		int N = nums.length;
		while(j < N && nums[j] < 0){
			j++;
		}

		int i = j - 1;
		int[] arr = new int[nums.length];
		int k = 0;

		while(i >= 0 && j < nums.length){

			if(nums[i] * nums[i] > nums[j] * nums[j]){
				arr[k++] = nums[j] * nums[j];
				j++;
			}else{
				arr[k++] = nums[i] * nums[i];
				i++;
			}
		}

		while(i >= 0){
			arr[k++] = nums[i] * nums[i];
			i--;
		}

		while(j < nums.length){

			arr[k++] = nums[j] * nums[j];
			j++;
		}

		return arr;



	}


	
		
}

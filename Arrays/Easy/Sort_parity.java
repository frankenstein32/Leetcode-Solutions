import java.util.*;

public class  Sort_parity{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={3, 1, 2, 4};
		int k = 4;
		// display2(arr);
		
		display(sortArrayByParity(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] sortArrayByParity(int[] nums){

		int i = 0;
		int j = 0;

		while(j < nums.length){

			if(nums[j] % 2 == 0){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}

			j++;
		}

		return nums;
	}


	
		
}

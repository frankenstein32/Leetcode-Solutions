import java.util.*;

public class  Sort_parity_2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={3, 1, 2, 4};
		int k = 4;
		// display2(arr);
		
		display(sortArrayByParityII(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] sortArrayByParityII(int[] nums){

		int i = 0;
		int j = 0;

		while(j < nums.length){

			if((i % 2 == 0 && nums[j] % 2 == 0) || (i % 2 == 1 && nums[j] % 2 == 1)){
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

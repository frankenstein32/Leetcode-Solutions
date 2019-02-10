import java.util.*;

public class bit_character{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(isOneBitCharacter(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static boolean isOneBitCharacter(int[] nums){

		int category = 0;

		for(int i = 0;i < nums.length;){

			if(nums[i] == 0){

				category = 1;
				i++;
			}else if(nums[i] == 1){
				category = 2;
				i += 2;
			}
		}

		return category == 1;
	}

}
import java.util.*;

public class RemoveDuplicates{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(removeDuplicates(arr));
		display(arr);

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int removeDuplicates(int[] nums){

		int i = 0,j = 1;

		while(i < nums.length && j < nums.length){

			if(i < nums.length - 1 && nums[i] != nums[j]){

				nums[i + 1] = nums[j];
				i++;
			}

			j++;
		}

		return i + 1;

	}
}
import java.util.*;

public class RemoveElement{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int val = scn.nextInt();

		System.out.println(removeElement(arr,val));
		display(arr);

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int removeElement(int[] nums,int val){

		
		int i = 0,j = 0;

		int cnt = 0;

		while(i < nums.length && j < nums.length){

			if(nums[j] == val){
			}else{
				nums[i] = nums[j];
				i++;
			}

			j++;
		}

		return i;

	}
}
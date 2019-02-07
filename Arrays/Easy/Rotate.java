import java.util.*;

public class Rotate{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int rot = scn.nextInt();

		rotate(arr,rot);
		display(arr);
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static void rotate(int[] nums,int rot){


		int n = nums.length;
		int count = 0;
		for(int start = 0; count < n;start++){

			int curr = start;
			int prev = nums[start];

			do{

				int next = (curr + rot) % n;
				int temp = nums[next];

				nums[next] = prev;
				prev = temp;
				curr = next;
				count++;

			}while(curr != start);
		}
	}

}
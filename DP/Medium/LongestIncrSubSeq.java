import java.util.*;

public class LongestIncrSubSeq{

	public static void main(String[] args){

		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(findLength(arr));
	}

	public static int findLength(int[] arr){

		return helper(arr,0);
	}

	public static int helper(int[] arr, int vidx){

		for(int i = vidx;i < arr.length;i++){
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
		}
	}

	
	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

	
}
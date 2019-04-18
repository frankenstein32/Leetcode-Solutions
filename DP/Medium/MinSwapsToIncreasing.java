import java.util.*;

public class MinSwapsToIncreasing{

	public static void main(String[] args){

		int[] A = {1, 3, 5, 4};
		int[] B = {1, 2, 3, 7};
		// int k = 3;
		System.out.println(minSwap(A, B));
		
	}

	public static int minSwap(int[] A, int[] B){

		return helper(A, B, 0);
	}

	public static int helper(int[] A, int[] B, int vidx){

		if(vidx == A.length){
			return 0;
		}

		int inc = Integer.MAX_VALUE;
		int exc = Integer.MAX_VALUE;

		swap(A, B, vidx);
		inc = helper(A, B, vidx + 1) + 1;
		swap(A, B, vidx);

		exc = helper(A, B, vidx + 1);

		return Math.min(inc, exc);

	}

	public static void swap(int[] A, int[] B, int vidx){

		int temp = A[vidx];
		A[vidx] = B[vidx];
		B[vidx] = temp;
	}

	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
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
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

}
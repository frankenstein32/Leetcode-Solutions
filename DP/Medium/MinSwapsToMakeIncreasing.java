import java.util.*;

public class MinSwapsToMakeIncreasing{

	public static void main(String[] args){

		int[] A = {1, 3, 5, 4};
		int[] B = {1, 2, 3, 7};
		System.out.println(minSwap(A, B));
	}

	public static int minSwap(int[] A, int[] B){

		int[][] strg = new int[A.length ][2];

		for(int[] val : strg)
			Arrays.fill(val, -1);
		System.out.println(helperBU(A, B));
		System.out.println(helperTD(A, B, 0,0,strg));
		return helper(A, B, 0);
	}

	public static int helper(int[] A, int[] B, int i){

		if(i == A.length){
			return 0;
		}


		int inc =  Integer.MAX_VALUE;
		if(i == 0  || A[i] > A[i - 1] && B[i] > B[i - 1]){

			inc = helper(A, B, i + 1);

		}

		int exc = Integer.MAX_VALUE;

		if(i == 0 || A[i] > B[i - 1] && B[i] > A[i - 1]){

			swap(A, B, i);
			exc = helper(A, B, i + 1) + 1;
			swap(A, B, i);
		}

		return Math.min(inc, exc);
	}

	public static int helperTD(int[] A, int[] B, int i, int swap, int[][] strg){

		if(i == A.length){
			return 0;
		}

		if(strg[i][swap] != -1){
			return strg[i][swap];
		}


		int inc =  Integer.MAX_VALUE;
		if(i == 0  || A[i] > A[i - 1] && B[i] > B[i - 1]){

			inc = helperTD(A, B, i + 1, 0, strg);

		}

		int exc = Integer.MAX_VALUE;

		if(i == 0 || A[i] > B[i - 1] && B[i] > A[i - 1]){

			swap(A, B, i);
			exc = helperTD(A, B, i + 1, 1, strg) + 1;
			swap(A, B, i);
		}

		return strg[i][swap] = Math.min(inc, exc);
	}

	public static int helperBU(int[] A, int[] B){

		int[] notSwapped = new int[A.length];
		int[] swapped = new int[B.length];

		swapped[0] = 1;

		for(int i = 1;i < A.length;i++){	
			swapped[i] = notSwapped[i] = A.length;

			if(A[i] > A[i - 1] && B[i] > B[i - 1]){

				notSwapped[i] = notSwapped[i - 1];
				swapped[i] = swapped[i - 1] + 1;
			}

			if(A[i] > B[i - 1] && B[i] > A[i - 1]){

				notSwapped[i] = Math.min(notSwapped[i], swapped[i - 1]);
				swapped[i] = Math.min(swapped[i], notSwapped[i - 1] + 1);
			}
		}

		return Math.min(notSwapped[A.length - 1], swapped[A.length - 1]);
		
	}

	public static void swap(int[] A, int[] B, int i){

		int temp = A[i];
		A[i] = B[i];
		B[i] = temp;
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
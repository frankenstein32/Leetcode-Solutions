import java.util.*;

public class SumOfEvenNumQueries{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr ={1, 2, 3, 4};

		int[][] q = {{1,0},{-3,1},{-4,0},{2,3}};
		int k = 4;
		
		display(sumEvenAfterQueries(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] sumEvenAfterQueries(int[] nums){

		for(int i = 0;i < nums.length;i++){

			nums[i] *= nums[i];
		}
		Arrays.sort(nums);
		
		return nums; 

	}

	public static int[] sortedSquares_eff(int[] A,int[][] queries){

		int s = 0;
		for(int val : A)
			if(val % 2 == 0)
				s += val;

		int[] ans = new int[queries.length];
		for(int i = 0;i < queries.length;i++){

			int val = queries[i][0];
			int idx = queries[i][1];

			if(A[idx] % 2 == 0){

				s = s - A[idx];
			}

			A[idx] += val;

			if(A[idx] % 2 == 0){

				s += A[idx];
			}

			ans[i] = s;	

		}

		return ans;

	}


	
		
}
	
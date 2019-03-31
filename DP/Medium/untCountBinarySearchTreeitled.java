import java.util.*;

public class untCountBinarySearchTree{

	public static void main(String[] args){

		int n = 3;
		System.out.println(count(n));
		
	}

	public static int count(int n){

		int[] arr = new int[n];

		for(int i = 0;i < n;i++){
			arr[i] = i + 1;
		}

		return helper(arr, 0, arr.length - 1);
	}

	public static int helper(int[] arr,int si, int ei){

		if(si > ei){
			return 0;
		}

		if(si == ei || si + 1 == ei){
			return ei - si + 1;
		}

		
		int ans = 0;
		for(int i = si;i < ei;i++){

			int part1 = helper(arr, si, i);
			int part1 = helper(arr, i + 1, ei);

			ans += part1 * part2;
		}

		return ans;


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
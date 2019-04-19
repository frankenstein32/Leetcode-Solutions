import java.util.*;

public class CountLongestIncrSubSeq{

	public static void main(String[] args){

		int[] arr = {1, 3, 5, 4, 7};
		System.out.println(findLength(arr));
	}

	public static int findLength(int[] arr){

		int[] tails = new int[arr.length];
		int[] count = new int[arr.length];

		Arrays.fill(count, 1);
		int size = 0;
		for(int x : arr){

			int i = 0;
			int j = size;

			while(i != j){

				int mid = (i + j)/2;

				if(x > tails[mid]){
					i = mid + 1;
					
				}else {
					j = mid;
					count[j]++;
				}
			}
			tails[i] = x;

			// if(size != 0)
			// 	count[size - 1]++;

			if(i == size){
				size++;
			}
		}

		display(tails);
		display(count);

		int max = 0;
		for(int val : count){
			max = Math.max(val,max);
		}
		return max;
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
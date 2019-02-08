import java.util.*;

public class Transpose{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		display2(transpose(arr));

	}

 	public static void display2(int[][] arr){

 		System.out.print("[");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print("[");
 			for(int j = 0;j < arr[0].length;j++)
 			System.out.print(arr[i][j] +" ");
 		System.out.print("]");
 		
 		}
 		System.out.println("]");
 	}

	public static int[][] transpose(int[][] nums){

		int[][] ans = new int[nums[0].length][nums.length];


		for(int i = 0;i < nums.length;i++){
			for(int j = 0; j < nums[0].length;j++){

				ans[j][i] = nums[i][j];
			}
		}

		return ans;
	
	}

	
}

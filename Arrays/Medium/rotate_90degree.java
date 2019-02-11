import java.util.*;

public class rotate_90degree{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		rotate_90degree(arr);

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

 	public static void rotate_90degree(int[][] nums){


 		transpose(nums);

 		for(int row = 0; row < nums.length;row++){

 			for(int colStart = 0,colEnd = nums.length - 1; colStart < colEnd;colStart++,colEnd--){

 				int temp = nums[row][colStart];
 				nums[row][colStart] = nums[row][colEnd];
 				nums[row][colEnd] = temp;
 			}
 		}
 	} 

	public static void transpose(int[][] nums){


		for(int i = 0;i < nums.length;i++){
			for(int j = i; j < nums[0].length;j++){

				int temp = nums[i][j];
				nums[i][j] = nums[j][i];
				nums[j][i] = temp;
			}
		}
	}

	
}

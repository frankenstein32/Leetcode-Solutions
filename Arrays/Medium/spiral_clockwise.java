import java.util.*;

public class spiral_clockwise{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		print(arr);

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

 	public static ArrayList<Integer> print(int[][] nums){

 		int n = nums.length;
 		int m = nums[0].length;

 		int count = 1;

 		int minRow = 0;
 		int maxRow = n - 1;
 		int minCol = 0;
 		int maxCol = m - 1;
 		List<Integer> ans = new ArrayList<>();
 		while(count <= n * m){

 			for(int col = minCol;col <= maxCol && count <= n * m;col++){

 				ans.add(nums[minRow][col]);
 				count++;
 			}

 			minRow++;

 			for(int row = minRow;row <= maxRow && count <= n * m;row++){
 				ans.add(nums[row][maxCol]);
 				count++;
 			}

 			maxCol--;

 			for(int col =  maxCol;col >= minCol && count <= n * m;col--){
 				ans.add(nums[maxRow][col]);
 				count++;
 			}

 			maxRow--;

 			for(int row = maxRow;row >= minRow && count <= n * m; row--){

 				ans.add(nums[row][minCol]);
 				count++;
 			}
 			minCol++;


 		}

 		return ans;
 	} 
}

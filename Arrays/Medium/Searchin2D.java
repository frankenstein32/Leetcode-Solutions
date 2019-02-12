import java.util.*;

public class Searchin2D{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int k = 7;
		// display2(arr);
		
		System.out.println(search(arr,k));

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

 	public static boolean search(int[][] mat, int item){

 		if(mat == null || mat.length == 0 || mat[0].length == 0){
 			return false;
 		}

 		int n = mat[0].length;
 		int m = mat.length;
 		int start = 0;
 		int end =  n * m - 1;

 		while(start <= end){

 			int mid = (start + end)/2;
 			int midx = mid/n;
 			int midy = mid%n;

 			if(mat[midx][midy] == item){
 				System.out.println(midx+" "+midy);
 				return true;
 			}else if(mat[midx][midy] < item){
 				start = mid + 1;
 			}else{
 				end = mid - 1;
 			}
 		}

 		return false;
 	}


}

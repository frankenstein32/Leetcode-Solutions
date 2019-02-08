import java.util.*;

public class Flip_Image{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		display2(flipAndInvertImage(arr));

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

	public static int[][] flipAndInvertImage(int[][] nums){

		for(int[] arr : nums){

			int i = 0;

			while(i < arr.length/2){

				int temp = arr[i];
				arr[i] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = temp;
				i++;
			}

			for(int k = 0;k < arr.length;k++){
				arr[k] = (arr[k] == 1?0:1);
			}
		}

		return nums;
	
	}

	public static void flip(int[] arr){


		int i = 0;

		while(i <= arr.length/2){

			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;

			arr[i] = ( arr[i] == 1 ? 0 : 1 );
			if(i != arr.length/2)
				arr[arr.length - i - 1] = ( arr[arr.length - i - 1] == 1 ? 0 : 1 );


			i++;
		}
	}
}

import java.util.*;

public class Key2Keyboard{

	public static void main(String[] args){

		System.out.println(minSteps(6));
		
	}

	public static int minSteps(int n){

		return helper(n);
	}

	public static int helper(int n){

		if(n == 1){

			return 0;
		}

		for(int i = 2; 	i < n;i++){

			if(n % i == 0){
				return helper(n / i) + i;
			}
		}

		return n;
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
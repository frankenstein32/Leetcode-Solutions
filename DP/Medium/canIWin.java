import java.util.*;

public class canIWin{

	public static void main(String[] args){

		int maxChoose = 10;
		int target = 11;
		System.out.println(win(maxChoose, target));
		
	}

	public static boolean win(int maxChoose, int target){

		return helper(maxChoose, target, 0);
	}

	// public static boolean helper(int maxChoose, int target, int turn){

	// 	if(maxChoose == 0){
	// 		return false;
	// 	}

	// 	if(target <= 0){

	// 		System.out.println(maxChoose+" "+turn);
	// 		return (turn == 0 ? false : true);
	// 	}

	// 	int nextTurn = (turn == 0 ? 1 : 0);
	// 	boolean inc = helper(maxChoose - 1, target - maxChoose,nextTurn);
	// 	boolean exc = helper(maxChoose - 1, target, turn);

	// 	return inc || exc;
		
	// }

	public static boolean helper(int maxChoose, int target, int turn){

		if(maxChoose == 0){

			if(target <= 0 ){
				if(turn  == 0)
					return false;
				return true;
			}
			if(turn == 1)
				return true;
			return false;
		}

		if(target <= 0){

			System.out.println(maxChoose+" "+turn);
			return (turn == 0 ? false : true);
		}

		int nextTurn = (turn == 0 ? 1 : 0);
		boolean inc = helper(maxChoose - 1, target - maxChoose,nextTurn);
		boolean exc = helper(maxChoose - 1, target, turn);

		return (turn == 0 ? inc || exc : inc && exc);
		
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
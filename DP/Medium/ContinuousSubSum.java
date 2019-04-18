import java.util.*;

public class ContinuousSubSum{

	public static void main(String[] args){

		int[] arr = {23, 2, 6, 4, 7};
		int k = 6;
		System.out.println(count(arr, k));
	}

	public static boolean count(int[] arr, int k){

		if(arr.length < 2){
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		int runSum = 0;

		for(int i = 0;i < arr.length;i++){

			runSum += arr[i];

			if(k != 0){
				runSum %= k;
			}

			Integer prev = map.get(runSum);

			if(prev != null){

				if(i - prev > 1)
					return true;
			}else{
				map.put(runSum, i);
			}
		}

		return false;

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
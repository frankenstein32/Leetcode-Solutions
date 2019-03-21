import java.util.*;
import java.awt.Point;
public class Multiplicity3Sum{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] tree = {1,1,2,2,3,3,4,4,5,5};

		System.out.println(threeSumMulti(tree, 8));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int threeSumMulti(int[] A, int target){

		HashMap<Integer, Integer> map = new HashMap<>();

		int res = 0;
		int mod = 1_000_000_007;

		for(int i = 0;i < A.length;i++){

			res = (res + map.getOrDefault(target - A[i], 0) % mod);

			for(int j = 0; j < i;j++){

				int temp = A[i] + A[j];
				map.put(temp,map.getOrDefault(temp,0) + 1);
			}
		}

		return res;
	}

	
}
import java.util.*;
import java.awt.Point;
public class FruitIntoBasket{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] tree = {0, 1, 2, 2};

		System.out.println(totalFruit(tree));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int totalFruit(int[] tree){

		if(tree == null || tree.length == 0){
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<>();

		int max = 1;
		int i = 0;
		int j = 0;

		while(j < tree.length){

			if(map.size() <= 2){

				map.put(tree[j], j++);
			}
			if(map.size() > 2){

				int min = tree.length - 1;

				for(int value : map.values()){

					min = Math.min(min, value);
				}

				i = min + 1;
				map.remove(tree[min]);
			}

			max = Math.max(max, j - i);
		}

		return max;


	}

	
}
import java.util.*;

public class DeckOfCards{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};

		System.out.println(hasGroupsSizeX(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean hasGroupsSizeX(int[] nums){

		
		HashMap<Integer,Integer> map = new HashMap<>();

		for(int i = 0;i < nums.length;i++){

			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i],1);
			}
		}

		int ideal = -1;

		for(int key : map.keySet()){

			if(map.get(key) < 2){
				return false;
			}

			if(ideal == -1){
				ideal = map.get(key);
			}else{
				ideal = gcd(ideal,map.get(key));
			}
		}

		return ideal >= 2;

	}

	public static int gcd(int x, int y){

		if(x == 0){
			return y;
		}

		return gcd(y%x,x);
	}

}
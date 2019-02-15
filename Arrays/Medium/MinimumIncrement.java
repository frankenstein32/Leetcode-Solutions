import java.util.*;

public class MinimumIncrement{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 2, 1, 2, 1 ,7};
		int target = 2;
		String str = "00110";
		System.out.println(minIncrementForUnique(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int minIncrementForUnique(int[] nums) {

	 	HashMap<Integer,Boolean> map = new HashMap<>();

	 	// int min = 0;	
	 	int res = 0;

	 	for(int num : nums){

	 		if(!map.containsKey(num)){
	 			map.put(num,true);
	 		}else{

	 			while(map.containsKey(num)){
	 				res++;
	 				num++;
	 			}

	 			map.put(num,true);
	 		}
	 	}

	 	return res;
	 }
}
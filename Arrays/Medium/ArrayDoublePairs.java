import java.util.*;

public class ArrayDoublePairs{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 2, 1, 2, 1 ,7};
		int target = 2;
		String str = "00110";
		System.out.println(canReorderDoubled(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int canReorderDoubled(int[] nums) {

	 	
	 	HashMap<Integer,Integer> map = new HashMap<>();

	 	for(int num : nums){

	 		map.put(num,map.getOrDefault(num,0) + 1);
	 	}

	 	int[] B = new int[nums.length];

	 	for(int i = 0;i < nums.length;i++){
	 		B[i] = nums[i];
	 	}

	 	Arrays.sort(B,Comparator.comparingInt(Math::abs));

	 	for(int x : B){

	 		if(map.get(x) == 0)
	 			continue;

	 		if(map.getOrDefault(2*x,0) <= 0)
	 			return false;

	 		count.put(x,count.get(x) - 1);
	 		count.put(2*x,count.get(2*x) - 1);

	 	}

	 	return true;

	 }
}
import java.util.*;

public class ContainsDuplicate2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(check(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static boolean check(int[] nums){

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length;i++){

			if(map.containsKey(nums[i])){

				int val = map.get(nums[i]);

				if(Math.abs(i - j) <= k)
					return true;
			}else{
				map.put(nums[i],1);
			}
		}

		return false;
	}

}
import java.util.*;

public class FindAll{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {4,3,2,7,8,2,3,1};

		System.out.println(find(arr));
	}

 	public static void display(int[] arr){

 		System.out.print("Indice=> ");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print((i + 1) +" ");
 		}
 		System.out.println();
 		System.out.print("Values=> ");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<Integer> find(int[] nums){

		for(int i = 0;i < nums.length;i++){
			
			int val = Math.abs(nums[i]);

			if(nums[val - 1] >= 0){
				nums[val - 1] = -nums[val - 1];
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0;i < nums.length;i++){

			ans.add(i + 1);
		}
		return ans;
	
	}

}
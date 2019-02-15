import java.util.*;

public class Maxchunks{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,0,2,3,4};
		int target = 2;
		System.out.println(maxChunksToSorted(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maxChunksToSorted(int[] nums) {

	 	
	 	Stack<int[]> st = new Stack<>();

	 	for(int i = 0;i < nums.length;i++){

	 		int min = nums[i];
	 		int max = nums[i];

	 		while(!st.isEmpty()){

	 			int[] top = st.peek();
	 			if(nums[i] < top[1]){

	 				min = Math.min(min, top[0]);
	 				max = Math.max(max, top[1]);
	 				st.pop();
	 			}else{
	 				break;
	 			}
	 		}

	 		st.push(new int[]{min,max});
	 	}

	 	return st.size();
	}

	
}
import java.util.*;

public class MaxChunksToSorted2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 3, 1};
		int k = 1;
		System.out.println(maxChunks(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int maxChunks(int[] nums){


		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i < nums.length;i++){

			if(stack.isEmpty() || stack.peek() <= nums[i]){
				stack.push(nums[i]);
			}else{

				int top = stack.pop();

				while(!stack.isEmpty() && stack.peek() > nums[i]){
					stack.pop();
				}

				stack.push(top);
			}
		}

		return stack.size();
	}	
}
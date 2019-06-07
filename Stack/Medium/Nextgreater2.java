import java.util.*;

public class Nextgreater2{


	public static void main(String[] args){

		String preorder = "";


	}
	 
	public static int[] nextGreater(int[] nums){

		Stack<Integer> stack = new Stack<>();
		int[] res = new int[nums.length];

		for(int i = 2 * nums.length - 1;i >= 0;i--){


			while(!stack.isEmpty() && nums[i % nums.length] < nums[stack.peek()]){

				stack.pop();
			}

			res[i % nums.length] =(stack.isEmpty()? -1 : nums[stack.peek()]);
			stack.push(i % nums.length);
		}

		return res;
	}
}
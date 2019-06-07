import java.util.*;

public class pattern132{


	public static void main(String[] args){

		String preorder = "";


	}

	static class pair{

		int min;
		int max;

		public pair(int min, int max){

			this.min = min;
			this.max = max;
		}
	}

	public static boolean findPattern(int[] nums){

		 Stack<pair> stack = new Stack<>();


		for(int i = 0;i < nums.length;i++){


			if(stack.isEmpty() || stack.peek().min > nums[i]){
				stack.push(new pair(nums[i], nums[i]));
			}else if(nums[i] > stack.peek().min){

				pair last = stack.pop();

				if(last.max > nums[i]){
					return true;
				}else{

					last.max = nums[i];

					while(!stack.isEmpty() && stack.peek().max <= nums[i]) stack.pop();

					if(!stack.isEmpty() && stack.peek().min < nums[i]) return true;

					stack.push(last);
				}
			}

		}

		return false;
	}
}
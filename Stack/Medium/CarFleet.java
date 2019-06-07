import java.util.*;

public class CarFleet{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int[] calculate(int[] temp){

		int[] res = new int[temp.length];

		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i < nums.length;i++){

			while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){

				int prevDay = stack.pop();
				int currDay = nums[i];

				res[prevDay] = currDay - prevDay - 1;
			}

			stack.push(i);
		}


		while(!stack.isEmpty()){

			res[stack.pop()] = 0;
		}



		return res;
	}
}
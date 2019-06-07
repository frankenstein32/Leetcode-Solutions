import java.util.*;

public class ValidateSequence{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int MinCount(int[] pushed, int[] popped){

		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int i = 0;i < pushed.length;i++){

			stack.push(pushed[i]);

			while(!stack.isEmpty() && stack.peek() == popped[j]){
				stack.pop();
				j++;
			}

			
		}


		
	}
}
import java.util.*;

public class VerifyPreorder{


	public static void main(String[] args){

		String preorder = "";


	}

	public static boolean isValid(String preorder){

		Stack<String> stack = new Stack<>();

		String[] str = preorder.split(",");

		for(int i = 0;i < str.length;i++){

			String curr = preorder[i];

			while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals(curr)){
				
				if(stack.isEmpty()){
					return false;
				}

				stack.pop();

			}

			stack.push(curr);
		}

		return stack.size() == 1 && stack.peek().equals("#");
	}
}
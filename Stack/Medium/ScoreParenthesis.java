import java.util.*;

public class ScoreParenthesis{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int score(String s){

 
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for(Character c : s.toCharArray()){

			if(c == '('){
				stack.push(0);
			}else{

				int v = stack.pop();
				int w = stack.pop();

				w = w + Math.max(2 * v, 1);
				stack.push(w);
			}
		}

		return stack.pop();
	}
}
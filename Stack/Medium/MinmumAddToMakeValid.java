import java.util.*;

public class MinmumAddToMakeValid{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int MinCount(String S){

		int count = 0;

		Stack<Character> stack = new Stack<>();

		for(int i =0;i < S.length();i++){

			char ch = S.charAt(i);

			if(ch == '('){
				stack.push(ch);
			}else{

			
				if(!stack.isEmpty() && stack.peek() == '('){
					stack.pop();
					continue;
				}

				stack.push(ch);
			}
		}

		return stack.size();
	}
}
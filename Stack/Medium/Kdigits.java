import java.util.*;

public class Kdigits{


	public static void main(String[] args){

		String preorder = "";


	}

	public static String remove(String strm, int k){


		Stack<Character> stack = new Stack<>();

		for(int i  = 0;i < str.length();i++){

			char ch = str.charAt(i);

			while(!stack.isEmpty() && stack.peek() > ch){
				stack.pop();
				k--;
			}

			stack.push(ch);
		}

		while(!stack.isEmpty() && k > 0){
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();

		for(!stack.isEmpty()){

			sb.append(stack.pop());
		}

		sb.reverse();

		while(sb.length() > 1 && sb.charAt(0) == '0'){
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
import java.util.*;

public class RemoveOuterParenthesis{


	public static void main(String[] args){


	}

	public static int Remove(String str){

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StrinBuilder();
		for(int i = 0;i < str.length();i++){

			char ch = str.charAt(i);

			if(ch == '('){

				sb.append(ch);
				stack.push(ch);
			}else{

				sb.append(ch);
				stack.pop();
			}

			if(stack.isEmpty()){

				sb.removeAt(0);
				sb.removeAt(sb.length() - 1);

				res.append(sb);
				sb = new StringBuilder();

			}
		}

		return sb.toString();


	}	



}
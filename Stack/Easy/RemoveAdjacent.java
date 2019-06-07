import java.util.*;

public class RemoveAdjacent{


	public static void main(String[] args){


	}

	public static int RemoveDuplicates(String str){

		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i < str.length();i++){

			char ch = str.charAt(i);

			while(!stack.isEmpty && stack.peek() == ch){

				stack.pop()
			}

			stack.push(ch);
		}

		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty()){

			sb.append(0,stack.pop());
		}

		return sb.toString();

	}	



}
import java.util.*;

public class BaseBallGame{


	public static void main(String[] args){

	}

	public static int calculatePoints(String[] str){


		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i < str.length;i++){


			String op = str[i];
			int item = Integer.parseInt(op);

			if(op.equals("+")){

				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());

				item = a + b;
				stack.push(item);
			}else if(op.equals("D")){	

				int a = Integer.parseInt(stack.pop());
				item = 2 * a;
				stack.push(item);
			}else if(op.equals("C")){

				int a = Integer.parseInt(stack.pop());

			}else{
				stack.push(item);
			}
		}

		return stack.pop();
	}

	


}
import java.util.*;

public class BasicCalculator{


	public static void main(String[] args){

		String postorder = "";


	}

	public static int calculate(String str){


		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int sign = 1;

		for(int i = 0;i < str.length();i++){

			char ch = str.charAt(i);

			if(Character.isDigit(ch)){

				int sum = ch - '0';
				while(i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))){

					sum = sum * 10 + str.charAt(i + 1) - '0';
					i++;
				}

				result += sum * sign;


			}else if(ch == '+'){
				sign = 1;
			}else if(ch == '-'){
				sign = -1;
			}else if(ch == '('){
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;

			}else if(ch == ')'){

				result = result * stack.pop() + stack.pop();
			}
		}


		return result;
	}


}
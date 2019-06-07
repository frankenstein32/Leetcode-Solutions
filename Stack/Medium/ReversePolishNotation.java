import java.util.*;

public class ReversePolishNotation{


	public static void main(String[] args){


	}

	public static int calculate(String[] str){

		 Stack<Integer> st = new Stack<>();

		for(int i = 0;i < str.length;i++){

			String op = str[i];

			if(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")){

				st.push(Integer.parseInt(op));
				continue;
			}

			int n1 = st.pop();
			int n2 = st.pop();

			if(op.equals("+")){

				st.push(n1 + n2);
			}else if(op.equals("-")){
				st.push(n1 - n2);
			}else if(op.equals("*")){
				st.push(n1 * n2);
			}else{
				st.push(n1 / n2);
			}
		}

		return st.pop();
	}
	

}
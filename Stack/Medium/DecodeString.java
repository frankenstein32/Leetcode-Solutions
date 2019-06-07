import java.util.*;

public class DecodeString{


	public static void main(String[] args){

		String preorder = "";


	}

	public static boolean decode(String s){

		Stack<Integer> count = new Stack<>();
		Stack<String> resStack = new Stack<>();

		String res = "";	

		for(int idx = 0;idx < s.length();){

			char ch = s.charAt(idx);
			
			if(Character.isDigit(ch)){
				int num = 0;

				while(!stack.isEmpty() && Character.isDigit(s.charAt(idx)){

					num = num * 10 + (s.charAt(i) - '0');
					idx++;
				}

				count.push(num);
			}else if(ch == '['){

				resStack.push(res);
				res = "";
				idx++;

			}else if(ch == ']'){

				StringBuilder sb = new StrinBuilder(resStack.pop());
				int repeat = count.pop();

				for(int i = 0;i < repeat;i++){
					sb.append(res);
				}

				res = sb.toString();
				idx++;
			}else{

				res += ch;
				idx++;
			}
		}
	}
}
import java.util.*;

class reconstructQueue{

    public String removeKdigits(String str, int k){

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < str.length();i++){

            char ch = str.charAt(i);

            while(!stack.isEmpty() && stack.peek() > ch && k > 0){
                stack.pop();
            }

            stack.push(ch);        
        }

        while(!stack.isEmpty() && k > 0){
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){

            sb.insert(0, stack.pop());
        }

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}



	
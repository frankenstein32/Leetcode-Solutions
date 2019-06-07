import java.util.*;

public class DecodeAtIndex{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int decode(String S, int K){
		
		long size = 0;

		for(int i = 0;i < S.length();i++){

			if(Character.isDigit(S.charAt(i))){

				size *= S.charAt(i) - '0';
			}else{
				size++;
			}

		}

		for(int i = S.length() - 1; i >= 0;i--){

			char ch = str.charAt(i);
			K = K % size;

			if(K == 0 && !Character.isDigit(ch)){
				return ch.toString();
			}

			if(Character.isDigit(ch)){

				size /= ch - '0';
			}else{
				size--;
			}
		}

		return "Yo";


	}
}
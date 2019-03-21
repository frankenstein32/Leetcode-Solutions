import java.util.*;

public class LetterCasePermutation{

	public static void main(String[] args){


		int n = 1;
		int k = 1;

		System.out.println(readWatch(1));

	}

	public static List<String> prmt(String s){


	    prmt(s,"");
        return temp;
	}

	static List<String> temp = new ArrayList<>();

	public static void prmt(String s, String ans){


		if(s.length() == 0){

			System.out.println(ans);
			temp.add(ans);
			return;
		}


		char ch = s.charAt(0);
		String ros = s.substring(1);


		// if(ch >= 'A' && ch <= 'Z'){

  //       	prmt(ros,ans + ch);
		// 	prmt(ros,ans + (char)(ch + 32));

		// }else if(ch >= 'a' && ch <= 'z'){

  //       	prmt(ros,ans + ch);
		// 	prmt(ros, ans + (char)(ch - 32));
		// }else{
  //            prmt(ros,ans + ch);
  //       }

		if(Character.isLetter(ch)){

			char ch1 = Character.toLowerCase(ch);
			prmt(ros, ans + ch1);
			char ch2 = Character.toUpperCase(ch);
			prmt(ros, ans + ch2);
		}else{
			prmt(ros,ans + ch);
		}
	}
	
}
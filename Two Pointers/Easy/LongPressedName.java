import java.util.*;

public class LongPressedName{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String name = "alex";
		String typed = "aalleexx";
		System.out.println(isLongPressedName(name, typed));
		
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean isLongPressedName(String S, String T){

		int j = 0;

		for(char ch : S.toCharArray()){

			if(j == T.length()){
				return false;
			}
			if(ch != T.charAt(j)){
				
				if(j == 0 || T.charAt(j) != T.charAt(j - 1)){
					return false;
				}

				char cur = T.charAt(j);
				while(j < T.length() && T.charAt(j) == cur){
					j++;
				}

				if(j == T.length() || T.charAt(j) != ch){
					return false;
				}

			}

			j++;
		}

		return true;
	}	
}
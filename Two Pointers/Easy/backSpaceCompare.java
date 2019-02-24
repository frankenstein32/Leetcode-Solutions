import java.util.*;

public class backSpaceCompare{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String ch = "hello";
		System.out.println(Reverse(ch));
		
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean compareTo(String S, String T){

	
        int i = S.length() - 1;
		int j = T.length() - 1;

		int skipS = 0;
		int skipT = 0;

		while(i >= 0 || j >= 0){

			while(i >= 0){

				if(S.charAt(i) == '#'){
					skipS++;
					i--;
				}else if(skipS > 0){
					skipS--;
					i--;
				}else{
					break;
				}
			}

			while(j >= 0){

				if(T.charAt(j) == '#'){
					skipT++;
					j--;
				}else if(skipT > 0){
					skipT--;
					j--;
				}else{
					break;
				}	
			}

			if(i >= 0 && j>= 0 && S.charAt(i) != T.charAt(j)){
				return false;
			}

			if(i >= 0 != j >= 0){
				return false;
			}

			i--;
			j--;

		}
		
		return true;
	}	
}
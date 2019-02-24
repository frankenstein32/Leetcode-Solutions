import java.util.*;

public class Validpalindrome{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		String str = "A man, a plan, a canal: Panama";
		String needle = "issip";
		System.out.println(isPalindrome(str));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean isPalindrome(String str){

		int i = 0;
		int n = str.length();
		int j = n - 1;
		while(i < str.length()){

			if(!isValid(str.charAt(i))){
				i++;
			}else if(!isValid(str.charAt(j))){

				j--;
			}else if(str.charAt(i) != str.charAt(j)){
				return false;
			}

			i++;
			j--;
		}

		return true;
	
	}	

	public static boolean isValid(char ch){

		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}
}
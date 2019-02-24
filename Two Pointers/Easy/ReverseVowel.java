import java.util.*;

public class ReverseVowel{
	
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

	public static String Reverse(String arr){

		char[] charray = arr.toCharArray();
		List<Character> list = Arrays.asList(new Character[]{'a','A','e','E','i','I','o','O','u','U'});
		Set<Character> dummy = new HashSet<>(list);
		int i = 0;
		int j = arr.length() - 1;

		while(i < j){

			while(i < arr.length() && !dummy.contains(charray[i])){
				i++;
			}

			while(j >= 0 && !dummy.contains(charray[j])){
				j--;
			}

			if(i < j){

				char temp = charray[i];
				charray[i] = charray[j];
				charray[j] = temp;
				i++;
				j--;                                                                                            
			}
		}

		return new String(charray);

	}	
}
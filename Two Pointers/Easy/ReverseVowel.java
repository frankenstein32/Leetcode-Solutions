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
		List<Character> list = Arrays.asList(new Character[]{'a','e','i','o','u'});
		Set<Character> dummy = new HashSet<>(list);
		int i = 0;
		int j = arr.length() - 1;

		while(i < j){

			while(!dummy.contains(charray[i])){
				i++;
			}

			while(!dummy.contains(charray[j])){
				j--;
			}

			if(i < j){

				char temp = charray[i];
				charray[i] = charray[arr.length() - i - 1];
				charray[arr.length() - i - 1] = temp;
				i++;
				j--;
			}
		}

		return new String(charray);

	}	
}
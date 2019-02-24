import java.util.*;

public class ReverseString{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		char[] ch = {'h','e','l','l','o'};
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int Reverse(char[] arr){

		
		int i = 0;
		int j = arr.length - 1;
		while(i < j){

			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;

		}


	}	
}
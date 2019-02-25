import java.util.*;
import java.awt.Point;
public class PushDominoes{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String dominoes = ".L.R...LR..L..";

		System.out.println(push(dominoes));
		
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static String push(String dominoes){

		if(dominoes == null || dominoes.length() == 0){
			return "";
		}

		int n = dominoes.length();
		int[] left = new int[n];
		int[] right = new int[n];

		int cnt = 0;
		for(int i = 0;i < n;i++){

			if(dominoes.charAt(i) == 'R'){
				cnt = 1;
			}else if(dominoes.charAt(i) == 'L'){
				cnt = 0;
			}

			if(cnt > 0){
				right[i] = cnt++;
			}
		}

		for(int i = n - 1; i >= 0;i--){

			if(dominoes.charAt(i) == 'L'){
				cnt = 1;
			}else if(dominoes.charAt(i) == 'R'){
				cnt = 0;
			}

			if(cnt > 0){
				left[i] = cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < n;i++){

			if(left[i] == 0 && right[i] == 0){
				sb.append(".");
			}else if(left[i] == 0 && right[i] != 0){
				sb.append("R");
			}else if(left[i] != 0 && right[i] == 0){
				sb.append("L");
			}else{

				int diff = left[i] - right[i];
				sb.append(diff == 0 ? "." : diff > 0 ? "R" : "L");
			}
		}

		return sb.toString();

	}
	
}
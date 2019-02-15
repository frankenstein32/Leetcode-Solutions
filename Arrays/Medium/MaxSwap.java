import java.util.*;

public class MaxSwap{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5, 4, 0, 3, 1, 6, 2};
		int target = 2;
		System.out.println(maximumSwap(2736));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int maximumSwap(int num) {

	 	char[] charray = Integer.toString(num).toCharArray();

	 	int[] arr = new int[10];

	 	for(int i = 0;i < charray.length;i++){

	 		arr[charray[i] - '0'] = i;
	 	}

	 	for(int i = 0;i < charray.length;i++){

	 		for(int d = 9; d > charray[i] - '0';d--){

	 			if(arr[d] > i){

	 				char temp = charray[i];
	 				charray[i] = charray[arr[i]];
	 				charray[arr[i]] = temp;

	 				return Integer.valueOf(new String(charray));
	 			}
	 		}
	 	}
		return num;
	}

	
}
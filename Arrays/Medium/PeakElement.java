import java.util.*;

public class PeakElement{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 3, 1};
		int target = 8;
		System.out.println(findPeakElement(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int findPeakElement(int[] arr){

	if(arr.length == 1){
		return 0;
	}
	  int i = 0;
	  int peak = -1;

	  while(i < arr.length - 1){

	  	if(arr[i] > arr[i + 1]){
	  		peak = i;
	  		return peak;
	  	}

	  	i++;
	  }
	  return i;
	}


	
}
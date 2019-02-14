import java.util.*;

public class MinInRotatedArray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 4, 5, 1, 2};
		int target = 8;
		System.out.println(findMin(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int findMin(int[] arr){

	  if(arr == null || arr.length == 0){
	  	return -1;
	  }

	  int lo = 0;
	  int hi = arr.length - 1;

	  if(arr[lo] < arr[hi]){
	  	return arr[lo];
	  }

	  while(lo <= hi){

	  	if(arr[lo] <= arr[hi]){
	  		return arr[lo];
	  	}

	  	int mid = (lo + hi)/2;

	  	if(arr[lo] <= arr[mid]){
	  		lo = mid + 1;
	  	}else{
	  		hi = mid;
	  	}
	  }

	  return -1;

	}
	
}
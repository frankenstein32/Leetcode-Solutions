import java.util.*;
import java.awt.Point;
public class LongestMountain{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {2,1,4,7,3,2,5};

		System.out.println(longestMountain(arr));
		
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int longestMountain(int[] A){

		int increase = 0;
		int decrease = 0;

		int maxLen = 0;
		for(int i = 1;i < A.length;i++){

			if(A[i] > A[i - 1]){

				if(decrease > 0){
					increase = decrease = 0;
				}
				increase++;
			}else if(A[i] == A[i - 1]){
				increase = decrease = 0;
			}else if(increase > 0){

				decrease++;
				maxLen = Math.max(maxLen,increase + decrease + 1);

			}
		}

		return maxLen

	}
	
}
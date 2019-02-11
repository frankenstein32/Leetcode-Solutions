import java.util.*;

public class Conainted_Water{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,8,6,2,5,4,8,3,7};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }

		System.out.println(maxArea(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int maxArea(int[] height){

		
		int i = 0;
		int j = height.length - 1;

		int maxArea = 0;

		while(i < j){

			int h1 = height[i];
			int h2 = height[j];

			int area = Math.min(h1,h2) * (j - i);

			if(area > maxArea){
				maxArea = area;
			}

			if(h1 < h2){
				i++;
			}else{
				j--;
			}


		}

		return maxArea;



	}

}
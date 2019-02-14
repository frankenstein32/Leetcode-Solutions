import java.util.*;

public class RemoveDuplicates2{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {0,0,1, 1, 1, 1, 2, 3, 3};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }

		int n = removeDuplicates(arr);
		System.out.println(n);

		display(arr,n);
	
	}

 	public static void display(int[] arr,int len){

 		for(int i = 0 ;i < len;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int removeDuplicates(int[] arr){

		if(arr.length < 3){
			return arr.length;
		}

		int prev = 1;
		int curr = 2;

		while(curr < arr.length){


			if(arr[prev] == arr[curr] && arr[prev] == arr[prev - 1]){
				curr++;
			}else{

				prev++;
				arr[prev] = arr[curr];
				curr++;
			}
		}

		return prev;
	}
}
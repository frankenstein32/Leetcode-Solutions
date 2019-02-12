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

		 
		 int i = 0;
		 int j = 0;
		int cnt = 0;

		 while(j < arr.length){

		 	if(arr[i] != arr[j]){

		 		if(cnt < 3){
		 			int temp = arr[i];
			 		arr[i] = arr[j];
			 		arr[j] = temp;
		 		
		 		}
		 		i = j;
		 		cnt = 1;
		 		
		 	}else{
		 		cnt++;
		 	}
		 	j++;
		 }

		 return i;
	}
}
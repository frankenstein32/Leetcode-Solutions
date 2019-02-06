import java.util.*;

public class merge2sorted{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int m = scn.nextInt();
		int[] arr2 = new int[m];

		for(int i = 0;i < m;i++){

			arr2[i] = scn.nextInt();
		}

		// int val = scn.nextInt();

		display(merge(arr,arr2));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] merge(int[] A,int m,int[] B,int n){

		
		 while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }        
	}
}
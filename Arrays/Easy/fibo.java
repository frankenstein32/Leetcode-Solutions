import java.util.*;

public class fibo{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		System.out.println(fibo(n));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int fibo(int n){

		int a = 0;
		int b = 1;

		for(int i = 0;i < n;i++){
			int c = a + b;
			a = b;
			b = c;
		}

		return a;
	}
}
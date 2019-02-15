import java.util.*;

public class MonotoneIncreasing{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {5,-3,5};
		int target = 2;
		String str = "00110";
		System.out.println(minFlipsMonoIncr(str));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int minFlipsMonoIncr(String S) {

	 	
	 	int[] p = new int[S.length() + 1];

	 	for(int i = 0;i < S.length;i++){

	 		p[i + 1] = p[i] + (s.charAt(i) == '1' ? 1 : 0);
	 	}

	 	int ans = Integer.MAX_VALUE;

	 	for(int j = 0;j <= N;j++){

	 		ans = Math.min(ans, p[j] + (S.length() - i) - (p[S.length() - p[i]]));
	 	}

	 	return ans;



	 }
}
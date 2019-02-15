import java.util.*;

public class LongestFiboLength{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,0,2,3,4};
		int target = 2;
		System.out.println(count(arr,2,4));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int count(int[] ages) {

	 	int[] count = new int[121];

	 	for(int age : ages)
	 		count[age]++;	

	 	int res = 0;

	 	for(int i = 0;i < 121;i++){

	 		countA = count[i];
	 		for(int j = 0; j < 121;j++){
	 			countB = count[j];

	 			if(0.5 * i + 7 > j) continue;
	 			else if(i < j) continue;
	 			else if(i < 100 && j > 100) continue;

	 			res += countA * countB;

	 		}

	 		return res;
	 	}


	}
}
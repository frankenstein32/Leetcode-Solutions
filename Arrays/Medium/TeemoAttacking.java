import java.util.*;

public class TeemoAttacking{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2};
		int target = 2;
		System.out.println(findPoisonedDuration(arr,target));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int findPoisonedDuration(int[] timeSeries, int duration) {

	 	if(timeSeries.length == 0)
	 		return 0;

	 	int res = duration;

	 	for(int i = 1;i < nums.length;i++){

	 		res += timeSeries[i - 1] + duration - 1 < timeSeries[i] ? duration : timeSeries[i] - timeSeries[i - 1];
	 	}

		return res;
}
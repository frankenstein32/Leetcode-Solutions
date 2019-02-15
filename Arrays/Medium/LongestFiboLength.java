import java.util.*;

public class LongestFiboLength{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1,0,2,3,4};
		int target = 2;
		System.out.println(lenLongestFibSubseq(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int lenLongestFibSubseq(int[] nums) {

	 	Set<Integer> set = new HashSet<>();

	 	for(int num : nums){
	 		set.add(num);
	 	}

	 	int max = 0;

	 	for(int i = 0;i < nums.length;i++){
	 		for(int j = i + 1; j < nums.length;j++){


	 			int len = 2;

	 			int a = nums[i];
	 			int b = nums[j];

	 			int sum = a + b;

	 			while(set.contains(sum)){

	 				len++;
	 				a = b;
	 				b = sum;
	 				max = Math.Max(max,len);
	 				sum = a + b;
	 			}
	 		}
	 	}

	 	return max;
	}


}
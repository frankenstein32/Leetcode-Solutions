import java.util.*;

public class Plus_One{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		// int val = scn.nextInt();

		display(add(arr));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] add(int[] nums){

		int i = nums.length - 1;
		ArrayList<Integer> res = new ArrayList<>();
		

		int carry = 1, sum = 0;
		while(i >= 0){

			sum = carry + nums[i];

			int rem = sum % 10;
			carry = sum/10;

			res.add(0,rem);

			i--;
		}

		if(carry != 0){
			res.add(0,carry);
		}

		int[] ans = new int[res.size()];

		i = 0;
		for(int val : res){

			ans[i++] = val;

		}

		return ans;
	}
}
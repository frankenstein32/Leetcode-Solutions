import java.util.*;

public class Add2ArrayForm{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		int k = scn.nextInt();

		System.out.println(addToArrayForm(arr,k));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<Integer> addToArrayForm(int[] nums,int k){

		int i = nums.length - 1;

		List<Integer> ans = new ArrayList<>();

		int carry = 0;

		while(i >= 0 || k != 0){

			int sum = carry;

			if(i >= 0)
				sum += nums[i];

			if(k != 0){

				int rem = k % 10;
				sum += rem;
				k /= 10;
			}

			int val = sum % 10;
			carry = sum / 10;

			ans.add(0,val);

			i--;
		}

		if(carry != 0)
			ans.add(0,carry);

		return ans;

	}

}
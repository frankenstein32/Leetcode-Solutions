import java.util.*;

public class Shortest_unsorted_subarray{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {2,6,4,8,10,9,15};
		// display2(arr);
		
		System.out.println(findUnsortedSubarray_eff(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int findUnsortedSubarray(int[] nums){

		int r = 0;
		int l = nums.length;

		for(int i = 0;i < nums.length;i++){

			for(int j = i + 1;j < nums.length;j++){
				

				if(nums[j] < nums[i]){

					r = Math.max(r,j);
					l = Math.min(l,i);
				}
			}
		}

		return r - l < 0? 0 : r - l + 1;

	}

	public static int findUnsortedSubarray_eff(int[] nums){

		int end = 0;
		int start = nums.length;

		int[] dummy = nums.clone();
		Arrays.sort(dummy);

		for(int i = 0;i < nums.length;i++){

			if(nums[i] != dummy[i]){

				start = Math.min(start,i);
				end = Math.max(end,i);

			}
		}

		return end - start < 0? 0 : end - start + 1;

	}

	public static int findUnsortedSubarray_eff2(int[] nums){


		int start = nums.length;
		int end = 0;
		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i  < nums.length;i++){

			while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
				start = Math.min(start,stack.pop());
			}
			stack.push(i);
		}

		for(int i = arr.length - 1;i >= 0;i--){

			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
				end = Math.max(end,stack.pop());
			}
			stack.push(i);
		}

		return end - start > 0 ? end - start + 1 : 0;		

	}



	
		
}

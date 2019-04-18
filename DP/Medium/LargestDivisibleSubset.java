import java.util.*;

public class LargestDivisibleSubset{

	public static void main(String[] args){

		int[] arr = {3,4,16,8};
		System.out.println(find(arr));
		
	}

	public static int find(int[] arr){

		List<Integer> ans = new ArrayList<>();
		int res = helper(arr, -1, 0, ans);

		System.out.println(ans);
		return res;
	}
	static boolean bool = true;
	public static int helper(int[] arr, int prev, int curr, List<Integer> ans){


		if(curr == arr.length){
			return 0;
		}	

		int inc = 0, exc = 0;

		if(prev == -1 || arr[prev] % arr[curr] == 0 || arr[curr] % arr[prev] == 0){
			inc = helper(arr, curr, curr + 1, ans) + 1;
		}

		exc = helper(arr, prev, curr + 1, ans);

		System.out.println(inc +" : "+exc +" : "+ arr[curr]);
		if(inc > exc){
			ans.add(arr[curr]);
		}
		return Math.max(inc, exc);

	}

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

	
}
import java.util.*;

public class SameConseqDiff{

	public static void main(String[] args){

		// Main
		System.out.println(SameDiff(2, 1));

		
	}

	public static int[] SameDiff(int n, int k){

		List<Integer> ans = new ArrayList<>();

		if(k == 0){
			ans.add(0);
		}
		helper(n, k, 0, ans);

		int[] arr = new int[ans.size()];

		for(int i = 0;i < arr.length;i++){
			arr[i] = ans.get(i);
		}

		return arr;
	}

	public static void helper(int n, int k, int num, List<Integer> ans){

		if(n == 0){

			ans.add(num);
			return;
		}

		int i = 0;
		if(num == 0){
			i = 1;
		}

		for(;i <= 9;i ++){

			if(num == 0 || Math.abs(num % 10 - i) == k){

				helper(n - 1,k,num * 10 + i,ans);
			}	
		}
	}


	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

	

	
}
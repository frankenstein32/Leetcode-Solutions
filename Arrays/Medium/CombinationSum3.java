import java.util.*;

public class CombinationSum3{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {2,3,1,2,4,3};
		int target = 7;

		int k = 3;
		int n = 7;
		System.out.println(minSubArrayLen(n, k));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> minSubArrayLen(int k, int n){

		return helper(k,n,1);
	}

	public static List<List<Integer>> helper(int k,int n,int num){

		if(n == 0 && k == 0){

			List<List<Integer>> br = new LinkedList<>();
			br.add(new ArrayList<>());
			return br;
		}

		if(num > 9 || k <= 0){
			List<List<Integer>> br = new LinkedList<>();
			return br;
		}

		List<List<Integer>> mr = new LinkedList<>();
		List<List<Integer>> rr1 = helper(k, n,num + 1);

		for(List<Integer> val : rr1){
			mr.add(val);
		}

		List<List<Integer>> rr2 = helper(k - 1,n - num,num + 1);


		for(List<Integer> val : rr2){
			val.add(0,num);
			mr.add(val);
		}

		return mr;
	}
	
}
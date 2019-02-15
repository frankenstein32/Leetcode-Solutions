import java.util.*;

public class Subset{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2,3};

		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		System.out.println(subsets(arr));
		System.out.println(subsets_itr(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<List<Integer>> subsets(int[] arr){


		List<List<Integer>> ans = new ArrayList<>();
		for(int n = 0;n <= (int)Math.pow(2,arr.length) - 1;n++){

			List<Integer> each = new ArrayList<>();
			int i = 0;
			int num = n;
			while(num != 0){

				int rem = num % 2;

				if(rem == 1){
					each.add(arr[i]);
				}
				num /= 2;
				i++;
			}
			ans.add(each);
		}

		return ans;


	}

	public static List<List<Integer>> subsets_itr(int[] S) {
		
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(S);

		for(int i = 0;i < S.length;i++){
			
			List<List<Integer>> temp = new ArrayList<>();

			for(List<Integer> a : res)
				temp.add(new ArrayList<>(a));

			for(List<Integer> a : temp)
				a.add(S[i]);

			List<Integer> single = new ArrayList<>();
			single.add(S[i]);
			temp.add(single);

			res.addAll(temp);
		}

		res.add(new ArrayList<>());

		return res;


	}


	
}
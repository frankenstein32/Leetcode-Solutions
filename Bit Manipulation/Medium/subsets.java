import java.util.*;

class subsets {

	public static void main(String[] args){

		int[] arr = {1,2,3};
		System.out.println(subsets(arr));
	}

	public static List<List<Integer>> subsets(int[] arr){

		int num = (int)Math.pow(2, arr.length);
		List<List<Integer>> res = new ArrayList<>();


		for(int j = 0;j < num;j++){
			List<Integer> set = new ArrayList<>();
			for(int i = 0;i < arr.length;i++){
				if(((j >> i) & 1 ) == 1){
					set.add(arr[i]);
				}

			}

			res.add(set);
		}

		return res;
	}
}


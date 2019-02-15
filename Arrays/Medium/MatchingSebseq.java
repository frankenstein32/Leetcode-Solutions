import java.util.*;

public class MatchingSebseq{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2,3};
		String s = "dsahjpjauf";

		String[] word = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		// for(int i = 0;i < n;i++){

		// 	arr[i] = scn.nextInt();
		// }
		int target = 8;
		System.out.println(subsets(s,word));
		// System.out.println(subsets_itr(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int subsets(String S,String[] words){


		HashMap<String,Integer> map = new HashMap<>();

		for(String word : words){

			map.put(word,map.getOrDefault(word,0) + 1);
		}
		

		int count = 0;
		for(String word : map.keySet()){

			if(isSubseq(word,S)){
				count += map.get(word);
			}
		}

		return count;
	}

	public static boolean isSubseq(String word,String S){


		if(word.length() > S.length()){
			return false;
		}

		int i = 0;
		int j = 0;

		while(i < word.length() && j < S.length()){

			if(word.charAt(i) == S.charAt(j)){
				i++;
				j++;
			}else{
				j++;
			}
		}

		return i == word.length();
	}

	
}
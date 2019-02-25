import java.util.*;

public class LongestWordDeletion{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String name = "alex";
		String typed = "aalleexx";
		System.out.println(find(name, typed));
		
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static String find(String S, List<String> d){

		List<Integer> res = new ArrayList<>();

		int[] table = new int[26];
		char[] stc = S.toCharArray();

		for(char c : stc)
			table[c - 'a']++;

		int i = 0, j = 0, l = S.length(), counter;
		HashSet<Integer> hs = new HashSet<>();

		while(j < l){

			char c = stc[j];

			if(!hs.contains(c)){
				hs.add(c);
				counter++;
			}

			table[c - 'a']--;
			j++;

			if(table[c - 'a'] == 0){
				counter--;
				hs.remove(c);
			}

			if(counter == 0){

				res.add(j - i);
				i = j;
			}
		}

		return res;


	}
}
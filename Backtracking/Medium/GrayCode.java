import java.util.*;

public class GrayCode   {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		String s = "catsanddog";
		List<String> Wordbreak = new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog" }));
		System.out.println(breakIt(s, Wordbreak));

	}

	 public static int graycode(int n){


        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);

        int mask = 1;

        for(int i = 1;i < n;i++){

            for(int j = ans.size() - 1;j >= 0;j--){

                ans.add(list.get(j) | mask);
            }
            mask = mask << 1;
        }
     }
}
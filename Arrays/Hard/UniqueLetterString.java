import java.util.*;

public class UniqueLetterString{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		String s = "catsanddog";
		List<String> Wordbreak = new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog" }));
		System.out.println(breakIt(s, Wordbreak));

	}

	 public int uniqueLetterString(String S) {


            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

            for(int i = 0;i < S.length();i++){

                char c = S.charAt(i);
               map.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
            }

        long ans = 0;
        for (List<Integer> A: map.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

            return (int)ans % 1_000_000_007;
        }
}
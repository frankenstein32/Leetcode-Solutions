import java.util.*;

class findAllAnagrams{

   public int longestPalindrome(String s){

    HashSet<Integer> hs = new HashSet<>();

    int count = 0;
    for(char ch : s.toCharArray()){

      if(hs.contains(ch)){
        hs.remove(ch);
        count++;
      }else{
        hs.add(ch);
      }
    }

    return !hs.isEmpty() ? 2 * count : 2 * count + 1;

   }
}



	
import java.util.*;

public class UncommonWords{

   public String[] uncommonFromSentences(String A, String B) {
        
     HashMap<String, Integer> count = new HashMap<>();

      for(String a : A.split(" "))
        count.put(a,count.getOrDefault(a, 0) + 1);
      for(String b : B.split(" "))
        count.put(b,count.getOrDefault(b, 0) + 1);

      List<String> ans = new ArrayList<>();

      for(String word : count.keySet()){

        if(count.get(word) == 1){
          ans.add(word);
        }
      }

      return ans.toArray(new String[ans.size()]);
    }
}



	
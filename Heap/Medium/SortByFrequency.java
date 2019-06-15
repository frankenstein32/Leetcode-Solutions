import java.util.*;

public class SortByFrequency{


      
    public String frequencySort(String S){

      HashMap<Character, Integer> map = new HashMap<>();

      for(char ch : S.toCharArray()){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      PriorityQueue<Character> pq = new PriorityQueue<>();

      StringBuilder sb = new StringBuilder();

      for(char ch : map.keySet()){

        pq.offer(ch);
      }

      while(!pq.isEmpty()){

          char ch = pq.poll();
          int cnt = map.get(ch);
           
          while(cnt != 0){
              sb.append(ch);
              cnt--;
          }

      }

      return sb.toString();

    }
}
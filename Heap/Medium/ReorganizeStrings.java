import java.util.*;

public class ReorganizeStrings{

    class Pair{

      char val;
      int cnt;

      public Pair(int v, int c){ this.val = v; this.cnt = c;}
    }

   
    public String reorganizeString(String S){

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : S.toCharArray()){

          map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);

        for(char ch : map.keySet()){

          pq.offer(new Pair(ch, map.get(ch))); 
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){

          Pair a = pq.poll();
          Pair b = pq.poll();

          sb.append(a.val);

          if(a.cnt > 1){
            pq.offer(new Pair(a.val, a.cnt - 1));
          }

          sb.append(b.val);

          if(b.cnt > 1){
            pq.offer(new Pair(b.val, b.cnt - 1));
          }
        }

        if(!pq.isEmpty()) sb.append(pq.poll().val);
    
         if(sb.length() == S.length())
            return sb.toString();
         else
             return "";


     }
}
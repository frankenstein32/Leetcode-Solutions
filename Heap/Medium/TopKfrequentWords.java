import java.util.*;

public class TopKfrequentWords{

  HashMap<String, Integer> count;
   public List<String> topKFrequent(String[] words, int k){

        count = new HashMap<>();

        for(String word :words){

          count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));

          for(String word : count.keySet()){

            pq.offer(word);

            if(pq.size() > k){
              pq.poll();
            }
          }

        List<String> ans = new ArrayList<>();

        for(int i = 0;i < k;i++){

          ans.add(pq.poll());
        }

        return ans;
   }

   class StringComparator implements Comparator<String>{


      @Override
      public int compare(String s1, String s2){

        return (count.get(s1) > count.get(s2) : -1 : (s1.compareTo(s2)));
      }
   }

}
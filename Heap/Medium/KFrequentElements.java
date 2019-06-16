import java.util.*;

public class KFrequentElements{


      
   public List<Integer> topKFrequent(int[] nums, int k){

    HashMap<Integer, Integer> count = new HashMap<>();

    for(int num : nums){
      count.put(count.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));

    for(int key : count.keySet()){

      pq.offer(key);

      if(pq.size() > k){
        pq.poll();
      }
    }

    List<Integer> ans = new ArrayList<>();

    while(!pq.isEmpty()){
      ans.add(pq.poll());
    }

    return ans;

   }
}
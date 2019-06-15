import java.util.*;

public class TopKfrequentWords{

   
   public int networkDelayTime(int[][] times, int N, int K){

      HashMap<Integer, HashMap<Integer, Integer>>timing = new HashMap<>();

      for(int[] arr : times){

        if(!timing.containsKey()){
          timing.put(arr, new HashMap<>());
        }

        timing.get(arr[0]).put(arr[1], arr[2]);
      }

      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

      HashMap<Integer, Integer> map = new HashMap<>();

      pq.offer(new int[]{0, K});

      while(!pq.isEmpty()){

        int[] top = pq.poll();

        int time = top[0];
        int val = top[1];

        if(map.containsKey(val)){
          continue;
        }

        map.put(val, time);


        HashMap<Integer, Integer> adj = timing.get(val);

        for(int a : adj.keySet()){

          queue.offer(new int[]{time + adj.get(a), a});
        }
      }

      if(map.size() != times.length){
        return -1;
      }

      int ans = 0;
      for(int cand : map.values()){

        ans = Math.max(ans, cand);

      }

      return ans;


   }
}
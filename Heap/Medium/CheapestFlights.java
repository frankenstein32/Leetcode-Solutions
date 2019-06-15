import java.util.*;

public class CheapestFlights{

   
     public int findcheapestPrice(int n, int[][] flights, int src, int dst, int k){

        HashMap<Integer, HashMap<Integer, Integer>> prices = new HashMap<>();

        for(int[] f : flights){

         if(!prices.containsKey(f[0])){
            prices.put(f[0], new HashMap<>());
         }

         prices.get(f[0]).put(f[1], f[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, src, k});

        while(!pq.isEmpty()){

          int[] top = pq.poll();
          int price = top[0];
          int city  = top[1];
          int stops = top[2];

          if(city == dst) return price;

          if(stops > 0){

            HashMap<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());

            for(int a : adj.keySet()){

                pq.offer(new int[]{price + adj.get(a), a, stops - 1});
            }
          }
        }

        return -1;

     }
}
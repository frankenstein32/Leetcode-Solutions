import java.util.*;

public class DistantBarcodes{

   class Pair{

    int val;
    int cnt;

    public Pair(int v, int c){ this.val = v; this.cnt = c;}
   }

   public int[] rearrangeBarCodes(int[] barcodes){

    HashMap<Integer, Integer> map = new HashMap<>();

    for(int codes : barcodes){

        map.put(codes, map.getOrDefault(codes, 0) + 1);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);

    for(Map.Entry<Integer, Integer> entry : map){

        pq.offer(entry.getKey(),entry.getValue());
    }

    int i = 0;
    int[] res = new int[barcodes.length];

    while(pq.size() >= 2){

        Pair a = pq.poll();
        Pair b = pq.poll();

        res[i++] = a.val;

        if(a.cnt > 1){
            pq.offer(new Pair(a.val, a.cnt - 1));
        }

        res[i++] = b.val;

        if(b.cnt > 1){
            pq.offer(new Pair(b.val, b.cnt - 1));
        }


    }

   }
}
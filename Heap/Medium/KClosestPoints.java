import java.util.*;

public class KClosestPoints{

   
   public int[][] kClosest(int[][] points, int K){


    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> dist(a) - dist(b));

    for(int[] arr : points){

        pq.offer(arr);
    }

    int[][] ans = new int[K][2];

    for(int i = 0;i <= K;i++){

        ans[i] = pq.poll();
    }

    return ans;
   }

   public int dist(int[] points){

    return points[0] * points[0] + points[1] * points[1];
   }
}
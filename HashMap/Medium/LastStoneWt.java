import java.util.*;

public class LastStoneWt{

    public int lastStoneWeight(int[] stones){

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i < stones.length;i++){
            q.add(stones[i]);
        }

        while(q.size() > 1){

            int s1 = q.poll();
            int s2 = q.poll();

            q.add(s1 - s2);
        }

        return q.poll();
    }

    class reverseComp implements Comparator<Integer>{

        @Override
        public int compare(Integer a, Integer b){

            return (a > b ? -1 : 1);
        }
    }

}
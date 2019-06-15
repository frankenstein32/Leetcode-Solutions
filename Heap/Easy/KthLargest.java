import java.util.*;

public class KthLargest {

	PriorityQueue<Integer> q;
	int k;

    public KthLargest(int k, int[] nums) {
        
        this.k = k;
        this.q = new PriorityQueue<>(k);

        for(int n : nums)
        	q.offer(n);
    }
    
    public int add(int val) {
        
        if(q.size() < k){
        	q.offer(val);
        } else if(q.peek() < val){
        	q.poll();
        	q.offer(val);
        }

        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
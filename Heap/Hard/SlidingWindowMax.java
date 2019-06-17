import java.util.*;

class SlidingWindowMax{

	public int[] maxSlidingWindow(int[] nums, int k){

		   if(arr.length == 0 || k == 0){
            return new int[0];
        }
        
        Deque<Integer> q = new LinkedList<>();
		int[] res = new int[arr.length - k + 1];
		int i = 0;
		int idx = 0;
		for(i = 0;i < k;i++){

			while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]){
				q.removeLast();
			}

			q.addLast(i);
		}

		for(;i < arr.length;i++){

			res[idx++] = arr[q.peek()];

			while(!q.isEmpty() && q.peek() <= i - k){
				q.removeFirst();
			}

			while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]){
				q.removeLast();
			}

			q.addLast(i);
		}
        res[idx] = arr[q.peek()];

		return res;
    }

	public int[] maxSlidingWindow(int[] nums){


		
	}
}

	
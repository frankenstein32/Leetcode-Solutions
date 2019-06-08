import java.util.*;

public class RecentCalls{


	Queue<Integer> q;

	public RecentCalls(){

		q = new LinkedList<>();
	}

	public static int ping(int t){

		queue.add(t);

		while(q.size() > 0){

			int first = q.peek();

			if(3000 < t - first){
				q.poll();
			}else{
				break;
			}
		}	

		return  queue.size();
	}
}
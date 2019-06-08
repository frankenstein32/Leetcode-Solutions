import java.util.*;

public class SubarrayAtleastK{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int shortestSubarray(int[] A, int k){

		int N = A.length;
		int res = N + 1;

		int[] B = new int[N + 1];

		for(int i = 0;i < A.length;i++){
			B[i + 1] = B[i] + A[i];
		}

		Deque<Integer> d = new ArrayDeque<>();

		for(int i = 0;i < A.length;i++){

			while(d.size() > 0 && B[i] - B[d.getFirst()] >= k){

				res = Math.min(res, i - d.pollFirst());
			}

			while(d.size() > 0 && B[i] <= B[d.getLast()])
				d.pollLast();

			d.addLast(i);
		}

		return res <= N ? res : -1;
	}
}
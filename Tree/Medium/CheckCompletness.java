import java.util.*;

public class CheckCompletness{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public boolean isCompleteTree(TreeNode root){

		Queue<Integer> bfs = new LinkedList<>();

		bfs.add(root);


		while(bfs.peek() != null){

			TreeNode rp = bfs.poll();

			bfs.offer(rp.left);
			bfs.offer(rp.right);
		}

		while(!bfs.isEmpty() && bfs.peek() == null){
			bfs.poll();
		}

		return bfs.isEmpty();
	}
	
}
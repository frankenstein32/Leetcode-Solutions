import java.util.*;

public class WidthOfBT{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	class WPair{

		TreeNode node;
		int depth;
		int pos;

		public WPair(TreeNode nn, int d, int p){

			this.node = nn;
			this.depth = d;
			this.pos = p;
		}
	}

	public int WidthOfBinaryTree(TreeNode root){
		if(root == null){
			return 0;
		}

		Queue<WPair> bfs = new LinkedList<>();
		WPair pair = new WPair(root, 0, 0);

		int currDepth = 0;
		int left = 0;
        int ans = 0;
		bfs.offer(pair);

		while(!bfs.isEmpty()){

			WPair rp = bfs.poll();

			if(rp.node != null){

				bfs.offer(new WPair(rp.node.left, rp.depth + 1, 2 * rp.pos));
				bfs.offer(new WPair(rp.node.right, rp.depth + 1, 2 * rp.pos + 1));

				if(currDepth != rp.depth){
					currDepth = rp.depth;
					left = rp.pos;
				}

				ans = Math.max(ans, rp.pos - left + 1);
			}
		}

		return ans;
	}
}
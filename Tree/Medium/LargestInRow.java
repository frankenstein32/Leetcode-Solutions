import java.util.*;

public class LargestInRow{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public List<Integer> largest(TreeNode root){

		if(root == null){
			return -1;
		}

		Queue<TreeNode> q = new LinkedList<>();
		Queue<TreeNode> h = new LinkedList<>();
		int i = 0;
		List<Integer> res = new ArrayList<>();

		q.add(root);
		while(!q.isEmpty()){

			TreeNode rp = q.poll();

			res.set(i,Math.max(res.get(i), rp.val));
			if(rp.left != null){
				h.add(rp.left);
			}

			if(rp.right != null){
				h.add(rp.right);
			}

			if(q.isEmpty()){

				q = h;
				h = new LinkedList<>();
				i++;
			}

		}

		return res;
	}

	public bfs(TreeNode root, List<Integer> res, int d){


		if(root == null){	
			return;
		}

		if(d == res.size()){
			res.add(root.val);
		}else{
			res.set(d,Math.max(res.get(d),root.val));
		}

		bfs(root.left, res, d + 1);
		bfs(root.right, res, d + 1);
	}

}
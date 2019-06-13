import java.util.*;

public class SubTreeDeepestNode{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root){


		return dfs(root).node;
	}

	class Result{

		int dist;
		TreeNode node;

		public Result(TreeNode n, int d){ this.dist = d; this.node = n; }
	}

	public Resut dfs(TreeNode root){

		if(root == null){
			return new Result(null, 0);
		}

		Result L = dfs(node.left);
		Result R = dfs(node.right);

		if(L.dist > R.dist){
			return new Result(root.left, L.dist + 1);
		}

		if(L.dist < R.dist){
			return new Result(root.right, R.dist + 1);
		}

		return new Result(root, L.dist + 1);
	}
	
}
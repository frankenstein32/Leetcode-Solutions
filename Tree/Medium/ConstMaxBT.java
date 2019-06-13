import java.util.*;

public class ConstMaxBT{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public int maxAncestor(TreeNode node){

		return dfs(root, 0, 0);
	}

	public int dfs(TreeNode node, int max, int min){

		if(root == null){
			return max - min;
		}

		max = Math.max(node.val, max);
		min = Math.min(node.val, min);

		return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
	}
}
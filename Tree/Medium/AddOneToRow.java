import java.util.*;

public class AddOneToRow{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode addOneRow(TreeNode root, int v, int d){

		if(d == 1){

			TreeNode head = new TreeNode(v);
			head.left = root;
			return head;
		}

		dfs(root, v, 1, d);

	}

	public void dfs(TreeNode root, int v, int d, int n){

		if(root == null){
			return;
		}

		if(d + 1 == n){
			TreeNode t = root.left;
			root.left = new TreeNode(v);
			root.left.left = t;
			t = root.right;
			root.right = new TreeNode(v);
			root.right.right = t;

			return;
		}

		dfs(root.left, v, d + 1, n);
		dfs(root.right, v, d + 1, n);
	}
	
}
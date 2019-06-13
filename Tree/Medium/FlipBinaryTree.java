import java.util.*;

public class FlipBinaryTree{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode insertIntoMax(TreeNode root, int val){

		if(root != null && root.val > val){

			root.right = insertIntoMax(root.right, val);
			return root.right;
		}

		TreeNode nn = new TreeNode(val);
		nn.left = root;
		return nn;
	}
}
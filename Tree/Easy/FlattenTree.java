import java.util.*;

public class FlattenTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	public void flatten(TreeNode root){

		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		while(!stack.isEmpty()){

			TreeNode curr = stack.pop();

			if(curr.right != null)
				stack.push(curr.right);

			if(curr.left != null)
				stack.push(curr.left);

			if(!stack.isEmpty())
				curr.right =  stack.peek();
			curr.left = null;
		}

		TreeNode prev = null;

		public void flattenRecur(TreeNode root){

			if(root == null)
				return;

			flattenRecur(root.left);
			flattenRecur(root.right);

			root.right = prev;
			root.left = null;
			prev = root;
		}
	}

}
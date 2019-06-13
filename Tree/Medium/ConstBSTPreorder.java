import java.util.*;

public class ConstBSTPreorder{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	int i = 0;

	public TreeNode bstFromPreorder(int[] preorder){

		return dfs(preorder, Integer.MAX_VALUE);
	}

	public TreeNode dfs(int[] preorder, int bound){

		if(i == preorder.length || preorder[i] > bound){
			return null;
		}

		TreeNode nn = new TreeNode(preorder[i++]);

		nn.left = dfs(preorder, root.val);
		nn.right = dfs(preorder, bound);

		return nn;

	}
	
}
import java.util.*;

public class LCA{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){

		if(root == null){
			return null;
		}

		int n1 = p.val;
		int n2 = q.val;

		if(root.val > n1 && root.val > n2){

			return LCA(root.left, p, q);
		}else if(root.val < n1 && root.val < n2){

			return LCA(root.right, p , q);
		}


		return root;
	}


}
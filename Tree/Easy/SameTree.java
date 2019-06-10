import java.util.*;

public class SameTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	public boolean isSame(TreeNode p, TreeNode q){

		if(p == null || q == null){
			return true;
		}

		if(p.val != q.val){
			return false;
		}

		if((p.left == null && q.left != null) || (p.left != null && q.left == null)){
			return false;
		}

		if((p.right == null && q.right != null) || (p.right != null && q.right == null)){
			return false;
		}

		return isSame(p.left,q.left) && isSame(p.right,q.right); 

	} 
}
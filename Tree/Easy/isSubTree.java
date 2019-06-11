import java.util.*;

public class isSubTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	public boolean isSubtree(TreeNode s, TreeNode t, boolean found){

		if(s == null) return false;
		if(isSame(s, t)) return true;

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public boolean isSame(TreeNode s, TreeNode t){

		if(s == null && t == null){
			return true;
		}

		if(s == null || t == null){
			return false;
		}

		if(s.val != t.val) return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
	
}
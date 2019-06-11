import java.util.*;

public class HasPath{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public boolean Find(TreeNode root, int sum){

		if(root == null || sum < 0){
			return false;
		}

		if(sum == root.val){
			return true;
		}

		if(root.left != null)
			boolean left = Find(root.left, sum - root.left.val);

		if(left)
			return true;

		if(root.right != null){
			boolean right = Find(root.right, sum - root.right.val);
		}

		return right;
	}


}
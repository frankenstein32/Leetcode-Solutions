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

		if(sum == 0){
			return true;
		}


		return Find(root.left, sum - root.val) || Find(root.right, sum - root.val);
	}


}
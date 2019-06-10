import java.util.*;

public class MinDepth{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public int height(TreeNode root){

		if(root == null){
			return Integer.MAX_VALUE;
		}

		return Math.min(height(root.left), height(root.right)) + 1;
	}


}
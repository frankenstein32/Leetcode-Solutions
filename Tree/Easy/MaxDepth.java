import java.util.*;

public class MaxDepth{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public int height(TreeNode root){

		if(root == null){
			return 0;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}


}
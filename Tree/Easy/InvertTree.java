import java.util.*;

public class InvertTree{
		
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

		int lh = height(root.left);
		int rh = height(root.right);

		if(lh == Integer.MAX_VALUE && rh == Integer.MAX_VALUE){

			return 1;
		}else {

			return Math.min(lh, rh) + 1;
		}
	}


}
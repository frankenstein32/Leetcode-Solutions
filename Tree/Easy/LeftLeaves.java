import java.util.*;

public class LeftLeaves{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public int SumLeaves(TreeNode root){

		if(root == null){
			return 0;
		}

		int ans = 0;

		if(root.left != null){

			if(root.left.left == null && root.left.right == null)
				ans += root.left.val;
			else
				ans += SumLeaves(root.left);
		}

		return SumLeaves(root.right) + ans	;

		
	}


}
import java.util.*;

public class getMinDiff{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	TreeNode prev = null;
	int minDiff = Integer.MAX_VALUE;

	public void getDiff(TreNode root){

		if(root == null){
			return;
		}

		getDiff(root.left);

		if(prev != null){
			minDiff = Math.min(minDiff, root.val - prev);
		}

		prev = root;
		getDiff(root.right);
	}

	
}
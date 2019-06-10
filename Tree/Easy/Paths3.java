import java.util.*;

public class Paths3{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public List<String> paths(TreeNode root){

		List<String> res = new ArrayList<>();

		if(root != null)
		helper(root,res, "");
		return res;
	}

	public void helper(TreeNode root, List<String> res, String sb){

		if(root.left == null && root.right == null) res.add(sb + root.val);

		if(root.left != null) helper(root.left, res, sb + root.val + "->");
		if(root.right != null) helper(root.right, res, sb + root.val + "->");


	}


}
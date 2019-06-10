import java.util.*;

public class RootToLeafPaths{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public List<String> paths(TreeNode root){

		List<String> res = new ArrayList<>();

		helper(root,res, new StringBuilder());
		return res;
	}

	public void helper(TreeNode root, List<String> res, StringBuilder sb){

		if(root.left == null && root.right == null){	

			res.add(sb.toString());
			return;
		}



		sb.append(root.val);
		sb.append("->");

		if(root.right != null)
			helper(root.left, res,sb);

		if(root.left != null)
		helper(root.right, res, sb);

		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
	}


}
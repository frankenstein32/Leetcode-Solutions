import java.util.*;

public class constructString{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
		
	public String tree2str(TreeNode t){

		if(t == null)
			return "";
		
		if(t.left == null && t.right == null){

			return t.val + "";
		}

		if(t.right == null){
			return "("+tree2str(t.left)+")";
		}

		return "("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
		
	}
	
}
import java.util.*;

public class isBalanced{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	public int height(TreeNode root){

		if(root == null){
			return -1;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	public boolean isBalanced(TreeNode root){

		heapmover mover = new heapmover();
		return helper(root).balanced;
	}

	class heapmover{

		int height = -1;
		boolean balanced = true;
	}

	public heapmover helper( TreeNode root){

		if(root == null){
			return new heapmover();
		}


		heapmover moverL = helper(root.left);
		heapmover moverR = helper(root.right);

		heapmover self = new heapmover();
		int lh = moverL.height;
		int rh = moverR.height;

		self.height = Math.max(lh.height,rh.height) + 1;

		if(Math.abs(lh - rh) > 1){
			self.balanced =  false;
		}

		return helper(root.left) && helper(root.right);
	} 


}
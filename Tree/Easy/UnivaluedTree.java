import java.util.*;

public class UnivaluedTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

  public boolean isUnivariant(TreeNode root){

    if(root == null){
      return true;
    }

    if(root.left != null && root.left.val != root.val){
      return false;
    }

    if(root.right != null && root.right.val != root.val){
      return false;
    }
    
    return isUnivariant(root.left) && isUnivariant(root.right);
  }
}
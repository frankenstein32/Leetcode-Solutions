import java.util.*;

public class cousinsTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

  TreeNode xParent, yParent;
  int xDepth, yDepth;

  public boolean isCousins(TreeNode root, int x, int y){

    getDepthAndParent(root,null,x,y,0);
    return (xDepth == yDepth && xParent != yParent);
  }

  public void getDepthAndParent(TreeNode root, TreeNode parent, int x, int y, int depth){

    if(root == null){
      return;
    }

    if(root.val == x){

      xParent = parent;
      xDepth = depth;
    }else if(root.val == y){

      yParent = parent;
      yDepth = depth;
    }

    getDepthAndParent(root.left, root, x, y, depth + 1);
    getDepthAndParent(root.right, root, x, y, depth + 1);
  }
}
import java.util.*;

public class SumTorootLeaf{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

  public int sumRootToLeaf(TreeNode root){

        if(root == null){
            return 0;
        }

        return dfs(root, 0);
  }

  public int dfs(TreeNode root, int val){

    if(root == null){
        return 0;
    }

    val = 2 * val + root.val;

    return (root.left == root.right  ? val : dfs(root.left,val) + dfs(root.right, val));
  }
}
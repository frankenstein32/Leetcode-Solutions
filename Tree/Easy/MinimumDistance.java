import java.util.*;

public class MinimumDistance{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public void minDiffBST(TreeNode root){

        if(root == null){
            return;
        }

        minDiffBST(root.left);

        if(prev != null){

            min = Math.min(min, root.val - prev.val);
        }

        prev = root;



        minDiffBST(root.right);
    }
	
}
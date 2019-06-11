import java.util.*;

public class IncreasingOrderSearch{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

    TreeNode curr;

    public TreeNode increasingBST(TreeNode root){

        TreeNode ans = new TreeNode(0);
        curr = ans;
        Inorder(root);
        return ans.right;
    }

    public void Inorder(TreeNode root){

        if(root == null){
            return;
        }

        Inorder(root.left);

        root.left = null;
        curr.right = root;
        curr = root;

        Inorder(root.right);
    }
	
}
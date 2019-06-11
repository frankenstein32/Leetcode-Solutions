import java.util.*;

public class FindSecondMin{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
		
	public int secondMin(TreeNode root){

        if(root == null){
            return -1;
        }

        if(root.left == null && root.right == null){
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if(root.val == root.left.val){
            left = secondMin(root.left);
        }

        if(root.val == root.right.val){
            right = secondMin(root.right);
        }

        if(left != -1 && right != -1){
            return Math.min(left, right);
        }else if(left != -1){
            return left;
        }else{
            return right;
        }
    }
	
}
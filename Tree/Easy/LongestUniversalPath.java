import java.util.*;

public class LongestUniversalPath{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

    int ans = 0;
		
	public int longestPath(TreeNode root){

        if(root == null){
            return 0;
        }

        int lmax = longestPath(root.left);
        int rmax = longestPath(root.right);

        int tempLeft = 0;
        int tempRight = 0;
        if(root.left != null && root.left.val == root.val){

            tempLeft += lmax + 1;
        }

        if(root.right != null && root.right.val == root.val){

            tempRight += rmax + 1;
        }

        ans = Math.max(ans, tempRight + tempLeft);

        return Math.max(lmax, rmax);
    }
	
}
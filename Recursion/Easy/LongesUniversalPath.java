import java.util.*;

public class LongesUniversalPath{
	
	private class TreeNode{


		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){
			val = x;
		}
	}

	int ans = 0;
	public int longestUnivaluePath(TreeNode root) {
        
        return helper(root);
    }

    public int helper(TreeNode node){

    	if(node == null){
    		return 0;
    	}


    	int leftCount = helper(node.left);
    	int rightCount = helper(node.right);

    	int tempLeft = 0;
    	int tempRight = 0;
    	if(node.left != null && node.val == node.left.val){

    		tempLeft += leftCount + 1;
    	}else if(node.right != null && node.val == node.right.val){
    		tempRight += rightCount + 1;
    	}	


    	ans = Math.max(ans, tempLeft + tempRight);
    	
    	return Math.max(leftCount, rightCount);
    }

}
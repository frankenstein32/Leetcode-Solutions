import java.util.*;

public class MaximumPathSum{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root){

		helper(root);
		return max;

	}

	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}

		int LSum = helper(root.left);
		int RSum = helper(root.right);
		int selfSum = LSum + RSum + root.val;

		max = Math.max(selfSum, max);

		return Math.max(LSum, RSum) + root.val;
	}


}
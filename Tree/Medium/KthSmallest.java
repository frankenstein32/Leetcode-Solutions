import java.util.*;

public class KthSmallest{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	int total = 0;

	public int sumNumbers(TreeNode root){

		 helper(root, 0);
		 return total;
	}


	public void helper(TreeNode root, int val){

		if(root == null){
			return ;
		}

		val += root.val;

		if(root.left == null && root.right == null){

			total += val;
			return;
		}

		if(root.left != null){
			helper(root.left, val * 10);
		}

		if(root.right != null)
			helper(root.right, val * 10); 

	}

}
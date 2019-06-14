import java.util.*;

public class BinaryTreeCamera{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public int minCameraCover(TreeNode root){

		return helper(root);
	}

	public int helper(TreeNode root){


		if(root == null){
			return 0;
		}

		if(root.left == null && root.right == null){
			return 1;
		}

		int inc = 1;

		if(root.left != null){

			inc += helper(root.left.left);
			inc += helper(root.left.right);
		}

		if(root.right != null){
			
			inc += helper(root.right.left);
			inc += helper(root.right.right);
		}

		int exc = 0;
		exc += helper(root.left, cameraLeft);
		exc += helper(root.right, cameraLeft);

		return Math.min(inc, exc);


	}


}
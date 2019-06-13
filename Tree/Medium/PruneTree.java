import java.util.*;

public class ConstFromPrePost{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public boolean prune(TreeNode root){

		if(root == null){
			return false;
		}


		boolean isLeft = prune(root.left);
		boolean isRight = prune(root.right);

		if(!isLeft){

			root.left = null;
		}

		if(!isRight){
			root.right = null;
		}

		return isLeft || isRight || root.val == 1;
	}

	
}
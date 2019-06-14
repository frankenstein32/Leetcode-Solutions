import java.util.*;

public class RecoverBT{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	TreeNode fidx;
	TreeNode sidx;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root){

		if(root == null){
			return;
		}	

		inorder(root);

		int temp = fidx.val;
		fidx.val = sidx.val;
		sidx.val = temp;

	}

	public void inorder(TreeNode root){

		if(root == null){
			return;
		}

		inorder(root.left);
		if(fidx == null && prev.val > root.val){
			fidx = prev;
		}

		if(fidx != null && prev.val > root.val){
			sidx = root;
		}

		prev = root;

		inorder(root.right);
	}




}
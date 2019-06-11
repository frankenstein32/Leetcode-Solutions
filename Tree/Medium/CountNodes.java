import java.util.*;

public class CountNodes{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	TreeNode ans = null;

	public boolean lcaH(TreeNode root, TreeNode A, TreeNode B){

		if(root == null){
			return root;
		}

		int left = (lcaH(root.left, A, B) ? 1 : 0);
		int right = (lcaH(root.right, A, B) ? 1 : 0);
		int self = (A.val == root.val || B.val == root.val) ? 1 : 0;

		if(left + self + right >= 2){
			ans = root;
		}

		return (left + self + right) > 0;


	}

}
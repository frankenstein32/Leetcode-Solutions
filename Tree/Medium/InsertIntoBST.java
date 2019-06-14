import java.util.*;

public class InsertIntoBST{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode insertInto(TreeNode Parent, TreeNode root,int val){

		if(root == null){

			TreeNode nn = new TreeNode(val);
			if(parent.val < val){
				parent.right = nn;
			}else{
				parent.left = nn;
			}
			return nn;
		}

		if(root.val > val){

			root.left = insertInto(root, root.left, val);
		}else if(root.val < val){
			root.right = insertInto(root, root.right, val);
		}

		return root;
	}
	
}
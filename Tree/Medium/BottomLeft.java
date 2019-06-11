import java.util.*;

public class BottomLeft{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode max(TreeNode node){

		if(node.right != null){
			return max(node.right);
		}

		return node.val;
	}

	public void delete(TreeNode root, int key){

		if(root == null){
			return ;
		}

		if(root.val < key){
			root.left = delete(root.right, key);
		}else if(root.val > key){
			root.right = delete(root.left, key);
		}else{

			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				returnn root.left;
			}

			
			TreeNode temp = max(root.left);
			root.val = temp.val;
			root.left = delete(root.left, root.val);
			

		}

		return root;
	}

}
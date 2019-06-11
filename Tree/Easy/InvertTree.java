import java.util.*;

public class InvertTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public TreeNode mirror(TreeNode root){

			
		if(root == null){
			return null;
		}

		TreeNode left = mirror(root.left);
		TreeNode right = mirror(root.right);

		node.left = right;
		node.right = left;

		return node;
	}

	public TreeNode mirrotItr(TreeNode root){

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()){

			TreeNode rp = q.poll();

			TreeNode left = rp.left;
			rp.left = rp.right;
			rp.right = left;

			if(rp.left != null){
				q.add(rp.left);
			}

			if(rp.right != null){
				q.add(rp.right);
			}
		}

		return root;
	}

}
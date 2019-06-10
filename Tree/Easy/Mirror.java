import java.util.*;

public class Mirror{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	public boolean isSymmetric(TreeNode root){

		return isMirror(root, root);
	}

	public boolean isMirror(TreeNode root1, TreeNode root2){

		if(root1 == null && root2 == null){
			return true;
		}

		if(root1 == null || root2 == null){
			return false;
		}

		if(root1.val != root2.val){
			return false;
		}

		return isMirror(root1.left, root2.right) 
				&& isMirror(root1.right, root2.left);
	}

	public boolean isMirrorItr(TreeNode root){

		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		q.add(root);

		while(!q.isEmpty()){

			TreeNode q1 = q.poll();
			TreeNode q2 = q.poll();

			if(q1 == null && q2 == null){
				return true;
			}

			if(q1 == null || q2 == null){
				return false;
			}

			q.add(q1.left);
			q.add(q2.right);
			q.add(q1.left);
			q.add(q2.right);

		}

		return true;
	}


}
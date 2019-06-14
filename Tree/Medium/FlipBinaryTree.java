import java.util.*;

public class FlipBinaryTree{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	int i = 0;
	List<Integer> ans = new ArrayList<>();	

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage){

		return (dfs(root,voyage) ? ans : Arrays.asList(-1));
	}

	public boolean dfs(TreeNode root, int[] voyage){

		if(root == null) return true; 
		if( root.val != voyage[i]) return false;

		if(root.left != null && root.left != root.val){

			ans.add(root.left.val);

			return dfs(root.right, voyage) && dfs(root.left, voyage);
		}

		return dfs(root.left, voyage) && dfs(root.right, voyage);
	}
}
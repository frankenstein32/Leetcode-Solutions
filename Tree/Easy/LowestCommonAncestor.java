import java.util.*;

public class LowestCommonAncestor{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public int find(TreeNode root){

		if(root == null){
			return -1;
		}

		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		
		return res.get(i - 1);	
	}

	public void dfs(TreeNode root, List<Integer> res){

		if(root == null) return null;

		dfs(root.left);
		res.add(root.val);
		dfs(root.right);
	}

}
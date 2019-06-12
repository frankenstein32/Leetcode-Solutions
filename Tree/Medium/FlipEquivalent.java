import java.util.*;

public class FlipEquivalent{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2){

		if(root1 == root2){
			return true;
		}

		if(root1 == null || root2 == null || root1.val != root2.val){
			return false;
		}

		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
				|| (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2){

		List<Integer> ans1 = new ArrayList<>();
		List<Integer> ans2 = new ArrayList<>();

		dfs(root1,ans1);
		dfs(root2,ans2);

		return ans1.equals(ans2);
	}

	public void dfs(TreeNode root, List<Integer> ans){

		if(root != null){
			ans.add(root.val);
		}

		int L = (root.left == null ? -1 : root.left.val);
		int R = (root.right == null ? -1 : root.right.val);

		if(L < R){
			dfs(root.left, ans);
			dfs(root.right, ans);
		}else{

			dfs(root.right, ans);
			dfs(root.left, ans);
		}
	}
	
}
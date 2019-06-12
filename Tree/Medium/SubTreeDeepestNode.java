import java.util.*;

public class SubTreeDeepestNode{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	List<Integer> ans;
	int Target;
	int K;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K){

		this.ans = new ArrayList<>();
		this.Target = target;
		this.K = K;

		dfs(root);
		return ans;
	}


	public int dfs(TreeNode root){

		if(root.val == null){

			return -1;
		}

		if(root.val == Target){
			subTree(root, 0);
			return;
		}

		int L = dfs(root.left);
		int R = dfs(root.right);

		if(L != -1){

			if(L == K) ans.add(root.val);
			
			subTree(root.right, L + 1);
			return L + 1;


		}else if(R != -1){

			if(R == K) ans.add(root.val);
			subTree(root.left, R + 1);
			return R + 1;
		}else{
			return -1;
		}
	}

	public void subTree(TreeNode root, int depth){

		if(root == null){
			return;
		}

		if(depth == K){
			ans.add(root.val);
			return;
		}

		subTree(root.left, depth + 1);
		subTree(root.right, depth + 1);

	}
	
}
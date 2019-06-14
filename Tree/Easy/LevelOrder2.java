import java.util.*;

public class LevelOrder2{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public List<List<Integer>> levelOrderBottomUp(TreeNode root){

		Queue<TreeNode> q = new LinkedList<>();

		List<List<Integer>> ans = new ArrayList<>();
		q.add(root);

		while(!q.isEmpty()){

			int levelSize = q.size();
			List<Integer> level = new ArrayList<>();

			for(int i = 0;i < levelSize;i++){

				if(q.peek().left != null) q.add(q.peek().left);
				if(q.peek().right != null) q.add(q.peek().right);

				level.add(q.poll().val);
			}

			ans.add(0,level);
		}

		return ans;
	}

	public List<List<Integer>> levelorderDFS(TreeNode root){

		List<List<Integer>> ans = new ArrayList<>();

		DFS(ans, root, 0);
		return ans;

	}

	public void DFS(List<List<Integer>> ans, TreeNode root, int level){

		if(root == null){
			return;
		}

		if(level >= ans.size()){
			ans.add(0,new ArrayList<>());
		}

		DFS(ans,root.left,level + 1);
		DFS(ans, root.right,level + 1);

		list.get(list.size() - level - 1).add(root.val);	

	}




}
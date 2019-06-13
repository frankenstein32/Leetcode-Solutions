import java.util.*;

public class FindSubTreeSum{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	HashMap<Integer, Integer> count = new HashMap<>();
	int maxCount = 0;

	public int[] findFrequentTreeSum(TreeNode root){

		dfs(root);

		List<Integer> res = new ArrayList<>();
		for(int s : count.keySet()){

			if(count.get(s) == maxCount){
				res.add(s);
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

	public void dfs(TreeNode root){

		if(root == null)
			return;

		int sum = dfs(root.left) + dfs(root.right) + root.val;
		count.put(sum, count.getOrDefault(sum, 0) + 1);

		maxCount = Math.max(maxCount, count.get(sum));
		return sum;
	}

}
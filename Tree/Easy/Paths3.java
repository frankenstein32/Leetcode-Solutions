import java.util.*;

public class Paths3{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public int path(TreeNode root, int sum){



		return pathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}


	public int pathSum1(TreeNode root, int sum){

		if(root == null){
			return 0;
		}

		int leftSum = pathSum1(root.left,sum - root.val);
		int rightSum = pathSum1(root.right, sum - root.val);

		return (root.val == sum ? 1 : 0) + leftSum + rightSum;
	}


	public int pathum(TreeNode root, int sum){

		if(root == null)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		return backtrack(root, 0, sum, map);
	}

	public int backtrack(TreeNode root, int sum, int target, HashMap<Integer, Integer> map){


		if(root == null){
			return 0;
		}

		sum += root.val;

		int res = map.getOrDefault(sum - target, 0);
		map.put(sum,map.getOrDefault(sum, 0) + 1);

		res += backtrack(root.left, sum, target, map) + backtrack(root.right. sum, target, map);
		map.put(sum, map.get(sum) - 1);

		return res;
	}




}
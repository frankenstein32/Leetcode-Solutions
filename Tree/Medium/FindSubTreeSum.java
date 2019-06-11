import java.util.*;

public class FindSubTreeSum{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public int rob(TreeNode root){

		 if(root == null){
			return 0;
		}

		int val = 0;

		if(root.left != null){

			val += rob(root.left.left)+ rob(root.left.right);
		}

		if(root.right != null){

			val += rob(root.right.left) + rob(root.right.right);
		}

		return Math.max(val + root.val, rob(root.left) + rob(root.right));
	}	
`
	public int robTD(TreeNode root, HashMap<TreeNode , Integer> map){

		 if(root == null){
			return 0;
		}

		if(map.containsKey(root)){
			return map.get(root);
		}

		int val = 0;

		if(root.left != null){

			val += robTD(root.left.left, map)+ robTD(root.left.right, map);
		}

		if(root.right != null){

			val += robTD(root.right.left, map) + robTD(root.right.right, map);
		}

		return Math.max(val + root.val, robTD(root.left, map) + robTD(root.right, map));
	}	

	public int robTD2(TreeNode root){

		if(root == null)
			return;

		int[] left = robTD2(root.left);
		int[] right = robTD2(root.right);
		int[] res = new int[2];

		res[0] = Math.max(left[0], left[1]) + Math.max(right[0] + right[1]);
		res[1] = root.val + left[0] + right[0];


		return res;
	}

}
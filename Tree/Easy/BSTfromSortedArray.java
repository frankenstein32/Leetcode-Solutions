import java.util.*;

public class BSTfromSortedArray{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
	
	public TreeNode construct(int[] nums){

		return helper(nums,0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int i, int j){

		if(i > j){
			return null;
		}

		int mid = (i + j) / 2;
		TreeNode nn = new TreeNode(nums[mid]);

		nn.left =  helper(nums, i, mid - 1);
		nn.right = helper(nums, mid + 1, j);

		return nn;
	}



}
import java.util.*;

public class ConstMaxBT{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public TreeNode constructMaximumBinaryTree(int[] nums){

		return construct(nums, 0, nums.length - 1);
	}

	public TreeNode construct(int[] nums, int nlo, int nhi){

		if(nlo > nhi){
			return null;
		}

		int idx = -1;
		int max = Integer.MIN_VALUE;
		for(int i = nlo;i <= nhi;i++){

			if(nums[i] > max){
				max = nums[i];
				idx = i;
			}
		}

		TreeNode nn = new TreeNode(nums[idx]);

		nn.left = construct(nums, nlo, idx - 1);
		nn.right = construct(nums, idx + 1, nhi);

		return nn;
	}
}
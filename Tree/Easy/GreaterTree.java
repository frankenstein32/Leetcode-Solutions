import java.util.*;

public class GreaterTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	class HeapMover{

		int sum = 0;
	}

	public TreeNode convertBST(TreeNode root){

		HeapMover mover = new HeapMover();
		convert(root,mover);
		return root;
	}
	
	public void convert(TreeNode root, HeapMover mover){


		if(root == null){
			return root;
		}

		convert(root.right, mover);

		int temp = root.val;
		sum += temp;
		root.val = sum;

		convert(root.left, mover);


	}

}
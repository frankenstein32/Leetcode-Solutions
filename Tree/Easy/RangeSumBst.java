import java.util.*;

public class RangeSumBst{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

  public int rangeSum(TreeNode root, int L, int R){

    if(root == null){
      return 0;
    }

    if(root.val < L){
      return rangeSum(root.right, L, R);
    }else if(root.val > R){

      return rangeSum(root.left, L, R);
    }else{

        int lsum = rangeSum(root.left, L, R);
        int rsum = rangeSum(root.right, L, R);

        return lsum + rsum + root.val;

    }
  }
}
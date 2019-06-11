import java.util.*;

public class SeachBST{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

    int ans = 0;
		
	public TreeNode search(TreeNode root, int item){

        if(root == null){
            return null;
        }

        if(item == root.val){
            return root;
        }else if(item > root.val){
            return search(root.right, item);
        }else{
            return search(root.left, item);
        }
    }
	
}
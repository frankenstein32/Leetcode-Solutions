import java.util.*;

public class LeafSimilar{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

    public boolean isSimilar(TreeNode root1, TreeNode root2){

        ArrayList<Integer> seq1 = new ArrayList<>();
        ArrayList<Integer> seq2 = new ArrayList<>();
        dfs(root1, seq1);
        dfs(root2, seq2);

        return seq1.equals(seq2);

    }

    public void dfs(TreeNode root, ArrayList<Integer> seq){

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            seq.add(root);
        }

        dfs(root.left,seq);
        dfs(root.right, seq);
    }
	
}
import java.util.*;

public class MaxDepthGT{
		
	class Node{

		int val;
		List<Node> _children;

		public Node(){}
		public Node(int x){ this.val = x;}
	}
	
	public int MaxDepth(TreeNode root){

		if(root == null){
			return 0;
		}

		int max = 0;
		for(Node child : root.children){

			max = Math.max(max, MaxDepth(child));
		}

		return max + 1;
	}


}
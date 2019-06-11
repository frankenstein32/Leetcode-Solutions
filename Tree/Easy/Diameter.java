import java.util.*;

public class Diameter{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	class HeapMover{

		int ht = -1;
		int dia = 0;
	}

	

	public int diameter(TreeNode root){

		if(root == null){
			return 0;
		}

		int ld = diameter(root.left);
		int rd = diameter(root.right);

		int sd = ht(root.left) + ht(root.right) + 2;

		return Math.max(sp, Math.max(ld, rd));
	}

	public int ht(TreeNode root){

		if(root == null){
			return -1;
		}

		return Math.max(ht(root.left), ht(root.right)) + 1;
	}

	public HeapMover diameterOfBinaryTree(TreeNode root){


		if(root == null){
			return new HeapMover();
		}


		HeapMover ldp = diameterOfBinaryTree(root.left);
		HeapMover rdp = diameterOfBinaryTree(root.right);

		HeapMover sdp = new HeapMover();
		int sh = Math.max(ldp.ht, rdp.ht) + 1;

		int sp = ldp.ht + rdp.ht + 2;
		sdp.ht = sh;
		sdp.dia = Math.max(sp, Math.max(ldp.dia, rdp.dia));

		return sdp;


	}

	
}
import java.util.*;

public class TiltTree{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	class HeapMover{
		int sum = 0;
		int tilt = 0;
	}

	public int findTilt(TreeNode root){

		HeapMover hm = new HeapMover();

		return findTilt(root, hm).tilt;
	}

	public HeapMover findTilt(TreeNode root, HeapMover mover){


		if(root == null){
			return new HeapMover();
		}

		HeapMover lp = findTilt(root.left, mover);
		HeapMover rp = findTilt(root.right, mover);

		HeapMover sp = new HeapMover();
		sp.sum = lp.sum + rp.sum + root.val;
		sp.tilt = Math.abs(lp.sum - rp.sum) + lp.tilt + rp.tilt;

		return sp;
	}

	
}
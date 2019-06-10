import java.util.*;

public class TwoSum4{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
		
	public List<Double> average(TreeNode root){

	  List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
	}
	
}
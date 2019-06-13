import java.util.*;

public class SmallestStringForm{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	String ans = "~";

	public void dfs(TreeNode root, StringBuilder sb){

		if(root == null){
			return;
		}

		sb.append((char)('a') + root.val);

		if(root.left == null && root.right == null){

			sb.reverse();
			String s = sb.toString();
			sb.reverse();

			if(s.compareTo(ans) < 0){

				ans = s;
			}
		}

		dfs(root.left, sb);
		dfs(root.right, sb);
		sb.deleteCharAt(sb.length() - 1);



		return Math.min(Left_sum, Right_sum) + root.val;    
	}
	
}
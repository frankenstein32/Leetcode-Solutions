import java.util.*;

public class PreorderBT{


	public static void main(String[] args){


	}

	static class TreeNode{


		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	static class Pair{

		boolean ld = false;
		boolean sd = false;
		boolean rd = false;

		TreeNode node;
	}

	public static List<Integer> preorder(TreeNode root){


		Stack<Integer> st = new Stack<>();
		List<Integer> ans = new ArrayList<>();

		Pair np = new Pair(root.val);
		st.push(np);
		

		while(!st.isEmpty()){

			Pair rp = stack.peek();

			if(!rp.sd){
				ans.add(rp.node.val);
				rp.sd = true;
			}else if(!rp.rd){

				Pair lp = new Pair(rp.right.val);

				if(lp.node != null){
					st.push(lp);
				}

				rp.rd = true;
			}else if(!rp.ld){

				Pair lp = new Pair(rp.left.val);

				if(lp.node != null){
					st.push(lp);
				}

				rp.ld = true;
			}
		}
	}

	

}
import java.util.*;

public class FullBinaryTree{


	public static void main(String[] args){


		int n = 1;
		int k = 1;

		System.out.println(allpossibleBT(n,k));

	}

	private class TreeNode{

		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ this.val = x;}
	}

	public List<TreeNode> allpossibleBT(int N){

		List<TreeNode> res = new ArrayList<>();

		if(N == 1){
			res.add(new TreeNode(0));
			return res;
		}

		N = N - 1;

		for(int i = 1;i < N; i+= 2){

			List<TreeNode> left = allpossibleBT(N);
			List<TreeNode> right = allpossibleBT(N - 1);

			for(TreeNode nl : left){
				for(TreeNode nr : right){

					TreeNode cr = new TreeNode(0);
					cur.left = nl;
					cr.right = nr;
					res.add(cur);
				}
			}
		}

		return res;
	}

	
}
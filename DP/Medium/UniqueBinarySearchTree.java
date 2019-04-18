import java.util.*;

public class UniqueBinarySearchTree{

	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

	public static void main(String[] args){

		int n = 4;
		System.out.println(tree(n));
		
	}

	public static List<TreeNode> count(int n){

		
		return helper(0, arr.length - 1);
	}

	public static List<TreeNode> helper(int si, int ei){

		List<TreeNode> list = new LinkedList<>();
		if(si > ei){
			list.add(null);
			return list;
		}

		if(si == ei ){

			list.add(new TreeNode(si));
			return list;
		}

		
		int ans = 0;
		for(int i = si;i <= ei;i++){

			List<TreeNode> leftTreeNode = helper(si, i - 1);
			List<TreeNode> rightTreeNode = helper(i + 1, ei);
		

			for(TreeNode lnode : leftTreeNode){
				for(TreeNode rnode : rightTreeNode){

					TreeNode node = new TreeNode(i);
					node.left = lnode;
					node.right = rnode;
					list.add(node);
				}
			}
		}

		return list;
    }

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

	
}
import java.util.*;

public class getMinDiff{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}

	public int[] find(TreeNode root){


		if(root == null){
			return new int[0];
		}

		List<Integer> res = new ArrayList<>();
		ListFill(root, res);

		int[] arr = new int[res.size()];

		for(int i = 0;i < arr.length;i++){

			arr[i] = res.get(i);
		}

		return arr;
	}

	TreeNode prev = null;
	int count = 0;
	int max = 0;

	public void ListFill(TreeNode root, List<Integer> res){


		if(root == null){
			return;
		}

		ListFill(root.left, res);

		if(prev != null){

			if(prev.val == root.val){
				count++;
			}else{
				count = 1;
			}
		}

		if(count > max){

			max = count;
			res.clear();
			res.add(root.val);
		}else if(count == max){
			list.add(root.val);
		}

		prev = root;
		ListFill(root.right, res);

	}

	
}
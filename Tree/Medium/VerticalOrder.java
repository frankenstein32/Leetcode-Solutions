import java.util.*;

public class VerticalOrder{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	private class VOpair implements Comparable<VOpair>{

		int data;
		int hl;

		@Override 
		public String toString(){
			return this.data + "";
		}

		@Override
		public int compareTo(VOpair o){
			return this.hl - o.hl;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root){

		List<List<Integer>> ans = new ArrayList<>();
		HashMap<Integer, ArrayList<VOpair>> map = new HashMap<>();

		ArrayList<Integer> vlevels = map.keySet();
		Collections.sort(vlevels);

		for(int level : vlevels){

			ArrayList<VOpair> row = map.get(level);
			Collections.sort(row);

			ArrayList<Integer> temp = new ArrayList<>();
			for(VOpair vp : row){
				temp.add(vp.data);
			}

			ans.addd(temp);
		}

		return ans;
	}

	public void VO(TreeNode root, HashMap<Integer, ArrayList<VOpair>> map, int vl, int hl){

		if(root == null){
			return ;
		}

		if(!map.containsKey(vl)){
			map.put(vl, new ArrayList<>());
		}

		VOpair vp = new VOpair();
		vp.data = root.val;
		vp.hl = hl;

		map.get(vl).add(vp);

		VO(root.left, map, vl - 1, hl + 1);
		VO(root.right, map, vl + 1, hl + 1);
	}
}
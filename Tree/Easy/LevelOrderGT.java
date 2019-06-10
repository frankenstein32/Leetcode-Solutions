import java.util.*;

public class LevelOrderGT{
		
	class Node{

		int val;
		List<Node> _children;

		public Node(){}
		public Node(int x){ this.val = x;}
	}
	
	public List<List<Integer>> levelOrder(Node root){

		   Queue<Node> q = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();

		if(root == null){
			return res;	
		}


		Queue<Node> helper = new LinkedList<>();
		List<Integer> level = new ArrayList<>();
		q.add(root);

		while(!q.isEmpty()){

			Node rp = q.remove();
			level.add(rp.val);

			for(int i = 0;i < rp.children.size();i++){
				helper.add(rp.children.get(i));
			}

			if(q.isEmpty()){

				res.add(level);
				level = new ArrayList<>();
				q = helper;
				helper = new LinkedList<>();
			}
		}

		return res;
	}




}
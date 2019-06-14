import java.util.*;

public class PopulateNextRightPointer{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public Node connect(Node root){

		if(root == null)
			return root;

		Queue<Node> q = new LinkedList<>();
		Queue<Node> helper = new LinkedList<>();
		Node save = null;
		q.add(root);

		while(!q.isEmpty()){

			Node rp = q.poll();
			save = rp;
			if(q.isEmpty()){
				rp.next = null;
			}else{
				rp.next = q.peek();
			}

			if(rp.left != null)
				helper.add(rp.left);
			if(rp.right != null)
				helper.add(rp.right);

			if(q.isEmpty()){
				System.out.println(save.val);
				q = helper;
				helper = new LinkedList<>();
			}
		}


		return root;
	}					

}
import java.util.*;

public class HouseRobber3{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	public int count(Treenode root){

		if(root == null){
			return 0;
		}

		return count(root.left) + count(root.right) + 1;
	}

}
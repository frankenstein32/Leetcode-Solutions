import java.util.*;

public class fold{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	static class mover{
		ListNode prev;
	}

	public static void helper(ListNode curr,mover m){

		if(curr == null){
			return;
		}


		helper(curr.next,m);

		if(mover.prev == curr || mover.prev.next == curr){
			return;
		}

		Node save = mover.prev.next;
		mover.prev.next = curr;
		curr.next = save;

		mover.prev = save;
	}
	
}
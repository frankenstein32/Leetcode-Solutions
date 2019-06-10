import java.util.*;

public class DeleteSpecificNode{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static void delete(ListNode node, int item){


		if(node == null || this.head == null){
			return ;
		}

		ListNode prev = head;
		ListNode curr = prev.next;

		while(curr != null){

			if(curr.val == item){
				prev.next = curr.next;
				break;
			}

			prev = curr;
			curr = curr.next;
		}
	}
}
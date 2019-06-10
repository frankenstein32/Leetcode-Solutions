import java.util.*;

public class RemoveNthFromLast{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode Find(ListNode head, int n){


		ListNode slow = head;
		ListNode fast = head;

	for(int i = 0;i < n - 1 && fast != null;i++){

		fast = fast.next;
	}

	while(fast != null){

		fast = fast.next;
		slow = slow.next;

	}

	slow.next = slow.next;

	return head;

	}
	
}
import java.util.*;

public class Mid{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static int mid(ListNode head){

		if(head.next == null){
			return head.val;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null && fast.next != null){

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	
}
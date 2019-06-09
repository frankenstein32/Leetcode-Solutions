import java.util.*;

public class InsertionSort{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode sort(ListNode head){

		if(head == null || head.next == null){

			return head;
		}

		ListNode fakeHead = new ListNode(0);
		ListNode prev = fakeHead;
		ListNode curr = head;
		ListNode next = null;

		while(curr != null){

			next = curr.next;

			while(prev.next != null && prev.next.val < curr.val){
				prev = prev.next;
			}

			curr.next = prev.next;
			prev.next = curr;
			prev = fakeHead;
			curr = next;
		}

		return fakeHead.next;
	}
	
	
}
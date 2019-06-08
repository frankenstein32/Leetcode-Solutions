import java.util.*;

public class CycleIndex{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode remove(ListNode head){

		if(head == null || head.next == null){
			return head;
		}

		ListNode temp = head;
		ListNode prev = head;
		ListNode curr = prev.next;

		while(curr != null){

			if(prev.val != curr.val){
				prev.next = curr;
				prev = curr;
			}

			curr = curr.next;
		}

		prev.next = curr;

		return temp;
	}

	
}
import java.util.*;

public class ReorderList{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static void reorder(ListNode head){

		if(head == null || head.next == null){
			return null;
		}

		ListNode p1 = head;
		ListNode p2 = head;

		while(p2 != null && p2.next != null){

			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		ListNode preMiddle = p1;
		ListNode preCurrent = p1.next;

		while(preCurrent.next != null){

			ListNode curr = preCurrent.next;
			preCurrent.next = curr.next;
			curr.next = preMiddle.next;
			preMiddle.next = curr;
		}

		p1 = head;
		p2 = preMiddle.next;

		while(p1 != preMiddle){

			preMiddle.next = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1 = p2.next;
			p2 = preMiddle.next;
		}


	}

	
	
}
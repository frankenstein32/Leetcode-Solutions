import java.util.*;

public class OddEvenList{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode oddEvenList(ListNode head){

		if(head == null || head.next == null){
			return head;
		}

		ListNode odd = head, even = head.next,evenHead = even;

		while(even != null && even.next != null){

			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}

		odd.next = evenHead;

		return head;
	}


	
}
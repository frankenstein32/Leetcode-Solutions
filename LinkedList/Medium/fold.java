import java.util.*;

public class fold{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static reverse(ListNode head, int beg, int end){

		ListNode curr = head, prev = null;

		while(beg > 1){

			prev = curr;
			curr = curr.next;

			beg--;
		 	end--;
		}

		ListNode corner = prev, tail = curr;
		ListNode third = null;
		while(n > 0){

			third = curr.next;
			curr.next = prev;
			prev = curr;
			curr = third;
			n--;
		}


		if(corner != null)
			corner.next = prev;
		else
			head = prev;

		tail.next = curr;

		return head;


	}

	
}
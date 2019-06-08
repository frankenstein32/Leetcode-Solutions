import java.util.*;

public class ReverseLL2{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode parition(ListNode head, int x){

		if(head == null || head.next == null){
			return head;
		}

		ListNode shorter = new ListNode(0);
		ListNode longer = new ListNode(0);

		ListNode headS = shorter;
		ListNode headL = longer;

		while(head != null){

			if(head.val < x){

				headS.next = head;
				headS = headS.next;
			}else{

				headL = head;
				headL = headL.next;
			}

			head = head.next;
		}

		if(shorter.next != null && longer.next != null){

			shorted.next = longer.next;
			return shorter;
		}else if(shorted.next == null){
			return longer.next;
		}else{
			return shorter.next;
		}

	}

	
}
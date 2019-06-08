import java.util.*;

public class Rotate{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode SwapPairs(ListNode head){


		if(head == null){
			return head;
		}

		ListNode prev = head;
		ListNode curr = prev.next;

		while(curr != null){

			ListNode next = curr.next;

			int temp = prev.val;
			prev.val = curr.val;
			curr.val = temp;

			prev = next;
			
			if(next != null){
				curr = next.next;
			}else{
				curr = null;
			}
		}

		return head;

	}
	
}
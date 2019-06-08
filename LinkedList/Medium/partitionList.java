import java.util.*;

public class partitionList{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode delete(ListNode head){

		if(head == null || head.next == null){
			return head;
		}

		ListNode Fakehead = new ListNode(0);
		Fakehead.next = head;

		ListNode prev = Fakehead;
		ListNode curr = head;

		while(curr != null){


			while(curr.next != null && curr.val != curr.next.val){
				curr = curr.next;
			}

			if(prev.next == curr){
				prev = prev.next;
			}else{

				prev.next = curr.next;
			}

			curr = curr.next;
		}

		return Fakehead.next;
	}

	
}
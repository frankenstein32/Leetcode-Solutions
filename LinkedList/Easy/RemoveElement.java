import java.util.*;

public class RemoveElement{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode remove(ListNode head int val){

		if(head == null){
			return head;
		}
		
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode prev = temp;
		ListNode curr = head;

		while(curr != null){

			if(curr.val != val){

				prev.next = curr;
				prev = curr;
			}

			curr = curr.next;
		}

		prev.next = curr;


		return temp.next;
	}

	
}
import java.util.*;

public class CycleIndex{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static boolean hasCycle(ListNode head){

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null && fast.next!= null){

			if(slow == fast){
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;

			
		}

		return false;
	}

	
}
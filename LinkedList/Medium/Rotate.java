import java.util.*;

public class Rotate{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode rotateList(ListNode head, int n){

		if(head = null){
			return head;
		}

		ListNode dummy = new Node(0);
		dummy.next = head;

		ListNode fast = dummy;
		ListNode slow = dummy;

		int i 0;
		for(;fast.next != null;i++){

			fast = fast.next;
		}

		for(int j = i - n % i;j > 0;j--){

			slow = slow.next;
		}

		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}


	
}
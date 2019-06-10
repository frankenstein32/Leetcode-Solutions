import java.util.*;

public class ReverseLL{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode ReverseDataIterative(ListNode head){

		ArrayList<Integer> temp = new ArrayList<>();

		Node node = head;

		while(node != null){

			temp.add(node.val);
			node = node.next;
		}

		node = head;
		int j = temp.size() - 1;

		while(node != null){

			node.val = temp.get(j);
			j--
			node = node.next;
		}

		return head;
	}

	public static ListNode ReversePointerIterative(ListNode head){


		if(head == null || head.next == null){
			return head;
		}

		ListNode prev = head;
		ListNode curr = prev.next;

		while(curr != null){

			ListNode next = curr.next;

			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}


	public static ListNode ReversePointers(ListNode prev, ListNode curr){

		if(curr == null){
			return null;
		}

		ListNode head = ReversePointers(curr, curr.next);

		if(curr.next == null){
			head = curr;
		}

		curr.next = prev;

		return head;
	}
}3
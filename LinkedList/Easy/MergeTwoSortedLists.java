import java.util.*;

public class MergeTwoSortedLists{


	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode Merge(ListNode l1, ListNode l2){

		ListNode head = new ListNode(0);
		ListNode temp = head;


		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				ListNode nn = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				ListNode nn = new ListNode(l2.val);
				l2 = l2.next;
			}
				temp.next = nn;
				temp = nn;
		}

		while(l1 != null){

			ListNode nn = new ListNode(l1.val);
			l1 = l1.next;
			temp.next = nn;
			temp = nn;
		}


		while(l2 != null){

			ListNode nn = new ListNode(l2.val);
			l2 = l2.next;
			temp.next = nn;
			temp = nn;
		}

		return head.next;
	}

	
}
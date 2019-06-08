import java.util.*;

public class RemoveNthFromLast{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode getInter(ListNode A, ListNode B, int m, int n){

		ListNode a = A;
		ListNode b = B;

		while(a != b){

			a = (a == null ? B : a.next);
			b = (b == null ? A : b.next);
		}

		return a;

	}
	
}
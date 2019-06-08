import java.util.*;

public class Intersection{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public static ListNode getInter(ListNode A, ListNode B, int m, int n){


		int diff  = n - m;

		ListNode headB = B;
		ListNode headA = A;

		for(int i = 0;i < diff;i++){

			headB = headB.next;
		}

		while(headA != null && headB != null){

			if(headA.next == headB.next){
				
				return headA.next;	
			}

			headA = headA.next;
			headB = headB.next;


		}

		return null;



	}

	public static int size(ListNode node){

		int size = 0;

		while(node != null){

			size++;
			node = node.next;
		}

		return size;
	}

	
}
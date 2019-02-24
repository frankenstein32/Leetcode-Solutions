import java.util.*;

public class LinkedListPalindrome{

	public class ListNode{

		int val;
		ListNode next;

		ListNode(int x){
			this.val = x;
		}
	}
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String ch = "hello";
		System.out.println(Reverse(ch));
		
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static boolean isPalindrome(ListNode head){

		if(head == null || head.next == null){
			return true;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		int length = GetListLen(head);
		int halfLen = length/2;
		boolean isEven = length % 2 == 0;

		head = dummy.next;
		int count = 0;
		while(count < halfLen){

			head = head.next;
			count++;
		}

		ListNode secondStart = isEven ? head : head.next;
		ListNode firstStart = reverse(dummy.next,halfLen);

		int count = 0;
		while(count < halfLen){

			if(firstStart.val != secondStart.val){
				return false;
			}

			count++;
			firstStart = firstStart.next;
			secondStart = secondStart.next;
		}

		return true;
	}

	public static int GetListLen(ListNode head){

		int len = 0;
		while(head != null){

			len++;
			head = head.next;
		}

		return len;
	}
	private static ListNode reverse(ListNode head, int halfLen){

		int len = 0;
		ListNode prev = null;
		while(head != null && len < halfLen){

			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
			len++;
		}

		return prev;
	}
		
}
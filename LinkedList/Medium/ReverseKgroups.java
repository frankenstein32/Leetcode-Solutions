import java.util.*;

public class ReverseKgroups{

	public static void main(String[] args){


	}

	static class ListNode{

		int val;
		ListNode Next;

		public ListNode(int x){ this.val = x; }
	}

	public ListNode Kreverse(ListNode head, int k){


        if(head == null || head.next == null || k < 2){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail =  head, prev = dummy, temp;

        int count = 0;

        while(true){

            count = k;

            while(count > 0 && tail != null){

                tail = tail.next;
                count--;
            }

            if(tail == null)
                break;

            head = prev.next;
            while(prev.next != tail){

                temp = prev.next;
                prev.next = temp.next;

                temp.next = tail.next;
                tail.next = temp;

            }

            tail = head;
            prev = head;

        }

        return dummy;
    }
	
}
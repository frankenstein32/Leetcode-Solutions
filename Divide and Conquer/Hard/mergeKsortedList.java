import java.util.*;

public class mergeKsortedList{


	public static void main(String[] args){


		String str = "123";
		int target = 6;
	}

	static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode mergeKsorted(ListNode[] list){

        if(list == null || list.length == 0){
            return null;
        }

        return mergeKlist(list, 0, list,length - 1);
    }

    public static ListNode mergeKlist(ListNode[] list, int start, int end){


        if(start == end){

            return list[start];
        }

        int mid = (start + end) / 2;


        ListNode fh = mergeKlist(list,start,mid);
        ListNode sh = mergeKlist(list,mid + 1, end);

        return mergeTwoSoredLists(fh, sh);
    }

    public static ListNode mergeTwoSoredLists(ListNode[] fh, ListNode[] sh){

        ListNode temp1 = fh[0];
        ListNode temp2 = sh[0];

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(temp1 != null && temp2 != null){

            if(temp1.val < temp2.val){
                ListNode nn = new ListNode(temp1.val);
                temp.next = nn;
                temp = temp.next;
                temp1 = temp1.next;
            }else{

                ListNode nn = new ListNode(temp2.val);
                temp.next = nn;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
             ListNode nn = new ListNode(temp1.val);
                temp.next = nn;
                temp = temp.next;
                temp1 = temp1.next;
        }

        while(temp2 != null){
             ListNode nn = new ListNode(temp2.val);
                temp.next = nn;
                temp = temp.next;
                temp2 = temp2.next;   
        }

        return head;

    }


}
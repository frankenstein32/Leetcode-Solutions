import java.util.*;

public class NextLargerNodes{


	public static void main(String[] args){

		String preorder = "";


	}

	static class ListNode{

		int val;
		ListNode next;

		ListNode(int x){ x = this.val; }
	}

	public static int[] nextNodes(ListNode node){

		ListNode head = node;
		int size = size(node);

		Stack<int[]> stack = new Stack<>();

		int[] res = new int[size];
		int i = 0;
		while(head != null){

			while(!stack.isEmpty() && head.val > stack.peek()[0]){

				res[stack.pop()[1]] = head.val;
			}

			stack.push(new int[]{head.val,i});

			i++;

		}

		// while(!stack.isEmpty()){

		// 	res[stack.pop()[1]] = 0;
		// }

		return res;
	}

	public static int size(ListNode head){

		int count = 0;
		while(head != null){

			count++;
			head = head.next;
		}

		return count;
	}
}
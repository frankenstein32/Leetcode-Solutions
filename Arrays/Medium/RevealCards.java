import java.util.*;

public class RevealCards{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 2, 1, 2, 1 ,7};
		int target = 2;
		String str = "00110";
		display(deckRevealedIncreasing(arr));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	 public static int[] deckRevealedIncreasing(int[] nums) {

	 	Deque<Integer> index = new LinkedList<>();
	 	int[] ans = new int[nums.length];

	 	for(int i = 0;i < nums.length;i++){
	 		index.add(i);
	 	}
	 	Arrays.sort(nums);
	 	for(int num : nums){

	 		ans[index.pollFirst()] = num;

	 		if(!index.isEmpty()){
	 			index.add(index.pollFirst());
	 		}
	 	}

	 	return ans;

	 }
}
import java.util.*;

public class FindAll{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(find(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<Integer> find(int[] nums){

		Arrays.sort(nums);
		display(nums);
		List<Integer> ans = new ArrayList<>();

		int cnt = 1;
		for(int i = 0;i < nums.length;){

			if(cnt + 1 == nums[i]){
				i++;
				cnt++;
			}else if(cnt != nums[i]){
				cnt++;
				ans.add(cnt);
				
			}else{
				i++;
			}

		}

		System.out.println(cnt - 1);	

		return ans;

	
	}

}
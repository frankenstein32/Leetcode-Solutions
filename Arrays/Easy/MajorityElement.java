import java.util.*;

public class MajorityElement{
	
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

	public static int find(int[] nums){

		int ans = 0;
		int n = nums.length;
		HashMap<Integer,Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length;i++){

			if(map.containsKey(nums[i])){

				int oc = map.get(nums[i]);
				int nc = oc + 1;
				map.put(nums[i],nc);
			}else{

				map.put(nums[i],1);
			}
		}

		for(int i = 0;i < nums.length;i++){

			int cnt = map.get(nums[i]);

			if(cnt >= n/2){
				ans = nums[i];
				break;
			}
		}

		return ans;
	}

	public int majorityElement_Eff(int[] nums) {
        
        int ans = 0;

        Arrays.sort(nums);
        ans = nums[nums.length/2];
        
        
		return ans;
        
    }
}
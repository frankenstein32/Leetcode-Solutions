import java.util.*;

public class PartitionKequalSubsets{


	public static void main(String[] args){


		int[] arr = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;

		System.out.println(canPartition(arr,k));

	}

	public static boolean canPartition(int[] arr,int k){

 int sum = 0;
		for(int i : arr) sum += i;

		if(sum % k != 0) return false;

		boolean[] visited = new boolean[arr.length];
		Arrays.sort(arr);
		return dfs(arr,arr.length - 1,k,0, sum/k,visited);
	}

	public static boolean dfs(int[] arr, int idx,int k,int sum, int target,boolean[] visited){


		if(k == 0){
			return true;
		}

		if(sum == target){

			return dfs(arr, arr.length - 1, k - 1, 0,target,visited);
		}

		for(int i = idx;i >= 0;i--){


			if(visited[i] || arr[i] + sum > target) continue;

			visited[i] = true;
			if(dfs(arr, i - 1, k,sum + arr[i],target,visited)){
				return true;
			}
			visited[i] = false;
		}

		return false;
	}
}
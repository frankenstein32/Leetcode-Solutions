import java.util.*;

public class CanIWin{

	public static void main(String[] args){

		// Main
		System.out.println(chances(10, 11));

		
	}

	public static boolean chances(int maxChooseble, int target){

		boolean[] visited = new boolean[maxChooseble + 1];

		for(int i = 1;i <= maxChooseble ;i++){

			visited[i] = true;
			if(dfs(maxChooseble, target, 0,true, visited)){
				return true;
			}
			visited[i] = false;
		}

		return false;
	}

	public static boolean dfs(int maxChooseble, int target, int curr_sum, boolean isplayerTwo, boolean[] visited){

		if(curr_sum >= target){

			return isplayerTwo;
		}

		boolean canIwin = isplayerTwo;
		for(int i = 1;i <= maxChooseble;i++){

			if(!visited[i]){

				visited[i] = true;
				boolean canWinWithi = dfs(maxChooseble, target, curr_sum + i,!isplayerTwo, visited);
				visited[i] = false;

				if(isplayerTwo){

					canIwin = canIwin && canWinWithi;
				}else{

					canIwin = canIwin || canWinWithi;
				}
			}
		}

		return canIwin;
	}

	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

	

	
}
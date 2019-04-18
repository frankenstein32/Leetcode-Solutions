import java.util.*;

public class MinCostTickets{

	public static void main(String[] args){

		int[] days = {1,30};
		int[] cost = {2, 7, 15};
		System.out.println(minCost(days, cost));
		
	}

	public static int minCost(int[] days, int[] cost){

		Set<Integer> dayset = new HashSet<>();

		for(int day : days){
			dayset.add(day);
		}

		int[] strg = new int[366];
		Arrays.fill(strg, -1);

		System.out.println(helperBU(dayset, cost));
		System.out.println(helperTD(dayset, cost, 1, strg));
		return helper(dayset, cost, 1);
	}

	public static int helper(Set<Integer> dayset, int[] cost, int day){

		if(day > 365){

			return 0;
		}

		if(dayset.contains(day)){

			int c1 = helper(dayset, cost, day + 1) + cost[0];
			int c2 = helper(dayset, cost, day + 7) + cost[1];
			int c3 = helper(dayset, cost, day + 30) + cost[2];

			return Math.min(c1, Math.min(c2, c3));
		}else{
			return helper(dayset, cost, day + 1);
		}
		
	}

	public static int helperTD(Set<Integer> dayset, int[] cost, int day, int[] strg){

		if(day > 365){

			return 0;
		}

		if(strg[day] != -1){
			return strg[day];
		}

		if(dayset.contains(day)){

			int c1 = helperTD(dayset, cost, day + 1, strg) + cost[0];
			int c2 = helperTD(dayset, cost, day + 7, strg) + cost[1];
			int c3 = helperTD(dayset, cost, day + 30, strg) + cost[2];

			return strg[day] = Math.min(c1, Math.min(c2, c3));
		}else{
			return strg[day] = helperTD(dayset, cost, day + 1, strg);
		}
		
	}

	public static int helperBU(Set<Integer> dayset, int[] cost){

		int[] strg = new int[397];

		for(int i = 365; i >= 0; i--){

			if(dayset.contains(i)){

				int c1 = strg[i + 1] + cost[0];
				int c2 = strg[i + 7] + cost[1];
				int c3 = strg[i + 30] + cost[2];

				strg[i] = Math.min(c1, Math.min(c2, c3));
			}else{
				strg[i] = strg[i + 1];
			}
		}

		return strg[0];
	}

	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}
	

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
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
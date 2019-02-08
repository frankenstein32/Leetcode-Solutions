import java.util.*;

public class  min_cost_climbing_stairs{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int k = 4;
		// display2(arr);
		
		System.out.println(minCostClimbingStairs(arr));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int minCostClimbingStairs(int[] cost){

		System.out.println(climb(cost,0,new int[cost.length]));
		return climb_BU(cost);
		
	}

	public static int climb(int[] cost, int vidx,int[] strg){

		if(vidx >= cost.length - 1){
			return 0;
		}

		if(strg[vidx] != 0){
			return strg[vidx];
		}


		int rr1 = climb(cost,vidx + 1,strg) + cost[vidx];
		int rr2 = climb(cost,vidx + 2,strg) + cost[vidx + 1];

		strg[vidx] = Math.min(rr1,rr2);
		return Math.min(rr1,rr2);
	}
	public static int climb_BU(int[] cost){

		int[] strg = new int[cost.length + 1];

		for(int i = cost.length - 2;i >= 0;i--){

			strg[i] = Math.min(strg[i + 1] + cost[i],strg[i + 2] + cost[i + 1]);
		}

		return strg[0];

	}


	
		
}

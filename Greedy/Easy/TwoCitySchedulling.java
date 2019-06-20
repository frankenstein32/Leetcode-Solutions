import java.util.*;

class TwoCitySchedulling{

	
	public int twoCitySchedCost(int[][] costs){

		Arrays.sort(costs, new Comparator<int[]>(){

			@Override
			public int compare(final int[] entry1, final int[] entry2){
				return (entry1[1] - entry1[0]) - (entry2[1] - entry2[0]);
			}
		});

		int sum = 0;
		int n = costs.length;
		for(int i = 0;i < costs.length;i++){

			sum += costs[i][1] + costs[n - i - 1][0];
		}

		return sum;
	}

}



	
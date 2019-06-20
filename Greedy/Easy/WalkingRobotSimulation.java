import java.util.*;

class WalkingRobotSimulation{

	
	public int robotSim(int[] commands, int[][] obstacles){

		Set<String> set = new HashSet<>();

		for(int[] obs : obstacles){

			set.add(obs[0]+" "+obs[1]);
		}

		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = 0;
		int y = 0;
		int res = 0;
		for(int c : commands){

			if(c == -2){

				d = d % dirs.length;
			}else if(c == -1){
				
				d = (d > 0 ? d-- : dirs.length - 1);
			}else{

				while(c-- > 0 && !set.contains((x + dirs[d][0])+" "+ (y + dirs[d][1]))){

					x += dirs[d][0];
					y += dirs[d][1];
				}
			}

			res = Math.max(res, x * x + y * y);
		}

		return res;
	}
}

	
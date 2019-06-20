import java.util.*;

class GasStation{

	public int canCompleteCircuit(int[] gas, int[] cost){

		int tank = 0;

		for(int i = 0;i < gas.length;i++)
			tank += gas[i] - cost[i];

		if(tank < 0)
			return -1;

		int accumulate = 0;
		int start = 0;

		for(int i = 0;i < gas.length;i++){

			int curGain = gas[i] - cost[i];

			if(accumulate + curGain < 0){
				accumulate = 0;
				curGain = 0;
			}else{
				accumulate += curGain;
			}
		}

		return start;
	}
}



	
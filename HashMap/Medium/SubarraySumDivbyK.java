import java.util.*;

public class SubarraySumDivbyK{
	

	public int subarrayDivbyK(int[] A, int k){

		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int sum = 0, count = 0;

		for(int a : A){
			sum = (sum + a) % k;

			if(sum < 0){
				sum += k;
			}

			count += map.getOrDefault(sum, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
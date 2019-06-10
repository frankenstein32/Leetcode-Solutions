import java.util.*;

public class CarFleet{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int[] calculate(int target, int[] position, int[] speed){

		TreeMap<Integer, Double> map = new TreeMap<>();

		for(int i = 0;i < position.length;i++){

			map.put(position[i], (double)(target - position[i]) / speed[i]);
		}	

		int curr = 0;
		int ans = 0;
		for(int time : map.values){

			if(time > curr){
				curr = time;
				ans++;
			}
		}

		return ans;
		
	}
}
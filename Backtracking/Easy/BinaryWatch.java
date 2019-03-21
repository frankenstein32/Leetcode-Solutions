import java.util.*;

public class BinaryWatch{

	static final int[] watchList = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

	public static void main(String[] args){


		int n = 1;
		int k = 1;

		System.out.println(readWatch(1));

	}

	public static List<String> readWatch(int num){

		List<String> ans = new ArrayList<>();

		if(num >= 0){

			dfs(num, 0, ans, 0,0);
		}

		return list;
		
	}

	public static void dfs(int num, int start, List<String> list, int hour, int min){

		if(num <= 0){

			if(hour < 12 && min < 60){

				if(min < 10){
					list.add(hour + ":0"+min);
				}else{
					list.add(hour + ":"+min);
				}

				return;
			}

		}
		
		for(int i = start;i < watch.length;i++){

			if(i < 4){
				dfs(num - 1, i + 1, list, hour + watch[i], min);
			}else{
				dfs(num - 1, i + 1, list, hour, min + watch[i]);
				}
			}
			
	}

	
}
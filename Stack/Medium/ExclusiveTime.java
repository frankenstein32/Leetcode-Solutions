import java.util.*;

public class ExclusiveTime{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int[] ExclusiveTime(int n,List<String> logs){


		Stack<int[]> stack = new Stack<>();

		int[] func = new int[n];

		for(int i = 0;i < logs.size();i++){

			String[] arr = logs.get(i).split(":");

			int idx = Integer.parseInt(arr[0]);
			int timestamp = Integer.parseInt(arr[2]);

			if(stack.isEmpty()){

				stack.push(new int[]{idx, timestamp});
			}else if(str[1].equals("start")){

				int startTime = stack.peek()[1];
				int secondTime = timestamp;

				func[stack.peek()[0]] += secondTime - startTime;

				stack.push(new int[]{idx, timestamp});

			}else{

				int finishTime = timestamp;
				int startTime = stack.peek()[1];

				func[stack.peek()[0]] = finishTime - startTime + 1;

				stack.pop();

				stack.peek()[1] = finishTime;
			}

		}

		return func;
	}	 
}
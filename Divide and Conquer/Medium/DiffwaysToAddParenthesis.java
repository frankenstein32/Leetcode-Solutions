import java.util.*;

public class DiffwaysToAddParenthesis{


	public static void main(String[] args){


		int[][] nums = {{},{}};
		int k = 1;

		String input = "2-2-2";

		System.out.println(diffWaysToCompute(nums));

	}

	public static List<Integer> diffWaysToCompute(String input){

		List<Integer> res = new ArrayList<>();
		for(int i = 0;i < input.length();i++){

			char ch = input.charAt(i);

			if(ch == '+' || ch == '-' || ch == '*'){
				List<Integer> ans1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> ans2 = diffWaysToCompute(input.substring(i + 1));


				for(int val1 : ans1){
					for(int val2 : ans2){

						if(ch == '+'){
							res.add(val1 + val2);
						}else if(ch == '-'){
							res.add(val1 - val2);
						}else if(ch == '*'){
							res.add(val1 * val2);
						}
					}
				}

			}
		}

		if(res.size() == 0){
			res.add(Integer.valueOf(input));
		}

		return res;
	}
}
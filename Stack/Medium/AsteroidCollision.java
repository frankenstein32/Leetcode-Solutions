import java.util.*;

public class AsteroidCollision{


	public static void main(String[] args){

		String preorder = "";


	}

	public static int[] collision(int[] asteroids){
    
      Stack<Integer> stack = new Stack<>();

		for(int ast : asteroids){

			Collision: {
				while(!stack.isEmpty() && ast < 0 && stack.peek() > 0){

					if(stack.peek() < - ast){
						stack.pop();
						continue;
					}else if(stack.peek() == - ast){
						stack.pop();
					}

					break Collision;
				}

				stack.push(ast);
			}
		}


		int[] res = new int[stack.size()];
		int i = stack.size() - 1;
		while(!stack.isEmpty()){

			res[i--] = stack.pop();
		}

		return res;
	}	 
}
import java.util.*;

public class PostOreder{


	public static void main(String[] args){

		String postorder = "";


	}

	static class pair{

		TreeNode val;
		boolean ld = false;
		boolean rd = false;
		boolean sd = false;

		public pair(TreeNode x){ this.val = x; }
	}

	public static void print(TreeNode root){

		List<Integer> res = new ArrayList<>();

		Stack<Integer> stack = new Stack<>();

		pair nn = new pair(root.val);
		stack.add(nn);

		while(!stack.isEmpty()){

			pair rp = stack.peek();

			if(!rp.rd){

				pair np = new pair(root.right);

				if(np.val != null){
					stack.add(np);
				}

				rp.rd = true;
			}else if(!rp.ld){

				pair np = new pair(root.left);

				if(np.val != null){
					stack.add(np);
				}

				rp.ld = true;
			}else if(!rp.sd){
				res.add(rp.val.val);
				rp.sd = true;
			}else{
				stack.pop();
			}
		}

		return res;

	}


}
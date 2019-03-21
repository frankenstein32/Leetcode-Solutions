import java.util.*;

public class KthGrammer{


	public static void main(String[] args){


		int n = 1;
		int k = 1;

		System.out.println(kthGrammar(n,k));

	}

	public static char kthGrammar(int n,int k){

		String ans =  helper(n, "0");
		return ans.charAt(k - 1);
	}

	public static String helper(int n, int k){

		if(n == 1){
			return 0;
		}


		int parentk = (k / 2) + (k % 2);

		int parent = helper(n - 1,parentk);

		if(k % 2 == 1){
			return parent;
		}else{
			return 1 - parent;
		}

	}

	
}
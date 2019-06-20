import java.util.*;

class AssignCookies{

	public int findContentChildren(int[] g, int[] s){


		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0, j = 0;
		int res = 0;
		while(i < g.length && j < s.length){

			if(g[i] <= s[j]){
				i++;
				res++;
			}else{
				j++;
			}
		}

		return res;
	}
}

	
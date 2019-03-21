import java.util.*;

public class wordBreak{

	public static void main(String[] args){

		// String s = "a*";
		// String p = "aa";
		int n = 3;
		System.out.println(comb(n,1));

	}

	public static List<String> restoreIPAdress(String s){

		List<String> ans = new ArrayList<>();

		int len = s.length();

		for(int i = 1;i <= 3;i++){

			if(len - i > 9){
				continue;
			}

			for(int j = i + 1;j <= i + 3;j++){

				if(len - j > 6){
					continue;
				}

				for(int k = j + 1; k < len && k <= j + 3;k++){

					int a, b, c, d;
					a = Integer.parseInt(s.substring(0,i));
					b = Integer.parseInt(s.substring(i,j));
					c = Integer.parseInt(s.substring(j,k));
					d = Integer.parseInt(s.substring(k));

					if(a > 255 || b > 255 || c > 255 || d > 255){

						continue;
					}
	
					String ip = a+"."+b+"."+c+"."+d;

					if(ip.length() < len + 3){

						continue;
					}

					ans.add(ip);
				}
			}
		}

		return ans;
	}
}
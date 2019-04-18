import java.util.*;

public class KnightDialer{

	public static void main(String[] args){

		// Main
		System.out.println(dialer(3));

		
	}

	public static int dialer(int n){

		int[][][] strg = new int[n + 1][4][3];

		for(int [][] arr : strg){
			for(int[] val : arr)
				Arrays.fill(val, -1);
		}

		int cnt = 0;
		int m = 1_000_000_007;
		for(int cr = 0; cr < 4;cr++){
			for(int cc = 0; cc < 3;cc++){

				if((cr == 3 && cc == 0) || (cr == 3 && cc == 2)){
					continue;
				}

				cnt = (cnt + helperTD(cr, cc, n, strg)) % m;
			}
		}
		
		System.out.println(helperBU_EFF(n));
		System.out.println(helperBU(n));
		return cnt;
	
	}

	public static int helper(int cr, int cc, int n){

		if(cr < 0 || cc < 0 || cr >= 4 || cc >= 3 || ((cr == 3 && cc == 0) || (cr == 3 && cc == 2))){
			return 0;
		}

		if(n == 1){
			return 1;
		}

		int[] row = {-1, -2, -1, -2, 1, 2, 1 ,2};
		int[] col = {-2, -1, 2, 1, 2, 1, -2, -1};

		int cnt = 0;
		int m = 1_000_000_007;
		for(int i = 0;i < 8;i++){

			cnt = (cnt + helper(cr + row[i], cc + col[i],n - 1)) % m;
		}
		

		return cnt;
	}

	public static int helperTD(int cr, int cc, int n, int[][][] strg){

		if(cr < 0 || cc < 0 || cr >= 4 || cc >= 3 || ((cr == 3 && cc == 0) || (cr == 3 && cc == 2))){
			return 0;
		}

		if(strg[n][cr][cc] != -1){
			return strg[n][cr][cc];
		}

		if(n == 1){
			return 1;
		}

		int[] row = {-1, -2, -1, -2, 1, 2, 1 ,2};
		int[] col = {-2, -1, 2, 1, 2, 1, -2, -1};

		int cnt = 0;
		int m = 1_000_000_007;
		for(int i = 0;i < 8;i++){

			cnt = (cnt + helperTD(cr + row[i], cc + col[i],n - 1, strg)) % m;
		}
		

		return strg[n][cr][cc] = cnt;
	}

	public static int helperBU(int n){

		int[][][] strg = new int[n + 1][4][3];
		int m  = 1_000_000_007;
		int ans = 0;

		for(int i = 1;i <= n;i++){
			ans = 0;
			for(int cr = 0;cr < 4;cr++){
				for(int cc = 0; cc < 3;cc++){

					int cnt = 0;

					if((cr == 3 && cc == 0) || (cr == 3 && cc == 2)){
						continue;
					}

					if(i == 1){
						strg[i][cr][cc] = 1;
						ans += 1;
						continue;
					}

					int[] row = {-1, -2, -1, -2, 1, 2, 1 ,2};
					int[] col = {-2, -1, 2, 1, 2, 1, -2, -1};


					for(int j = 0; j < 8;j++){

						int r = cr + row[j];
						int c = cc + col[j];

						if((r >= 0 && r < 4) && (c >= 0 && c < 3) && (!(r == 3 && c == 0) && !(r == 3 && c == 2))){	
							cnt = (cnt + strg[i - 1][r][c]) % m;
						}

						
					}

					strg[i][cr][cc] = cnt;
					ans = (ans + cnt) % void method() throws  {
						
					};
				}
			}
		}
		return ans;
	}

	public static int helperBU_EFF(int n){

		int[][] strg = new int[4][3];
		int m  = 1_000_000_007;
		int ans = 0;

		for(int i = 1;i <= n;i++){
			ans = 0;

			int[][] temp = new int[4][3];
			for(int cr = 0;cr < 4;cr++){
				for(int cc = 0; cc < 3;cc++){

					int cnt = 0;

					if((cr == 3 && cc == 0) || (cr == 3 && cc == 2)){
						continue;
					}

					if(i == 1){
						temp[cr][cc] = 1;
						ans += 1;
						continue;
					}

					int[] row = {-1, -2, -1, -2, 1, 2, 1 ,2};
					int[] col = {-2, -1, 2, 1, 2, 1, -2, -1};


					for(int j = 0; j < 8;j++){

						int r = cr + row[j];
						int c = cc + col[j];

						if((r >= 0 && r < 4) && (c >= 0 && c < 3) && (!(r == 3 && c == 0) && !(r == 3 && c == 2))){	
							cnt = (cnt + strg[r][c]) % m;
						}

						
					}

					temp[cr][cc] = cnt;
					ans += cnt;
				}
			}

			strg = temp;
		}

		return ans;

	}

	public static void display(int[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					int value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}

	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

	

	
}
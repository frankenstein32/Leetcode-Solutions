import java.util.*;

public class BoundaryPath{

	public static void main(String[] args){

		int m = 5;
		int n = 5;
		int N = 4;
		int i = 0;
		int j = 0;
		System.out.println(findPaths(i, j, m, n, N));
		
	}

	public static int findPaths(int cr, int cc, int er, int ec, int moves){

		int[][][] strg = new int[moves + 1][er][ec];

		for(int[][] arr : strg){
			for(int[] item : arr)
				Arrays.fill(item, -1);
		}

		System.out.println(helperBU_EFF2(cr, cc, er, ec, moves));
		System.out.println(helperBU2(cr, cc, er, ec, moves));
		System.out.println(helperBU_EFF(cr, cc, er, ec, moves));
		System.out.println(helperBU(cr, cc, er, ec, moves));
		System.out.println(helperTD(cr, cc, er, ec, moves, strg));
		return helper(cr, cc, er, ec, moves);
	}

	public static int helper(int cr, int cc, int er, int ec, int moves){

		if(cr < 0 || cc < 0 || cr >= er || cc >= ec){
			return 1;
		}

		if(moves == 0){
			return 0;
		}

		int cnt = 0;
		cnt += helper(cr + 1, cc, er, ec, moves - 1);
		cnt += helper(cr - 1, cc, er, ec, moves - 1);
		cnt += helper(cr, cc + 1, er, ec, moves - 1);
		cnt += helper(cr, cc - 1, er, ec, moves - 1);

		return (cnt % 1_000_000_007);

	}

	public static int helperTD(int cr, int cc, int er, int ec, int moves, int[][][] strg){

		if(cr < 0 || cc < 0 || cr >= er || cc >= ec){

			return 1;
		}

		if(moves == 0){
			return 0;
		}

		if(strg[moves][cr][cc] != -1){

			return strg[moves][cr][cc];
		}

		int cnt = 0;
		cnt += helperTD(cr + 1, cc, er, ec, moves - 1, strg);
		cnt += helperTD(cr - 1, cc, er, ec, moves - 1, strg);
		cnt += helperTD(cr, cc + 1, er, ec, moves - 1, strg);
		cnt += helperTD(cr, cc - 1, er, ec, moves - 1, strg);

		return strg[moves][cr][cc] = (cnt % 1_000_000_007);
		// return cnt;

	}

	public static long helperBU(int srow, int scol, int er, int ec, int moves){

		long[][][] strg = new long[moves + 1][er][ec];
		long m = 1_000_000_007L;
		for(int move = 1; move <= moves;move++){

			for(int cr = er - 1;cr >= 0;cr--){

				for(int cc = ec - 1;cc >= 0;cc--){

					long ans = 0;

					if(cr + 1 >= er){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[move - 1][cr + 1][cc]) % m; 
					}

					if(cr - 1 < 0){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[move - 1][cr - 1][cc]) % m; 
					}

					if(cc + 1 >= ec){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[move - 1][cr][cc + 1]) % m; 
					}

					if(cc - 1 < 0){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[move - 1][cr][cc - 1]) % m; 
					}

					strg[move][cr][cc] = ans;
				}
			}
		}

		return strg[moves][srow][scol];
	}

	public static long helperBU2(int srow, int scol, int er, int ec, int moves){

		long[][][] strg = new long[moves + 1][er][ec];
		long m = 1_000_000_007L;
		long res = 0;

		int[][] dirs = {{-1, 0}, {1, 0},{0, -1}, {0, 1}};
		for(int move = 1; move <= moves;move++){

			for(int cr = er - 1;cr >= 0;cr--){

				for(int cc = ec - 1;cc >= 0;cc--){

					res = 0;
					for(int[] d : dirs){

						int r = cr + d[0];
						int c = cc + d[1];

						if(r < 0 || r >= er || c < 0 || c >= ec){
							res++;
						}else{
							strg[move][cr][cc] = (strg[move][cr][cc] + strg[move - 1][r][c]) % m;
						}
					}
					strg[move][cr][cc] = (strg[move][cr][cc] + res) % m;

				}
			}
		}

		return strg[moves][srow][scol];
	}


	public static long helperBU_EFF(int srow, int scol, int er, int ec, int moves){

		long[][] strg = new long[er][ec];
		long m = 1_000_000_007L;

		for(int move = 1; move <= moves;move++){

			long[][] temp = new long[er][ec];

			for(int cr = er - 1;cr >= 0;cr--){

				for(int cc = ec - 1; cc >= 0;cc--){

					long ans = 0;

					if(cr + 1 >= er){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[cr + 1][cc]) % m; 
					}

					if(cr - 1 < 0){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[cr - 1][cc]) % m; 
					}

					if(cc + 1 >= ec){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[cr][cc + 1]) % m; 
					}

					if(cc - 1 < 0){
						ans = (ans + 1) % m;
					}else{
						ans = (ans + strg[cr][cc - 1]) % m; 
					}

					temp[cr][cc] = ans;

				}
			}

			strg = temp;
		}

		return strg[srow][scol];
	}

	public static long helperBU_EFF2(int srow, int scol, int er, int ec, int moves){

		long[][] strg = new long[er][ec];
		long m = 1_000_000_007L;
		int[][] dirs = {{-1, 0}, {1, 0},{0, -1}, {0, 1}};

		for(int move = 1; move <= moves;move++){

			long[][] temp = new long[er][ec];

			for(int cr = er - 1;cr >= 0;cr--){

				for(int cc = ec - 1; cc >= 0;cc--){

					long res = 0;
					for(int[] d : dirs){

						int r = cr + d[0];
						int c = cc + d[1];

						if(r < 0 || r >= er || c < 0 || c >= ec){
							res++;
						}else{
							temp[cr][cc] = (temp[cr][cc] + strg[r][c]) % m;
						}
					}
					temp[cr][cc] = (temp[cr][cc] + res) % m;

				}
			}

			strg = temp;
		}

		return strg[srow][scol];
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
	

	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
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
import java.util.*;

public class EggDrop{

	public static void main(String[] args){

		// Main
		int n = 7;
		int k = 2;
		System.out.println(minDrps(n, k));
	}

	public static int minDrps(int N, int K){

		int[][] strg = new int[N + 1][K + 1];

		for(int[] val : strg)
			Arrays.fill(val, -1);

		System.out.println(helper2BU_EFF(N,K));
		System.out.println(helper2BU(N, K));
		mover temp = new mover();
		temp.moves = N;
		helper2TD(N, K, temp, N, strg);
		System.out.println(temp.moves);
		temp.moves = N;
		helper2(N, K, temp, N);
		System.out.println(temp.moves);

		System.out.println(helperBU2(N, K));
		System.out.println(helperBU(N, K));
		helperTD2(N, K, strg);
		helperTD(N, K, strg);
		return helper(N, K);
	}

	public static int helper(int N, int K){


		if(K == 1 || N <= 1){
			return N;
		}

		int min = N;

		for(int floor = 1;floor <= N;floor++){

			int below = helper(floor - 1, K - 1);
			int above = helper(N - floor, K);

			min = Math.min(min, Math.max(below, above) + 1);
		}

		return min;
	
	}

	static class mover{

		int ans = 1000000;
		int moves;
	}

	
	public static int helper2(int moves, int K, mover m, int N){

		if(moves <= 0){
			return 0;
		}

		if(K == 0){
			return 0;
		}

		int left = helper2(moves - 1, K - 1,m, N);
		int right = helper2(moves - 1, K,m, N);

		int ans = left + right + 1;

		
		if(ans >= N && moves <= m.moves){
			m.moves = moves;
			m.ans = ans;
		}
		return ans;		
	}

	public static int helper2TD(int moves, int K, mover m, int N, int[][] strg){

		if(moves <= 0){
			return 0;
		}

		if(K == 0){
			return 0;
		}

		if(strg[moves][K] != -1){
			return strg[moves][K];
		}

		int left = helper2TD(moves - 1, K - 1,m, N, strg);
		int right = helper2TD(moves - 1, K,m, N, strg);

		int ans = left + right + 1;

		
		if(ans >= N && moves <= m.moves){
			m.moves = moves;
			m.ans = ans;
		}

		return strg[moves][K] = ans;


	}

	public static int helper2BU(int N, int K){

		int[][] strg = new int[N + 1][K + 1];

		int moves = 0;

		while(strg[moves][K] < N){

			moves++;

			for(int k = 1;k <= K;k++){

				strg[moves][k] = strg[moves - 1][k - 1] + strg[moves - 1][k] + 1;
			}
		}

		return moves;
	}

	public static int helper2BU_EFF(int N, int K){

		int[] strg = new int[K + 1];

		int moves = 0;

		while(strg[K] < N){

			moves++;

			for(int k = K;k > 0;k--){

				strg[k] = strg[k - 1] + strg[k] + 1;
			}
		}

		return moves;
	}



	public static int helperTD(int N, int K, int[][] strg){


		if(K == 1 || N <= 1){
			return N;
		}

		if(strg[N][K] != -1){
			return strg[N][K];
		}

		int min = N;

		for(int floor = 1;floor <= N;floor++){

			int below = helperTD(floor - 1, K - 1, strg);
			int above = helperTD(N - floor, K,strg);

			min = Math.min(min, Math.max(below, above) + 1);
		}

		return strg[N][K] = min;
	
	}

	public static int helperTD2(int N, int K, int[][] strg){


		if(K == 1 || N <= 1){
			return N;
		}

		if(strg[N][K] != -1){
			return strg[N][K];
		}

		int min = N;

		int low = 1;
		int high = N;

		while(low < high){

			int mid = low + (high - low)/2;

			int left = helperTD2(mid - 1, K - 1,strg);
			int right = helperTD2(N - mid, K,strg);

			min = Math.min(min, Math.max(left, right) + 1);
			if(left == right){
				break;
			}else if(left < right){

				low = mid + 1;
			}else{
				high = mid;
			}
		}

		return min;
	
	}



	public static int helperBU(int N, int K){


		int[][] strg = new int[N + 1][K  + 1];


		for(int i = 0;i <= N;i++){	

			for(int j = 1;j <= K;j++){
				
				if(i <= 1 || j == 1){
					strg[i][j] = i;
					continue;
				}

				int min = i;

				for(int floor = 1;floor <= i;floor++){

					int below = strg[floor  - 1][j - 1];
					int above = strg[i - floor][j];

					min = Math.min(min, Math.max(below, above) + 1);
				}

				strg[i][j] = min;
			}
		}

		return strg[N][K];
	}

	public static int helperBU2(int N, int K){


		int[][] strg = new int[N + 1][K  + 1];


		for(int i = 0;i <= N;i++){	

			for(int j = 1;j <= K;j++){
				
				if(i <= 1 || j == 1){
					strg[i][j] = i;
					continue;
				}

				int min = N;

				int low = 1;
				int high = i;

				while(low < high){

					int mid = low + (high - low)/2;

					int left = strg[mid - 1][j - 1];
					int right = strg[i - mid][j];

					min = Math.min(min, Math.max(left, right) + 1);
					if(left == right){
						break;
					}else if(left < right){
						low = mid + 1;
					}else{
						high = mid;
					}
				}

				strg[i][j] = min;
			}
		}

		return strg[N][K];
}


	public static void display(int[][] arr){


		for(int[] val : arr){
			for(int item : val){
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}

	public static void display(int[] arr){

			for(int item : arr){
				System.out.print(item+" ");
			

		}
		System.out.println();
	}

	

	
}
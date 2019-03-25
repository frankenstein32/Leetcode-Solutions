import java.util.*;

public class MinFallingPath{

	public static void main(String[] args){

		int[] nums = {5,3,4,5};
		System.out.println(gameOn(nums));
		
	}

	public static void display(int[][] piles){

		for(int[] pile : piles){

			for(int stone : pile){
				System.out.print(stone +"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean gameOn(int[] piles){

		// System.out.println(gameOn(piles, 0, piles.length - 1, 0, 0,true,new int[piles.length][piles.length]));
		// return gameOn(piles, 0, piles.length - 1, 0, 0,true);
		System.out.println(gameOnIntBU_EFF(piles) > 0);
		System.out.println(gameOnIntBU(piles) > 0);
		return gameOnIntTD(piles, 0, piles.length - 1,true, new int[piles.length][piles.length]) > 0; 

	}

	public static boolean gameOn(int[] piles, int si, int ei, int alex, int lee, boolean turn){

		if(si > ei){

			return alex > lee;

		}

		if(turn){

			boolean rr1 = gameOn(piles, si + 1,ei,alex + piles[si],lee,false);
			boolean rr2 = gameOn(piles, si,ei - 1,alex + piles[ei],lee,false);

			return rr1 || rr2;
		}

		boolean rr1 = gameOn(piles, si + 1, ei, alex, lee + piles[si], true);
		boolean rr2 = gameOn(piles, si, ei - 1, alex, lee + piles[ei], true);

		return rr1 && rr2;
		

	}

	public static boolean gameOnTD(int[] piles, int si, int ei, int alex, int lee, boolean turn, boolean[][] strg){


		if(si > ei){

			return alex > lee;

		}

		if(strg[si][ei]){
			return true;
		}

		if(turn){

			boolean rr1 = gameOnTD(piles, si + 1,ei,alex + piles[si],lee,false, strg);
			boolean rr2 = gameOnTD(piles, si,ei - 1,alex + piles[ei],lee,false, strg);

			strg[si][ei] = rr1 || rr2;
			return rr1 || rr2;
		}

		boolean rr1 = gameOnTD(piles, si + 1, ei, alex, lee + piles[si], true, strg);
		boolean rr2 = gameOnTD(piles, si, ei - 1, alex, lee + piles[ei], true, strg);

		strg[si][ei] = rr1 && rr2;
		return rr1 && rr2;
		
	}

	public static int gameOnInt(int[] piles, int si, int ei, boolean turn){

		if(si > ei){

			return 0;

		}

		if(turn){

			int rr1 = gameOnInt(piles, si + 1,ei,false) + piles[si];
			int rr2 = gameOnInt(piles, si,ei - 1,false) + piles[ei];

			return Math.max(rr1, rr2);
		}

		int rr1 = gameOnInt(piles, si + 1, ei, true) - piles[si];
		int rr2 = gameOnInt(piles, si, ei - 1, true) - piles[ei];

		return Math.min(rr1, rr2);
		

	}

	public static int gameOnIntTD(int[] piles, int si, int ei, boolean turn, int[][] strg){

		if(si > ei){
			return 0;
		}

		if(strg[si][ei] > 0){
			return strg[si][ei];
		}

		if(turn){

			int rr1 = gameOnIntTD(piles, si + 1,ei,false, strg) + piles[si];
			int rr2 = gameOnIntTD(piles, si,ei - 1,false, strg) + piles[ei];

			strg[si][ei] = Math.max(rr1, rr2);
			return strg[si][ei];
		}

		int rr1 = gameOnIntTD(piles, si + 1, ei, true, strg) - piles[si];
		int rr2 = gameOnIntTD(piles, si, ei - 1, true, strg) - piles[ei];

		strg[si][ei] = Math.min(rr1, rr2);
		return strg[si][ei];


	}

	public static int gameOnIntBU(int[] piles){


		int[][] strg = new int[piles.length ][piles.length ];
		boolean turn = false;


		for(int slide = 0; slide < piles.length;slide++){

			for(int si = 0;si < piles.length - slide;si++){

				int ei = slide + si;

				if(si == ei){
					strg[si][ei] = -piles[si];
					continue;
				}

				if(turn){

					strg[si][ei] = Math.max(strg[si + 1][ei] + piles[si] ,strg[si][ei - 1] + piles[ei]);
				}else{

					strg[si][ei] = Math.min(strg[si + 1][ei] - piles[si], strg[si][ei - 1] - piles[ei]);
				}
			}

			turn = !turn;
		}

			display(strg);

			return strg[0][strg.length - 1];

	}

	public static int gameOnIntBU_EFF(int[] piles){


		int[] strg = new int[piles.length];

		boolean turn = true;

		strg[piles.length - 1] = piles[piles.length - 1];

		for(int si = piles.length - 1; si >= 0;si--){

			for(int ei = si; ei < piles.length; ei++){

				if(si == ei){

					strg[ei] = piles[ei];
					continue;
				}

				if(turn){

					strg[ei] = Math.max(strg[ei] + piles[ei], strg[ei - 1] + piles[ei - 1]);
				}else{

					strg[ei] = Math.min(strg[ei] - piles[ei], strg[ei - 1] - piles[ei - 1]);
				}

				turn = !turn;
			}

		}

		return strg[strg.length - 1];

	}
}
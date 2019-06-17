import java.util.*;

class DungeonGame{

	public int calculateMinimumHP(int[][] dungeon){

		return helper(dungeon, 0, 0);

	}

	public int helper(int[][] dungeon, int cr, int cc){

		if(cr == dungeon.length - 1 && cc == dungeon[0].length - 1){
			return Math.max(1, 1 - dungeon[cr][cc]);
		}

		if(cr >= dungeon.length || cc >= dungeon[0].length){
			return Integer.MAX_VALUE;
		}


		int minVertical = helper(dungeon, cr + 1, cc);
		int minHorizontal = helper(dungeon, cr, cc + 1);

		return 	Math.max(1, Math.min(minVertical, minHorizontal) - dungeon[cr][cc]);
	}

	public int helperTD(int[][] dungeon, int cr, int cc, int[][] strg){

		if(cr == dungeon.length - 1 && cc == dungeon[0].length - 1){
			return Math.max(1, 1 - dungeon[cr][cc]);
		}

		if(cr >= dungeon.length || cc >= dungeon[0].length){
			return 0;
		}

		if(strg[cr][cc] != -1){
			return strg[cr][cc];
		}


		int minVertical = helperTD(dungeon, cr + 1, cc, strg);
		int minHorizontal = helperTD(dungeon, cr, cc + 1, strg);

		return 	strg[cr][cc] = Math.max(1, Math.min(minVertical, minHorizontal) - dungeon[cr][cc]);

	}

	public int helperBU(int[][] dungeon){

		int[][] strg = new int[dungeon.length + 1][dungeon[0].length + 1];

		for(int i = dungeon.length - 1;i >= 0;i--){

			for(int j = dungeon[0].length - 1; j >= 0; j--){

				if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
					strg[i][j] = Math.max(1, 1 - dungeon[i][j]);
					continue;
				}

				if(i == dungeon.length - 1){
					strg[i][j] = Math.max(1, strg[i][j + 1] - dungeon[i][j]);
					continue;

				}

				if(j == dungeon[0].length - 1){
					strg[i][j] = Math.max(1, strg[i + 1][j] - dungeon[i][j]);
					continue;
				}

				strg[i][j] = Math.max(1, Math.min(strg[i + 1][j], strg[i][j + 1]) - dungeon[i][j]);
			}
		}

		return strg[0][0];
	}

	public int helperBU_EFF(int[][] dungeon){

		int[] strg = new int[dungeon[0].length + 1];

		for(int i = dungeon.length - 1;i >= 0;i--){

			for(int j = dungeon[0].length - 1; j >= 0; j--){

				if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
					strg[j] = Math.max(1, 1 - dungeon[i][j]);
					continue;
				}

				if(i == dungeon.length - 1){
					strg[j] = Math.max(1, strg[j + 1] - dungeon[i][j]);
					continue;

				}

				if(j == dungeon[0].length - 1){
					strg[j] = Math.max(1, strg[j] - dungeon[i][j]);
					continue;
				}

				strg[j] = Math.max(1, Math.min(strg[j], strg[j + 1]) - dungeon[i][j]);
			}
		}

		return strg[0];
	}
}

	
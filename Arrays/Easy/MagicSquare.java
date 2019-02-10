import java.util.*;

public class MagicSquare{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr = {{4, 3, 8, 9},{9, 5, 1, 9},{2, 7, 6, 2}};

		for(int i = 0;i < n;i++){

			arr[i] = scn.nextInt();
		}

		System.out.println(numMagicSquaresInside(arr));
	
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int numMagicSquaresInside(int[][] nums){

		int R = nums.length;
		int C = nums[0].length;
		int ans = 0;

		for(int i = 0;i < R - 2;i++){

			for(int j = 0;j < C - 2;j++){

				if(nums[i + 1][j + 1] != 5) continue;

				if(isMagic( nums[i][j], nums[i + 1][j], nums[i + 2][j] ,nums[i][j + 1],
							nums[i][j + 2],nums[i + 1][i + 2],nums[i + 2][j + 2	]
							nums[i + 1][c + 2], nums[r + 2][c + 1])){

					ans++;

				}
			}
		}
		return ans;

	}


	public static int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R-2; ++r)
            for (int c = 0; c < C-2; ++c) {
                if (grid[r+1][c+1] != 5) continue;  // optional skip
                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                          grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                          grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2]))
                    ans++;
            }

        return ans;
    }

    public static boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v: vals) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }


}					
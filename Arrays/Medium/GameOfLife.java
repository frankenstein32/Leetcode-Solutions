import java.util.*;

public class GameOfLife {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[][] arr = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		// for(int i = 0;i < n;i++){

		// arr[i] = scn.nextInt();
		// }
		int target = 8;

		display2(calculate(arr));
	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void display2(int[][] arr) {

		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.print("]");

		}
		System.out.println("]");
	}

	public static int[][] calculate(int[][] arr) {

		int[][] res = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {

				int cnt = 0;
				if (i - 1 >= 0)
					cnt += (arr[i - 1][j] == 1 ? 1 : 0);
				if (i + 1 < arr.length)
					cnt += (arr[i + 1][j] == 1 ? 1 : 0);
				if (j - 1 >= 0)
					cnt += (arr[i][j - 1] == 1 ? 1 : 0);
				if (j + 1 < arr[0].length)
					cnt += (arr[i][j + 1] == 1 ? 1 : 0);
				if (i - 1 >= 0 && j - 1 >= 0)
					cnt += (arr[i - 1][j - 1] == 1 ? 1 : 0);
				if (i - 1 >= 0 && j + 1 < arr[0].length)
					cnt += (arr[i - 1][j + 1] == 1 ? 1 : 0);
				if (i + 1 < arr.length && j - 1 >= 0)
					cnt += (arr[i + 1][j - 1] == 1 ? 1 : 0);
				if (i + 1 < arr.length && j + 1 < arr[0].length)
					cnt += (arr[i + 1][j + 1] == 1 ? 1 : 0);

				if (cnt < 2 || cnt > 3) {
					res[i][j] = 0;
				} else if (cnt == 3) {
					res[i][j] = 1;
				} else if (cnt == 2 || cnt == 3) {
					res[i][j] = (res[i][j] == 1 ? 1 : 0);
				}

			}
		}

		return res;

	}

	public void gameOfLife(int[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		int height = board.length, width = board[0].length;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int liveCount = getLiveCount(board, height, width, i, j);
				if (board[i][j] == 0)
					liveCount = liveCount == 3 ? 1 : 0;
				else
					liveCount = liveCount == 2 || liveCount == 3 ? 1 : 0;
				// Add the new state as the second bit
				board[i][j] += liveCount << 1;
			}
		}
		// Remove all the old states
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				board[i][j] >>= 1;
	}

	public int getLiveCount(int[][] board, int height, int width, int h, int w) {
		int liveCount = 0;
		for (int i = h - 1; i < h + 2; i++) {
			for (int j = w - 1; j < w + 2; j++) {
				// When it's out of range, of it's the current cell itself, ignore
				if (i < 0 || i > height - 1 || j < 0 || j > width - 1 || (i == h && j == w))
					continue;
				// Use the old state
				liveCount += board[i][j] % 2;
			}
		}
		return liveCount;
	}

}
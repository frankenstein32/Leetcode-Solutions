import java.util.*;

public class binomial_triangle{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		System.out.println(print_1(n));
		System.out.println(print_2(n));
		System.out.println(print_3(n));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<List<Integer>> print_1(int numRows){

		List<List<Integer>> mat = new ArrayList<>();

		for(int line = 0;line < numRows;line++){

			ArrayList<Integer> row = new ArrayList<>();

			for(int col = 0;col <= line;col++){

				int coeff = coeff(line,col);
				row.add(coeff);
			}

			mat.add(row);
		}

		return mat;

		
	}

	public static List<List<Integer>> print_2(int numRows){

		int[][] mat = new int[numRows][numRows];
		List<List<Integer>> ans = new ArrayList<>();

		for(int line = 0;line < numRows;line++){

			ArrayList<Integer> row = new ArrayList<>();

			for(int i = 0;i <= line;i++){

				if(line == i || i == 0){
					mat[line][i] = 1;
					row.add(mat[line][i]);
					continue;
				}

				mat[line][i] = mat[line - 1][i - 1] + mat[line - 1][i];
				row.add(mat[line][i]);
			}
			ans.add(row);
		}

		return ans;

	}

	public static List<List<Integer>> print_3(int numRows){

		List<List<Integer>> ans = new ArrayList<>();

		

		for(int line = 1;line <= numRows;line++){
			int coeff = 1;
			ArrayList<Integer> row = new ArrayList<>();

			for(int i = 1;i <= line;i++){

				row.add(coeff);
				coeff = coeff * (line - i)/i;
			}
			ans.add(row);
		}

		return ans;

	}

	public static int coeff(int n,int k){

		if(k > n - k){
			k = n - k;
		}

		int res = 1;

		for(int i = 0;i < k;i++){

			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}
}
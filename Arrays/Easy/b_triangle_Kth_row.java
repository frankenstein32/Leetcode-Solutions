import java.util.*;

public class b_triangle_Kth_row{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		System.out.println(print(n));
		System.out.println(print_3(n));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static List<Integer> print(int numRows){

			ArrayList<Integer> row = new ArrayList<>();

			for(int col = 0;col <= numRows;col++){

				int coeff = coeff(numRows,col);
				row.add(coeff);
			}
		

		return row;
		
	}

	public static List<Integer> print_3(int numRows){

			int coeff = 1;
			ArrayList<Integer> row = new ArrayList<>();

			for(int i = 1;i <= numRows;i++){

				row.add(coeff);
				coeff = coeff * (numRows + 1 - i)/i;
		}

		return row;

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
import java.util.*;

public class Reshape{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr = {{ 1, 2, 3},{4, 5, 6},{ 7, 8, 9},{10, 11, 12},{13, 14, 15},{16, 17, 18}};
		// display2(arr);
		display2(matrixReshape(arr,2,9));
		display2(matrixReshape_eff(arr,2,9));
		display2(matrixReshape_eff2(arr,2,9));

	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

 	public static void display2(int[][] arr){

 		System.out.print("{");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print("{ ");
 			for(int j = 0;j < arr[i].length;j++){
 				System.out.print(arr[i][j]+" ");
 			}
 			System.out.print("}");
 		}
 		System.out.println("}");
 		
 	}

	public static int[][] matrixReshape(int[][] nums,int r,int c){

		int m = nums.length;
		int n = nums[0].length;

		System.out.println(m+" "+n+":"+r+" "+c);
		if(m * n != r * c)
			return nums;

		int[][] ans = new int[r][c];

		ArrayList<Integer> dummy = new ArrayList<>();
		int one = 0;
		int two = 0;
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				dummy.add(nums[i][j]);
			}
		}

		int k = 0;
		for(int i = 0;i < r;i++){
			for(int j = 0;j < c;j++){

				ans[i][j] = dummy.get(k++);
			}
		}

		return ans;
	
	}

	public static int[][] matrixReshape_eff(int[][] nums,int r,int c){

		int m = nums.length;
		int n = nums[0].length;
		if(m * n != r * c)
			return nums;

		int[][] ans = new int[r][c];

		int one = 0;
		int two = 0;

		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){

				ans[one][two] = nums[i][j];
				two++;
				if(two == c){
					one++;
					two = 0;
				}
			}
		}

		return ans;
	
	}
	public static int[][] matrixReshape_eff2(int[][] nums,int r,int c){

		int m = nums.length;
		int n = nums[0].length;
		if(m * n != r * c)
			return nums;

		int[][] ans = new int[r][c];

		int count = 0;

		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){

				ans[count / c][count % c] = nums[i][j];
				count++;
			}
		}

		return ans;
	
	}

		
}

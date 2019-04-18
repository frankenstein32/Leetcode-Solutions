import java.util.*;

public class ArithmeticSlices{

	public static void main(String[] args){

		int[] arr = {1, 2, 3, 4, 5, 6};
		count(arr);
	}

	public static void count(int[] arr){

		int[] strg = new int[arr.length];

		System.out.println(helperBU_EFF(arr));
		System.out.println(helperBU(arr));
		Arrays.fill(strg, -1);
		sum = 0;
		helperTD(arr,0, strg);
		System.out.println("TD: "+sum);
		sum = 0;
	 	helper(arr, 0);
	 	System.out.println("Rec: "+sum);
		
	}

	static int sum = 0;
	public static int helper(int[] arr, int vidx){


		if(vidx + 2 >= arr.length){

			return 0;
		}

		int inc = 0, exc = 0; 

		if(arr[vidx + 1] - arr[vidx] == arr[vidx + 2] - arr[vidx + 1]){

			inc = helper(arr, vidx + 1) + 1;
			sum += inc;
		}else{
			helper(arr, vidx + 1) ;
		}

		return inc;
	}

	public static int helperTD(int[] arr, int vidx, int[] strg){


		if(vidx + 2 >= arr.length){

			return 0;
		}

		if(strg[vidx] != -1){
			return strg[vidx];
		}

		int inc = 0, exc = 0; 

		if(arr[vidx + 1] - arr[vidx] == arr[vidx + 2] - arr[vidx + 1]){

			inc = helperTD(arr, vidx + 1, strg) + 1;
			sum += inc;
		}else{
			helperTD(arr, vidx + 1, strg) ;
		}

		return strg[vidx] = inc;
	}

	public static int helperBU(int[] arr){

		int[] strg = new int[arr.length + 1];

		int sum = 0;
		for(int i = arr.length - 3;i >= 0;i--){

			int inc = 0;
			if(arr[i + 1] - arr[i] == arr[i + 2] - arr[i + 1]){

				inc = strg[i + 1] + 1;
				strg[i] = inc;
				sum += inc;
			}

		}

		return sum;
	}

	public static int helperBU_EFF(int[] arr){


		int strg = 0;
		int sum  = 0;
		for(int i = arr.length - 3;i >= 0;i--){

			int inc = 0;

			if(arr[i + 1] - arr[i] == arr[i + 2] - arr[i +  1]){


				strg = strg + 1;
				sum += strg;
			}else{
				strg = 0;
			}
		}

		return sum;
	}

	public static int helperBU_EFF_EFF(int[] arr){

		int count = 0;
		int sum  = 0;
		for(int i = arr.length - 3;i >= 0;i--){

			int inc = 0;

			if(arr[i + 1] - arr[i] == arr[i + 2] - arr[i +  1]){

				count++;
			}else{
				
				sum += count * (count + 1) / 2;
				count = 0;
			}
		}

		return sum;

	}


	//How to render this Result
	public static int helper2(int[] arr, int vidx){


		if(vidx + 2 >= arr.length){

			return 0;
		}

		int inc = 0, exc = 0; 

		if(arr[vidx + 1] - arr[vidx] == arr[vidx + 2] - arr[vidx + 1]){

			inc = helper2(arr, vidx + 1) + 1;
		}

		
		exc = helper2(arr, vidx + 1) ;

		return Math.max(inc,exc);
	}
	 
	public static void display(int[] arr){


			for(int ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
	}

	public static void display(int[][] arr){


		for(int[] val : arr){

			for(int ele : val){
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		
	}

	
}
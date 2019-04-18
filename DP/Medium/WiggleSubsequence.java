import java.util.*;

public class WiggleSubsequence{

	public static void main(String[] args){

		// Main
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(maxLenSubseq(arr));

		
	}

	public static int maxLenSubseq(int[] arr){

		int[][] strg = new int[arr.length + 1][arr.length + 1];

		for(int[] val : strg){
			Arrays.fill(val, -1);
		}

		System.out.println(helperTD(arr,-1,0,strg));
		return helper(arr, -1, 0);
	}

	public static int helper(int[] arr, int previndex, int currPos){

		if(currPos >= arr.length - 1){

			return 1;
		}


		boolean self = false;
		if(previndex != -1 && arr[currPos] - arr[previndex] > 0 && arr[currPos + 1] - arr[currPos] < 0){

			self = true;

		}else if(previndex != -1 && arr[currPos] - arr[previndex] < 0 && arr[currPos + 1] - arr[currPos] > 0){

			self = true;
		}

		int inc = 0, exc = 0;
		if(previndex == -1 || self){
			inc = helper(arr, currPos, currPos + 1) + 1;
		}
		
		exc = helper(arr, previndex, currPos + 1);

		return Math.max(inc, exc);

	}

	public static int helperTD(int[] arr, int previndex, int currPos, int[][] strg){

		if(currPos >= arr.length - 1){

			if(arr[currPos] != arr[previndex])
				return 1;
			else
				return 0;
		}

		if(strg[previndex + 1][currPos] != -1){
			return strg[previndex][currPos];
		}


		boolean self = false;
		if(previndex != -1 && arr[currPos] - arr[previndex] > 0 && arr[currPos + 1] - arr[currPos] < 0){

			self = true;

		}else if(previndex != -1 && arr[currPos] - arr[previndex] < 0 && arr[currPos + 1] - arr[currPos] > 0){

			self = true;
		}

		int inc = 0, exc = 0;
		if(previndex == -1 || self){
			inc = helperTD(arr, currPos, currPos + 1, strg) + 1;
		}
		
		exc = helperTD(arr, previndex, currPos + 1, strg);

		strg[previndex + 1][currPos] = Math.max(inc, exc);

		return Math.max(inc, exc);

	}

	//Bottom Up not Done as greedy Already Exists

	public static int greedy(int[] arr){

		if(arr.length < 2){
			return arr.length;
		}


		int prevIndex = arr[1] - arr[0];

		int count = (previndex == 0? 1: 2);

		for(int i = 2;i < arr.length;i++){

			int diff = arr[i] - arr[i - 1];

			if((diff > 0 && previndex <= 0) || (diff < 0) && previndex >= 0){
				count++;
				previndex = diff;
			}
		}


		return count;
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
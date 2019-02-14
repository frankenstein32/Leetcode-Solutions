import java.util.*;

public class Triangle{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {3, 1};
		int target = 1;

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		res.add(2);
		ans.add(res);
		res = new ArrayList<>();
		res.add(3);
		res.add(4);
		ans.add(res);
		res = new ArrayList<>();
		res.add(6);
		res.add(5);
		res.add(7);
		ans.add(res);
		res = new ArrayList<>();
		res.add(4);
		res.add(1);
		res.add(8);
		res.add(3);
		ans.add(res);
		System.out.println(ans);
		System.out.println(minimumTotal(ans));
		// display(arr);
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static void display2(int[][] arr){

 		System.out.print("[");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print("[");
 			for(int j = 0;j < arr[0].length;j++)
 			System.out.print(arr[i][j] +" ");
 		System.out.print("]");
 		
 		}
 		System.out.println("]");
 	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> nums){


		System.out.println(helperBU(nums));
		System.out.println(helperBU_Eff(nums));
		return helper(nums,0,0,new int[nums.size()][nums.size()]);

	}

	public static int helper(ArrayList<ArrayList<Integer>>  arr,int cr,int cc,int[][] strg){

		if(cr == arr.size() - 1){
			return arr.get(cr).get(cc);
		}

		if(strg[cr][cc] != 0){
			return strg[cr][cc];
		}


		int left = helper(arr,cr + 1,cc,strg);
		int right = helper(arr,cr + 1,cc + 1,strg);

		int ans = Math.min(left,right) + arr.get(cr).get(cc);
		strg[cr][cc] = ans;
		return ans;
	}

	public static int helperBU(ArrayList<ArrayList<Integer>>  arr){

		int[][] strg = new int[arr.size()][arr.size() + 1];

		for(int[] val : strg)
			Arrays.fill(val,Integer.MAX_VALUE);

		for(int i = arr.size() - 1;i >= 0;i--){

			for(int j = arr.get(i).size() - 1; j >= 0;j--){

				if(i == arr.size() - 1){
					strg[i][j] = arr.get(i).get(j);
					// display2(strg);
					continue;
				}

				int path1 = strg[i + 1][j];
				int path2 = strg[i + 1][j + 1];

				int ans = Math.min(path1,path2) + arr.get(i).get(j);

				strg[i][j] = ans;
				// display2(strg);
			}
		}

		display2(strg);
		return strg[0][0];
	}	

	public static int helperBU_Eff(ArrayList<ArrayList<Integer>>  arr){

		int[] strg = new int[arr.size() + 1];

		int next = Integer.MAX_VALUE;

		Arrays.fill(strg,Integer.MAX_VALUE);

		for(int i = arr.size() - 1;i >= 0;i--){

			for(int j = arr.get(i).size() - 1; j >= 0;j--){

				if(i == arr.size() - 1){
					strg[j] = arr.get(i).get(j);
					continue;
				}
				
				int path1 = strg[j];
				int path2 = next;
				next = strg[j];

				int ans = Math.min(path1,path2) + arr.get(i).get(j);
				strg[j] = ans;
				
				// display(strg);
			}
			display(strg);
		}

		display(strg);
		return strg[0];
	}	
} 
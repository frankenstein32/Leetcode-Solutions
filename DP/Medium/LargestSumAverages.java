import java.util.*;

public class LargestSumAverages{

	public static void main(String[] args){

		int[] nums = {9, 1, 2, 3, 9};
		int k = 3;
		System.out.println(largestSum(nums ,k));
		
	}

	public static double largestSum(int[] nums, int k){


		System.out.println(helperBU(nums, k));
		System.out.println(helperTD(nums, 0, nums.length, k, new double[k + 1][nums.length + 1][nums.length + 1]));
		return helper(nums,0, nums.length,k);
	}

	public static double helper(int[] psum, int left, int right, int group){

		double ans = 0;

		for(int i = left; i < right;i++){
			ans += psum[i];
		}


		ans /= (right - left);

		if(group == 1){
			return ans;
		}

		for(int i = left + 1;i < right;i++){
			for(int k = 1;k < group;k++){

				ans = Math.max(ans, helper(psum, left, i, k) + helper(psum, i, right, group - k));
			}
		}

		return ans;
	}


	public static double helperTD(int[] psum, int left, int right, int group, double[][][] strg){

		if(strg[group][left][right] != 0){
			return strg[group][left][right];
		}

		double ans = 0;

		for(int i = left; i < right;i++){
			ans += psum[i];
		}


		ans /= (right - left);

		if(group == 1){
			return ans;
		}

		for(int i = left + 1;i < right;i++){
			for(int k = 1;k < group;k++){

				ans = Math.max(ans, helperTD(psum, left, i, k,strg) + helperTD(psum, i, right, group - k,strg));
			}
		}

		return strg[group][left][right] = ans;
	}

	public static double helperBU(int[] nums, int group){

		double[][][] strg = new double[group + 1][nums.length + 1][nums.length + 1];

		for(int k = 1; k < group;k++){


			for(int slide = 1;slide < nums.length;slide++){

				for(int left = 0; left <= nums.length - slide;left++){

					int right = left + slide;
					double ans = 0;

					for(int i = left; i < right;i++){
						ans += nums[i];
					}


					ans /= (right - left);

					if(k == 1){
						strg[k][left][right] = ans;
						continue;
					}
					
					for(int i = 1; i < right;i++){

						ans = Math.max(ans, strg[k][left][i] + strg[group - k][i][right]);

					}

					strg[k][left][right] = ans;
				}
			}
		}

		display(strg);
		return strg[group][0][nums.length - 1];
	}

	 public double largestSumOfAverages(int[] A, int K) {
        double[] sum = new double[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        return helper(sum, A.length, K, 1, 0, new Double[A.length + 1][A.length + 1][K + 1]);
    }
    
    public double helper(double[] sum, int n, int K, int curr, int prev, Double[][][] memo) {
        if (curr == n + 1) {   // base case 1
            return 0.0;
        }
        if (K == 1) {   // base case 2
            return (sum[n] - sum[curr - 1]) / (n - curr + 1);
        }
        if (memo[curr][prev][K] != null) {
            return memo[curr][prev][K];
        }
        return memo[curr][prev][K] = Math.max((sum[curr] - sum[prev]) / (curr - prev) + helper(sum, n, K - 1, curr + 1, curr, memo), 
                                        helper(sum, n, K, curr + 1, prev, memo));
    }


	public static void display(double[][][] arr){


		for(int i = 0; i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++){
				for(int k = 0;k < arr[0][0].length;k++){
					double value = arr[i][j][k];
					System.out.print(value +" ");
				}

				System.out.println();
			}
			System.out.println("**********");
		}
	}
	

	public static void display(double[] arr){


			for(double ele : arr){
				System.out.print(ele + " ");
			}
			System.out.println();
		
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
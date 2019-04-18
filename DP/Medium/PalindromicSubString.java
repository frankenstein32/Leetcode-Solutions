import java.util.*;

public class PalindromicSubString{

	public static void main(String[] args){

		String str = "abc";
		System.out.println(countSubString(str));
		

	}

	public static void display(int[][] piles){

		for(int[] pile : piles){

			for(int stone : pile){
				System.out.print(stone +"\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int countSubString(String str) {


		return helper(str);

	}

	public static int helper(String str){

		int cnt = 0;

		for(int axis = 0;axis < str.length();axis++){

			for(int orbit = 0;(axis + orbit) < str.length() && (axis - orbit) >= 0;orbit++){

				if(str.charAt(axis + orbit) == str.charAt(axis - orbit)){
					cnt++;
				}else{
					break;
				}
			}
		}

		for(double axis = 0.5;axis < str.length();axis++){

			for(double orbit = 0.5; orbit + axis < str.length() && axis - orbit >= 0;orbit++){

				if(str.charAt((int)(axis + orbit)) == str.charAt((int)(axis - orbit))){
					cnt++;
				}else{
					break;
				}
			}
		}

		return cnt;
	}
}
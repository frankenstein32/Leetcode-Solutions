import java.util.*;

public class PalindromPartitioning{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {1, 2, 2};
		int target = 2;
		String str = "aab";
		System.out.println(caculate(str));
		// display(productExceptSelf_Eff(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

 	public static List<List<String>> caculate(String str){

 		List<List<String>> ans = new ArrayList<>();
 		calculate(str, 0,ans,new ArrayList<>());
 		return ans;
	}

	public static void calculate(String str, int vidx, List<List<String>> ans, List<String> temp){

		System.out.println(vidx+" "+str.length());
		if(vidx == str.length()){
			ans.add(new ArrayList<>(temp));
			return;
		}

		for(int i = vidx; i < str.length();i++){

			if(isPalindrome(str,vidx,i)){

				temp.add(str.substring(vidx,i + 1));
				calculate(str,i + 1,ans,temp);
				temp.remove(temp.size() - 1);
			}
		}

	}

	public static boolean isPalindrome(String str, int lo,int hi){


		while(lo < hi){

			if(str.charAt(lo) != str.charAt(hi))
				return false;

			lo++;
			hi--;
		}

		return true;
	}
}
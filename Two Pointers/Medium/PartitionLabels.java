import java.util.*;

public class PartitionLabels{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		String name = "alex";
		String typed = "aalleexx";
		System.out.println(find(name, typed));
		
	}

 	public static void display(char[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static String find(String S, List<String> d){

		

		Collections.sort(d, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2){

				return s2.length() != s2.length()? s2.length() - s1.length() : s1.compareTo(s2);
			}
		});

		for(String str : d){

			if(isSubsequence(str,s)){

				return str;
			}

			return "";
		}

	}	

	public static String find_Eff(String S, List<String> d){

		String maxStr = "";
		for(String str : d){

			if(isSubsequence(str,s)){

				if(str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr))){

					maxStr = str;
				}
				
			}

			return maxStr;
		}

	}	

	public static boolean isSubsequence(String x, String y){

		int j = 0;

		for(int i = 0;i < y.length() && j < x.length();i++){


			if(x.charAt(j) == y.charAt(i)){
				j++;
			}
		}

		return j == x.length();
	}
}
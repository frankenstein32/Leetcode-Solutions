import java.util.*;

public class SummaryRanges{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {0,2,3,4,6,8,9};
		int target = 7;
		System.out.println(summaryRanges(arr));
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static List<String> summaryRanges(int[] arr){


		int i = 0;
		int j = 0;
		List<String> res = new ArrayList<>();

		while(j < arr.length - 1){


			if(arr[j] + 1 != arr[j + 1] && i != j){

				res.add(arr[i]+"->"+arr[j]);
				i = j + 1;
			}else if(arr[j] + 1 != arr[j + 1] && i == j){
				res.add(arr[i]+"");
				i++;
			}

			j++;
		}

		if(i < arr.length && j < arr.length && i == j){
			res.add(arr[i]+"");
		}else if(i < arr.length && j < arr.length && i != j){
			res.add(arr[i]+"->"+arr[j]);
		}
		System.out.println(i+" "+j);

		return res;


	}
	
}
import java.util.*;

public class FiboSeq{

	public static void main(String[] args){


		int n = 1;
		int k = 1;

		System.out.println(readWatch(1));

	}

	public static List<String> splitIntoFibonacci(String s){




	}

	public static List<String> splitIntoFibonacci(char[] arr, int si, int ei){

		if(ei - si + 1 <= 2){

			List<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		List<String> mr = new ArrayList<>();

		for(int i = si;i <= ei;i++){

			splitIntoFibonacci(arr,si, i);
			splitIntoFibonacci(arr,i + 1, ei);
		}

	}

	public static boolean isFibo(char[] ch, int si, int ei){

		if(ei - si + 1 <= 2){

			return false;
		}

		for(int i = 0; i <= ch.length - 3;i++){

			int a = ch[i] - '0';
			int b = ch[i + 1] - '0';
			int sum = ch[i + 2] - '0';

			if(a + b != sum){

				return false;
			}

		}

		return true;

	}
	
}
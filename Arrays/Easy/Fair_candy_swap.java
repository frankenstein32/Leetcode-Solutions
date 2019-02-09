import java.util.*;

public class  Fair_candy_swap{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] arr1 ={ 1, 2 };
		int[] arr2 ={ 2, 3 };
		int k = 4;
		// display2(arr);
		
		display(fairCandySwap(arr1,arr2));
	}

 	public static void display(int[] arr){


 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		}
 		System.out.println();
 	}

	public static int[] fairCandySwap(int[] arr1,int[] arr2){

		int sa = 0;
		int sb = 0;

		for(int val:arr1)
			sa += val;
		for(int val : arr2)
			sb += val;
		int delta = (sb - sa)/2;

		Set<Integer> setB = new HashSet<>();

		for(int val : arr2)
			setB.add(val);

		for(int val : arr1){

			if(setB.contains(val + delta)){
				return new int[]{val,val + delta};
			}
		}

		throw null;

	}


	
		
}

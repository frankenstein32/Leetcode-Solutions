import java.util.*;

public class SortColors{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		// int n = scn.nextInt();
		int[] arr = {2, 0, 2, 1, 1, 0};

		sort(arr);
		display(arr);
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static void sort(int[] nums){

		int red = 0;
		int white = 0;
		int blue = 0;
			
		for(int val : nums){

			if(val == 0){
				red++;
			}else if(val == 1){
				white++;
			}else{
				blue++;
			}
		}

		int i = 0;
		while(red > 0){
			nums[i++] = 0;
			red--;
		}

		while(white > 0){
			nums[i++] = 1;
			white--;
		}

		while(blue > 0){
			nums[i++] = 2;
			blue--;
		}

	}


	
}
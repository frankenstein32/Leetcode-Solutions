import java.util.*;

public class GuessNumber{

	public static void main(String[] args){

		// No Main
		
	}

	public static int find(int n){

	
		int left = 0;
		int right = n;


		while(left <= right){


			int mid = left + (right - left) / 2;
			int val = guess(mid);

			if(val == 0){
				return mid;
			}else if(val == -1){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
	}



	

	
}
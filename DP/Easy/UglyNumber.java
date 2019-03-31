import java.util.*;

public class UglyNumber{

	public static void main(String[] args){

		int num = 7;
		System.out.println(isUgly(num));
		
	}

	public static boolean isUgly(int num){


		return helper(num);
	}

	public static boolean helper(int num){


		if( num == 1){
			return true;
		}

		if(num % 2 == 0){

			return helper(num/2);
		}else if(num % 3 == 0){
			return helper(num/3);
		}else if(num % 5 == 0){
			return helper(num/5);
		}else{
			return false;
		}
	}



}
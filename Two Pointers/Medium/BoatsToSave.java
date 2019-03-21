import java.util.*;
import java.awt.Point;
public class BoatsToSave{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] people = {3,5,3,4};

		System.out.println(numRescueBoats(people,5));

	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int numRescueBoats(int[] people, int limit){

		Arrays.sort(people);

		int i = 0;
		int j = people.length - 1;
		int cnt = 0;

		while(i <= j){

			cnt++;
			if(people[i] + people[j] <= limit){
				i++;
			}

			j--;
		}

		return cnt;
	}

	
}
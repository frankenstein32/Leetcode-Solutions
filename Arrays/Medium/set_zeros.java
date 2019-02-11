import java.util.*;

public class set_zeros{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,1},{1,0,1},{1,1,1}};
		int k = 4;
		// display2(arr);
		
		setZeroes(arr);
		display2(arr);

	}

 	public static void display2(int[][] arr){

 		System.out.print("[");
 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print("[");
 			for(int j = 0;j < arr[0].length;j++)
 			System.out.print(arr[i][j] +" ");
 		System.out.print("]");
 		
 		}
 		System.out.println("]");
 	}

 	public static void setZeroes(int[][] arr){

 		Set<Integer> row = new HashSet<>();
 		Set<Integer> col = new HashSet<>();

 		for(int i = 0;i < arr.length;i++){

 			for(int j = 0;j < arr[0].length;j++){

 				if(arr[i][j] == 0){
 					row.add(i);
 					col.add(j);
 				}
 			}
 		}


 		for(int i = 0;i < arr.length;i++){

 			for(int j = 0; j < arr[0].length;j++){
 				if(row.contains(i) || col.contains(j)){
 					arr[i][j] = 0;
 				}
 			}
 		}	
 	} 
}

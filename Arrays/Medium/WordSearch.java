import java.util.*;

public class WordSearch{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		char[][] arr ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		int k = 4;
		// display2(arr);
		
		System.out.println(exist(arr,word))       ;

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

 	public static boolean exist(char[][] arr,String word){

 		
 		boolean ans = true;
 		for(int i = 0; i < arr.length;i++){
 			for(int j = 0;j < arr[0].length;j++){
 				boolean[][] visited = new boolean[arr.length][arr[0].length];
 				if(helper(arr,i,j,word,visited))
 					return true;
 			}
 		}
		return false;		

 	}

 	public static boolean helper(char[][] arr, int cr, int cc, String word, boolean[][] visited){

 		if(word.length() == 0){
 			return true;
 		}

 		if(cr < 0 || cc < 0 || cr >= arr.length || cc >= arr[0].length || visited[cr][cc])
 			return false;

 		char ch = word.charAt(0);

 		if(board[cr][cc] != ch){
 			return false;
 		}

 			visited[cr][cc] = true;
 			String ros = word.substring(1);
 			boolean rr = helper(arr,cr + 1,cc,ros,visited) || helper(arr,cr - 1,cc,ros,visited)
 			|| helper(arr,cr,cc - 1,ros,visited) || helper(arr,cr, cc + 1,ros,visited);

 			visited[cr][cc] = false;

 			return rr;
 		}
} 


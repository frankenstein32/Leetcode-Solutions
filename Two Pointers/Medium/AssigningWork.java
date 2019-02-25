import java.util.*;
import java.awt.Point;
public class AssigningWork{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[] d = {2, 4, 6, 8, 10};
		int[] p = {10, 20, 30, 40, 50};
		int[] w = {4, 5, 6, 7};

		System.out.println(MaxProfit(d,p,w));
		
	}

 	public static void display(int[] arr){

 		for(int i = 0 ;i < arr.length;i++){
 			System.out.print(arr[i] +" ");
 		} 
 		System.out.println();
 	}

	public static int MaxProfit(int[] d,int[] p, int[] w){

		int N = d.length;
		Point[] jobs = new Point[N];

		for(int i = 0;i < N;i++){
			jobs[i] = new Point(d[i],p[i]);
		}

		Arrays.sort(jobs,(a, b) -> a.x - b.x);
		Arrays.sort(w);

		String str = "";
		int i = 0;
		int maxProfit = 0;
		int profit = 0;
		for(int skill : w){

			while(i < N && jobs[i].x <= skill){
				profit = Math.max(profit,jobs[i].y);
				i++;
			}

			maxProfit += profit;
		}

		return maxProfit;
	}
	
}
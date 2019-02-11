import java.util.*;

public class MergeIntervals{
	
	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);

		int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
		int k = 4;
		// display2(arr);
		
		print(3);

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

 	public class Interval{

 		int start;
 		int end;

 		Interval(){start = 0;end = 0;}

 		Interval(int s, int e){start = s;end = e;}
 	}

 	private class Inter_comp implements Comparator<Interval>{

 		@Override
 		public int compare(Interval a, Interval b){

 			 return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
 		}
 	}
    public List<Interval> merge(List<Interval> intervals) {
            
        Collections.sort(intervals,new Inter_comp());

 		LinkedList<Interval> merged = new LinkedList<>();

 		for(Interval interval : intervals){

 			if(merged.isEmpty() || merged.getLast().end < interval.start){

 				merged.add(interval);
 			}else{

 				merged.getLast().end = Math.max(merged.getLast().end,interval.end);
 			}
 		}
 		return merged;
}

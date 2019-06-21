import java.util.*;

class findMinArrowShots{

   public int[][] eraseOverlapIntervals(int[][] intervals){


    Arrays.sort(intervals, new Comparator<int[]>(){

        @Override
        public int compare(int[] a, int[] b){

            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        }
    });

   int count = 0;
   int end = intervals[0][1];

   for(int i = 1;i < intervals.length;i++){

        if(intervals[i][0] >= end){
            end = intervals[i][1];
            count++;
        }
   }

   return intervals.length - count;

   }
}



	
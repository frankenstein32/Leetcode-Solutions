import java.util.*;

class NonOverLappingIntervals{

   public int[][] eraseOverlapIntervals(int[][] intervals){


    Arrays.sort(intervals, new Comparator<int[]>(){

        @Override
        public int compare(int[] a, int[] b){

            return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
        }
    });

    for(int[] arr : intervals){

        for(int val : arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }


   }
}



	
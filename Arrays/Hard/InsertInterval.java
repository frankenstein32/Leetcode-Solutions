import java.util.*;

public class InsertInterval{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {100, 4, 200, 1, 3, 2};
        int target = 2;
        System.out.println(insert(arr));
        // display(productExceptSelf_Eff(arr));
    }

    public static void display(int[] arr){

        for(int i = 0 ;i < arr.length;i++){
            System.out.print(arr[i] +" ");
        } 
        System.out.println();
    }

    private class Interval{

      int start;
      int end;

      public Interval(){
        this.start = 0;
        this.end = 0;
      }

      public Interval(int start, int end){
        this.start = start;
        this.end = end;
      }
    }

     public static List<List<Interval>> insert(List<List<Integer>> nums, Interval interval) {

        ArrayList<Interval> ans = new ArrayList<>();
        boolean added = false;
      for(Interval val : nums){

        int start = val.start;
        int end = val.end;

        if((newInterval.start > start || newInterval.end < end) && added){

          Interval narr = new Interval(Math.min(start,newInterval.start),Math.max(end,newInterval.end));
          ans.add(narr);
            added = true;
        }else{
          ans.add(val);
        }

      }

      return ans;


      


    }

    
}
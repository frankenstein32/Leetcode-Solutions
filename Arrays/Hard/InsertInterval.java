import java.util.*;

public class InsertInterval{
    
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        int[] arr = {100, 4, 200, 1, 3, 2};
        ArrayList<Interval> nums = new ArrayList<>();
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

     public static List<Interval> insert(List<Interval> nums, Interval newinterval) {

     
        if(nums.size() == 0 || nums == null){

         List<Interval> br = new ArrayList<>();
         br.add(newinterval);
          return br;
        }

        List<Interval> res = new ArrayList<>();

        int i = 0;
        int start = newinterval.start;
        int end = newinterval.end;

        while(i < nums.size() && nums.get(i).end < newinterval.start){
          res.add(nums.get(i));
          i++;
        }

        if(i < nums.size() && nums.get(i).start <= newinterval.end){

          start = Math.min(nums.get(i).start,start);
          end = Math.max(nums.get(i).end,end);

          while(i < nums.size() && nums.get(i).start <= end){
            i++;
          }

          end = Math.max(nums.get(i - 1).end,end);

        }

        res.add(new Interval(start,end));
        while(i < nums.size()){
          res.add(nums.get(i));
          i++;
        }

        return res;

    }

    
}